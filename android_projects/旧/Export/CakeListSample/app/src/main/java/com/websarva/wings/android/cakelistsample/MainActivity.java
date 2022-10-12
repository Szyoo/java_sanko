package com.websarva.wings.android.cakelistsample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView cakeMenu = findViewById(R.id.cakeMenu);
        List<String> list = new ArrayList<>();
        String[] cake = {
                "ショートケーキ",
                "イチゴケーキ",
                "チョコレートケーキ",
                "ガトーショコラ",
                "ティラミス",
                "ザッハトルテ",
                "チーズケーキ",
                "ベイクドチーズケーキ",
                "レアチーズケーキ",
                "スフレチーズケーキ",
                "ニューヨークチーズケーキ",
                "ミルフィーユ",
                "ミルクレープ",
                "ムースケーキ",
                "シフォンケーキ",
                "パウンドケーキ",
                "フルーツタルト",
                "クリスマスケーキ",
                "ロールケーキ",
                "ブッシュ・ド・ノエル",
                "モンブラン",
                "タルト"
        };
        for (String cakeName :
                cake) {
            list.add(cakeName);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, list);
        cakeMenu.setAdapter(adapter);
        cakeMenu.setOnItemClickListener(new ListItemClickListener());
    }

    private class ListItemClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String item = (String) parent.getItemAtPosition(position);
            OrderConfirmDialogFragment dialogFragment = new OrderConfirmDialogFragment();
            dialogFragment.setOrderItem(item);
            dialogFragment.show(getSupportFragmentManager(), "OrderConfirmDialogFragment");
        }
    }

}