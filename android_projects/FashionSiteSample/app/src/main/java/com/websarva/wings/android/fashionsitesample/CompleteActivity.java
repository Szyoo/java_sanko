package com.websarva.wings.android.fashionsitesample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CompleteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete);

        Intent intent = getIntent();
        String name = intent.getStringExtra("itemName");
        String price = intent.getStringExtra("itemPrice");
        TextView labelName = findViewById(R.id.labelName);
        TextView labelPrice = findViewById(R.id.labelPrice);

        labelName.setText(name);
        labelPrice.setText(price);
    }

    public void onBackButtonClick(View view) {
        finish();
    }
}
