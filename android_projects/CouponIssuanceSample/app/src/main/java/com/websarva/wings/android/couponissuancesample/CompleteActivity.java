package com.websarva.wings.android.couponissuancesample;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

public class CompleteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete);
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
}