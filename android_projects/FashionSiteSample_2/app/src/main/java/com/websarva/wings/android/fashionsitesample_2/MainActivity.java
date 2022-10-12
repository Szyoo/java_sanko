package com.websarva.wings.android.fashionsitesample_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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

        registerForContextMenu(_menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_options_menu_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        boolean value = true;
        switch (item.getItemId()) {
            case R.id.menuListOptionMain:
                _itemList = createList();
                break;
            case R.id.menuListOptionHat:
                _itemList = createHatList();
                break;
            default:
                value = super.onOptionsItemSelected(item);
                break;
        }
        SimpleAdapter adapter = new SimpleAdapter(MainActivity.this, _itemList, R.layout.row, FROM, TO);
        _menu.setAdapter(adapter);
        return value;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, view, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_context_menu_list, menu);
        menu.setHeaderTitle(R.string.menu_list_context_header);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        boolean value = true;
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int listPosition = info.position;
        Map<String, String> goods = _itemList.get(listPosition);

        switch(item.getItemId()) {
            case R.id.menuListContextDetail:
                String name = goods.get("name");
                String price = goods.get("price");
                Intent intent = new Intent(MainActivity.this, ConfirmActivity.class);
                intent.putExtra("itemName", name);
                intent.putExtra("itemPrice", price);
                startActivity(intent);
                break;
            case R.id.menuListContextPurchase:
                name = goods.get("name");
                price = goods.get("price");
                intent = new Intent(MainActivity.this, CompleteActivity.class);
                intent.putExtra("itemName", name);
                intent.putExtra("itemPrice", price);
                startActivity(intent);
                break;
            default:
                value = super.onContextItemSelected(item);
                break;
        }
        return value;
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

    private List<Map<String, String>> createHatList() {
        List<Map<String, String>> itemList = new ArrayList<>();

        String[] name = {"中折れハット", "ハンチング", "ニット帽", "カノチェ",
                "ストローハット", "カラフルキャップ", "キャスケット"};
        String[] price = {"price", "4000円", "1500円", "6200円", "1500円", "1600円",
                "1700円", "3100円"};

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


}