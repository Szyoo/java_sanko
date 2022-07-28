package com.websarva.wings.android.cakelistsample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lvCake = findViewById(R.id.lvCake);
        List<String> cakeList = new ArrayList<>();

        cakeList.add("ショートケーキ");
        cakeList.add("イチゴケーキ");
        cakeList.add("チョコレートケーキ");
        cakeList.add("ガトーショコラ");
        cakeList.add("ティラミス");
        cakeList.add("ザッハトルテ");
        cakeList.add("チーズケーキ");
        cakeList.add("ベイクドチーズケーキ");
        cakeList.add("レアチーズケーキ");
        cakeList.add("スフレチーズケーキ");
        cakeList.add("ニューヨークチーズケーキ");
        cakeList.add("ミルフィーユ");
        cakeList.add("ミルクレープ");
        cakeList.add("ムースケーキ");
        cakeList.add("シフォンケーキ");
        cakeList.add("パウンドケーキ");
        cakeList.add("フルーツタルト");
        cakeList.add("クリスマスケーキ");
        cakeList.add("ロールケーキ");
        cakeList.add("ブッシュ・ド・ノエル");
        cakeList.add("モンブラン");
        cakeList.add("タルト");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, cakeList);
        lvCake.setAdapter(adapter);
        lvCake.setOnItemClickListener(new ListItemClickListener());
    }

    // リストタップ時のリスナクラス
    private class ListItemClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            // タップされた文房具を取得
            String item = (String) parent.getItemAtPosition(position);
            // 注文確認ダイアログフラグメントオブジェクトを生成
            OrderConfirmDialogFragment dialogFragment = new OrderConfirmDialogFragment();
            // 注文したアイテムをダイアログに渡す
            dialogFragment.setOrderItem(item);
            // ダイアログ表示
            dialogFragment.show(getSupportFragmentManager(), "OrderConfirmDialogFragment");
        }
    }

}