package com.websarva.wings.android.householdaccountbooksample;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    // データベースヘルパーオブジェクト
    private DatabaseHelper _helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 保存ボタンを取得
        Button btSave = findViewById(R.id.btSave);
        // btSaveにリスナを登録
        btSave.setOnClickListener(new SaveButtonClickListener());
        // DBヘルパーオブジェクトを生成
        _helper = new DatabaseHelper(MainActivity.this);
        //入出金の履歴や残金の更新はonStart()の中ではなく、onCreate()の中でも今回はOK
//        // 入出金履歴を更新
//        updateHistory();
//        // 残金を更新
//        calculateRemainingMoney();
    }

    //【参考】onStart()はonCreate()の後に呼ばれビュー（画面）への情報登録などを行う
    //授業内では簡略化のためにonCreate()内で行うが、本当はビューへの情報の登録はonStart()で行う
    @Override
    protected void onStart() {
        super.onStart();

        // 入出金履歴を更新
        updateHistory();
        // 残金を更新
        calculateRemainingMoney();
    }

    @Override
    protected void onDestroy() {
        // DBヘルパーオブジェクトの解放
        _helper.close();
        super.onDestroy();
    }

    // 入力内容の保存処理
    private void save() {
        // コメント入力欄と金額入力欄を取得
        EditText etComment = findViewById(R.id.etComment);
        EditText etMoney = findViewById(R.id.etMoney);
        // 入力内容を文字列で取得
        String commentStr = etComment.getText().toString();
        String moneyStr = etMoney.getText().toString();

        // データベースヘルパーオブジェクトからデータベース接続オブジェクトを取得
        SQLiteDatabase db = _helper.getWritableDatabase();

        // インサート用SQL文字列の用意
        String sqlInsert = "INSERT INTO householdAccountBook (_id, comment, money) VALUES (?, ?, ?)";
        // SQL文字列を元にプリペアドステートメントを取得
        SQLiteStatement stmt = db.compileStatement(sqlInsert);
        // 変数のバインド
        stmt.bindString(2, commentStr);
        stmt.bindString(3, moneyStr);
        // インサートSQLの実行
        stmt.executeInsert();

        // 入力欄の入力値を消去。
        etComment.setText("");
        etMoney.setText("");
    }

    // 入出金履歴の更新処理
    private void updateHistory() {
        // データベースヘルパーオブジェクトからデータベース接続オブジェクトを取得。
        SQLiteDatabase db = _helper.getWritableDatabase();
        // 主キーによる検索候補SQL文字列の用意
        String sql = "SELECT * FROM householdAccountBook";
        //　SQLの実行
        Cursor cursor = db.rawQuery(sql, null);
        // データベースから取得した値を格納する変数の用意。データがなかったときのための初期化も用意
        List<Map<String, String>> recordList = new ArrayList<>();
        // SQL実行の戻り値であるカーソルオブジェクトをループさせてデータベース内のデータを取得
        while(cursor.moveToNext()) {
            // 値を格納するMapを作成
            Map<String, String> record = new HashMap<>();
            // コメントのカラムインデックス値を取得
            int idxComment = cursor.getColumnIndex("comment");
            // カラムのインデックス値を元に実際のデータを取得
            record.put("comment", cursor.getString(idxComment));
            // 金額のカラムインデックス値を取得
            int idxMoney = cursor.getColumnIndex("money");
            // カラムのインデックス値をもとに実際のデータを取得
            record.put("money", cursor.getString(idxMoney));
            // コメントと金額の入ったMapをリストに追加する
            recordList.add(record);
        }

        // SimpleAdapter第4引数from用データの用意
        String[] from = {"comment", "money"};
        // SimpleAdapter第5引数to用データの用意
        int[] to = {R.id.tvCommentRow, R.id.tvMoneyRow};
        // 履歴一覧のListViewを取得
        ListView lvHistory = findViewById(R.id.lvHistory);
        // アダプターオブジェクトを生成
        SimpleAdapter adapter = new SimpleAdapter(MainActivity.this, recordList, R.layout.row, from, to);
        // リストビューにアダプタオブジェクトを設定
        lvHistory.setAdapter(adapter);
    }

    // 残金を計算する
    private void calculateRemainingMoney() {
        // データベースヘルパーオブジェクトからデータベース接続オブジェクトを取得。
        SQLiteDatabase db = _helper.getWritableDatabase();
        // 主キーによる検索候補SQL文字列の用意
        String sql = "SELECT money FROM householdAccountBook";
        //　SQLの実行
        Cursor cursor = db.rawQuery(sql, null);
        // 残高の変数
        int remainingMoney = 0;
        // SQL実行の戻り値であるカーソルオブジェクトをループさせてデータベース内のデータを取得
        while(cursor.moveToNext()) {
            // 金額のカラムインデックス値を取得
            int idxMoney = cursor.getColumnIndex("money");
            // カラムのインデックス値をもとに実際のデータを取得
            String moneyStr = cursor.getString(idxMoney);
            // String型の金額をint型にパースする
            int money = Integer.parseInt(moneyStr);
            // 残高に加算
            remainingMoney += money;
        }

        String remainingMoneyStr = Integer.toString(remainingMoney);
        // 残金のTextViewを取得
        TextView tvRemainingMoney = findViewById(R.id.tvRemainingMoney);
        // TextViewに残金をセット
        tvRemainingMoney.setText(remainingMoneyStr);
    }

    // 「保存」ボタンがタップされたときの処理が記述されたメンバクラス
    private class SaveButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            // 保存処理を実行
            save();
            // 入出金履歴を更新
            updateHistory();
            // 残金を更新
            calculateRemainingMoney();
        }
    }
}