package com.websarva.wings.android.fashionsitesample

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class ConfirmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.w("FashonSiteSample", "MainActivity:onCreate() called.");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_confirmation);

        // インテントオブジェクトを取得
        Intent intent = getIntent();
        // リスト画面から渡されたデータを取得
        String itemName = intent.getStringExtra("itemName");
        String itemPrice = intent.getStringExtra("itemPrice");
        // 定食名と金額を表示させるTextViewを取得
        TextView tvItemName = findViewById(R.id.tvConfirmationItemName);
        TextView tvItemPrice = findViewById(R.id.tvConfirmationItemPrice);

        // TextViewに定食名と金額を表示
        tvItemName.setText(itemName);
        tvItemPrice.setText(itemPrice);
    }


    // 注文ボタンをタップされたときの処理
    public void onOrderButtonClick(View view) {
        // 確認画面のアイテム名と値段が格納されているTextViewを取得
        TextView tvItemName = findViewById(R.id.tvConfirmationItemName);
        TextView tvItemPrice = findViewById(R.id.tvConfirmationItemPrice);
        // TextViewからテキストの中身をString型にして取得
        String menuName = tvItemName.getText().toString();
        String menuPrice = tvItemPrice.getText().toString();
        // インテントオブジェクトを生成
        Intent intent = new Intent(OrderConfirmationActivity.this, CompleteActivity.class);
        // 第2引数に送るデータを格納
        intent.putExtra("itemName", menuName);
        intent.putExtra("itemPrice", menuPrice);
        // 第3画面の起動
        startActivity(intent);
    }

    // 戻るボタンをタップしたときの処理
    public void onBackButtonClick(View view) {
        finish();
    }
}