package com.websarva.wings.android.stationarylistsample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView lvStationary = findViewById(R.id.lvStationary);
        List<String> stationaryList = new ArrayList<>();
        stationaryList.add("鉛筆");
        stationaryList.add("色鉛筆");
        stationaryList.add("消しゴム");
        stationaryList.add("筆箱");
        stationaryList.add("絵具セット");
        stationaryList.add("習字セット");
        stationaryList.add("自由帳");
        stationaryList.add("メモ帳");
        stationaryList.add("ノート");
        stationaryList.add("トレーシングペーパー");
        stationaryList.add("画用紙");
        stationaryList.add("半紙");
        stationaryList.add("定規");
        stationaryList.add("コンパス");
        stationaryList.add("はさみ");
        stationaryList.add("液状のり");
        stationaryList.add("スティックのり");
        stationaryList.add("セロテープ");
        stationaryList.add("ガムテープ");
        stationaryList.add("クリップ");
        stationaryList.add("ホッチキス");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, stationaryList);
        lvStationary.setAdapter(adapter);

        lvStationary.setOnItemClickListener(new ListItemClickListener());
    }

    private class ListItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String item = (String) parent.getItemAtPosition(position);
//            String show = item + "が選択されました。";
//            Toast.makeText(MainActivity.this, show, Toast.LENGTH_LONG).show();

            OrderConfirmDialogFragment dialogFragment = new OrderConfirmDialogFragment();
            dialogFragment.setOrderItem(item);
            dialogFragment.show(getSupportFragmentManager(), "OrderConfirmDialogFragment");
        }
    }
}