package com.websarva.wings.android.fashionsitesample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private ListView _menu;
    private List<Map<String, String>> _itemList;
    private static final String[] FROM = {"name", "price"};
    private static final int[] TO = {R.id.labelNameRow, R.id.labelPriceRow};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.w("FashionSiteSample", "MainActivity:onCreate() called.");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _menu = findViewById(R.id.menu);
        _itemList = createList();
        SimpleAdapter adapter = new SimpleAdapter(MainActivity.this, _itemList, R.layout.row, FROM, TO);
        _menu.setAdapter(adapter);

        _menu.setOnItemClickListener(new ItemClickListener());
    }

    private List<Map<String, String>> createList() {
        List<Map<String, String>> itemList = new ArrayList<>();

        String[] name = {"ジャケット", "ダウンジャケット", "Tシャツ", "Yシャツ", "パーカー",
                "キャミソール", "タンクトップ", "ノースリーブニット", "リボン付きブラウス",
                "プルオーバー", "カットソー"};
        String[] price = {"2900円", "10000円", "1500円", "1900円", "4800円", "5400円",
                "2700円", "8900円", "15000円", "3000円", "4500円"};

        for (int i = 0; i < name.length; i++) {
            Map<String, String> item = new HashMap<>();
            item.put("name", name[i]);
            item.put("price", price[i]);
            itemList.add(item);
        }

        return itemList;
    }

    private class ItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Map<String, String> item = (Map<String, String>) parent.getItemAtPosition(position);
            String name = item.get("name");
            String price = item.get("price");
            Intent intent = new Intent(MainActivity.this, ConfirmActivity.class);
            intent.putExtra("itemName", name);
            intent.putExtra("itemPrice", price);
            startActivity(intent);
        }
    }

    public boolean
}