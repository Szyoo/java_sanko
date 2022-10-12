package com.websarva.wings.android.couponissuancesample;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();

        String itemName = intent.getStringExtra("name");
        int itemPrice = intent.getIntExtra("price", 0);
        int itemDiscount = intent.getIntExtra("discount", 0);

        TextView itemNameLabel = findViewById(R.id.itemNameLabel);
        TextView itemPriceLabel = findViewById(R.id.itemPriceLabel);
        TextView itemDiscountLabel = findViewById(R.id.itemDiscountLabel);
        TextView discountValueLabel = findViewById(R.id.discountValueLabel);

        double discount = 1 - (itemDiscount * 0.01);
        int discountValue = (int) (itemPrice * discount);

        itemNameLabel.setText(itemName);
        itemPriceLabel.setText(String.valueOf(itemPrice));
        itemDiscountLabel.setText(String.valueOf(itemDiscount));
        discountValueLabel.setText(String.valueOf(discountValue));

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
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

    public void onTicketingButtonClick(View view) {
        Intent intent = new Intent(DetailActivity.this, CompleteActivity.class);
        startActivity(intent);
    }
}