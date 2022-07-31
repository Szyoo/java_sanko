package com.websarva.wings.android.fashionsitesample

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class CompleteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.w("FashonSiteSample", "MainActivity:onCreate() called.");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_completed);

        // インテントオブジェクトを取得
        Intent intent = getIntent();
        // リスト画面から渡されたデータを取得
        String menuName = intent.getStringExtra("itemName");
        String menuPrice = intent.getStringExtra("itemPrice");
        // 定食名と金額を表示させるTextViewを取得
        TextView tvMenuName = findViewById(R.id.tvOrderItemName);
        TextView tvMenuPrice = findViewById(R.id.tvOrderItemPrice);

        // TextViewに定食名と金額を表示
        tvMenuName.setText(menuName);
        tvMenuPrice.setText(menuPrice);
    }

    // 戻るボタンをタップしたときの処理
    public void onBackButtonClick(View view) {
        finish();
    }
}