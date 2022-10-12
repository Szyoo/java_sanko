package com.websarva.wings.android.couponissuancesample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
    private List<Map<String, Object>> _itemList;
    private static final String[] FROM = {"name", "price", "discount"};
    private static final int[] TO = {R.id.itemNameRow, R.id.itemPriceRow, R.id.itemDiscountRow};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _menu = findViewById(R.id.menu);
        _itemList = createBoxLunchList();
        SimpleAdapter adapter = new SimpleAdapter(MainActivity.this, _itemList, R.layout.row, FROM, TO);
        _menu.setAdapter(adapter);

        _menu.setOnItemClickListener(new ListItemClickListener());

        registerForContextMenu(_menu);
    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_options_menu_list, menu);
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, view, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_context_menu_list, menu);
        menu.setHeaderTitle(R.string.menu_list_context_header);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        boolean value = true;
        switch (item.getItemId()) {
            case R.id.menuListOptionBox:
                _itemList = createBoxLunchList();
                break;
            case R.id.menuListOptionBread:
                _itemList = createBreadList();
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
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        boolean value = true;
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int listPosition = info.position;
        Map<String, Object> getItem = _itemList.get(listPosition);

        switch (item.getItemId()) {
            case R.id.menuListContextDetail:
                detail(getItem);
                break;
            case R.id.menuListContextTicketing:
                ticketing(getItem);
                break;
            default:
                value = super.onContextItemSelected(item);
                break;
        }
        return value;
    }

    private List<Map<String, Object>> createBoxLunchList() {
        List<Map<String, Object>> itemList = new ArrayList<>();

        String[] name = {"ハンバーグ弁当", "のり弁当", "幕の内弁当", "さばの塩焼き弁当", "さけの塩焼き弁当",
                "高菜弁当", "から揚げ弁当", "チキン南蛮弁当", "生姜焼き弁当",
                "チキン竜田弁当", "ロースかつ弁当", "野菜炒め弁当"};
        Object[] price = {590, 330, 590, 460, 540, 430, 390, 500, 500, 490, 520, 520};
        Object[] discount = {20, 10, 20, 10, 10, 10, 10, 10, 10, 10, 10, 10};

        for (int i = 0; i < name.length; i++) {
            Map<String, Object> item = new HashMap<>();
            item.put("name", name[i]);
            item.put("price", price[i]);
            item.put("discount", discount[i]);
            itemList.add(item);
        }

        return itemList;
    }

    private List<Map<String, Object>> createBreadList() {
        List<Map<String, Object>> itemList = new ArrayList<>();

        String[] name = {"ミルクパン", "あんパン", "クリームパン", "メロンパン", "レーズンパン",
                "チーズトースト", "フランスパン", "クルミパン", "ベーコンエピ",
                "カレーパン", "ホットドッグ"};
        Object[] price = {140, 162, 162, 216, 183, 140, 151, 172, 162, 237, 216};
        Object discount = 10;

        for (int i = 0; i < name.length; i++) {
            Map<String, Object> item = new HashMap<>();
            item.put("name", name[i]);
            item.put("price", price[i]);
            item.put("discount", discount);
            itemList.add(item);
        }

        return itemList;
    }

    private void detail(Map<String, Object> itemMap) {
        String name = (String) itemMap.get("name");
        Integer price = (Integer) itemMap.get("price");
        Integer discount = (Integer) itemMap.get("discount");
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        intent.putExtra("name", name);
        intent.putExtra("price", price);
        intent.putExtra("discount", discount);
        startActivity(intent);
    }

    private void ticketing(Map<String, Object> itemMap) {
        String name = (String) itemMap.get("name");
        Integer price = (Integer) itemMap.get("price");
        Integer discount = (Integer) itemMap.get("discount");
        Intent intent = new Intent(MainActivity.this, CompleteActivity.class);
        intent.putExtra("name", name);
        intent.putExtra("price", price);
        intent.putExtra("discount", discount);
        startActivity(intent);
    }

    private class ListItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Map<String, Object> itemMap = (Map<String, Object>) parent.getItemAtPosition(position);
            detail(itemMap);
        }
    }
}