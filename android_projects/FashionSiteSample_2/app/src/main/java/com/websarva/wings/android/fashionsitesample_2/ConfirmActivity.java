package com.websarva.wings.android.fashionsitesample_2;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
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

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        boolean value = true;
        int itemId = item.getItemId();
        if (itemId == android.R.id.home) {
            finish();
        } else {
            value = super.onOptionsItemSelected(item);
        }
        return value;
    }
}