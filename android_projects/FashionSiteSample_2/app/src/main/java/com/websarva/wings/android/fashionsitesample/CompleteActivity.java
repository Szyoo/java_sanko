package com.websarva.wings.android.fashionsitesample;

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
        setContentView(R.layout.activity_complete);

        Intent intent = getIntent();
        String name = intent.getStringExtra("itemName");
        String price = intent.getStringExtra("itemPrice");

        TextView labelName = findViewById(R.id.labelName);
        TextView labelPrice = findViewById(R.id.labelPrice);

        // TextViewに定食名と金額を表示
        labelName.setText(name);
        labelPrice.setText(price);
    }

    // 戻るボタンをタップしたときの処理
    public void onBackButtonClick(View view) {
        finish();
    }
}