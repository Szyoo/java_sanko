package com.websarva.wings.android.fashionsitesample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView menu = findViewById(R.id.menu);
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

        String[] from = {"name", "price"};
        int[] to = {android.R.id.text1, android.R.id.text2};
        SimpleAdapter adapter = new SimpleAdapter(MainActivity.this, itemList, android.R.layout.simple_list_item_2, from, to);
        menu.setAdapter(adapter);

        menu.setOnItemClickListener(new ListItemClickListener());
    }

    private class ListItemClickListener implements AdapterView.OnItemClickListener {
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
}