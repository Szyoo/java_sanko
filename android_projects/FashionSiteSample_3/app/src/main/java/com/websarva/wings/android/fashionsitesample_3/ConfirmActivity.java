package com.websarva.wings.android.fashionsitesample_3;

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
        setContentView(R.layout.activity_confirm);

        Intent intent = getIntent();

        String name = intent.getStringExtra("itemName");
        String price = intent.getStringExtra("itemPrice");

        TextView labelName = findViewById(R.id.labelName);
        TextView labelPrice = findViewById(R.id.labelPrice);

        labelName.setText(name);
        labelPrice.setText(price);
    }

    public void onConfirmButtonClick(View view) {
        TextView labelName = findViewById(R.id.labelName);
        TextView labelPrice = findViewById(R.id.labelPrice);

        String name = labelName.getText().toString();
        String price = labelPrice.getText().toString();

        Intent intent = new Intent(ConfirmActivity.this, CompleteActivity.class);

        intent.putExtra("itemName", name);
        intent.putExtra("itemPrice", price);

        startActivity(intent);
    }

    public void onBackButtonClick(View view) {
        finish();
    }
}