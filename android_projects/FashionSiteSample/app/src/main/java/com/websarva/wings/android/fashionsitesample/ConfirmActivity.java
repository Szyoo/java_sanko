package com.websarva.wings.android.fashionsitesample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ConfirmActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
        String getName = labelName.getText().toString();
        String getPrice = labelPrice.getText().toString();
        Intent intent = new Intent(ConfirmActivity.this, CompleteActivity.class);
        intent.putExtra("itemName", getName);
        intent.putExtra("itemPrice", getPrice);
        startActivity(intent);
    }

    public void onBackButtonClick(View view) {
        finish();
    }
}
