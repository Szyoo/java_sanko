package com.websarva.wings.android.teishokumenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.appbar.CollapsingToolbarLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setLogo(R.mipmap.ic_launcher);
        CollapsingToolbarLayout toolbarLayout = findViewById(R.id.toolbarLayout);
        toolbarLayout.setTitle(getString(R.string.toolbar_title));
        toolbarLayout.setExpandedTitleColor(Color.WHITE);
        toolbarLayout.setCollapsedTitleTextColor(Color.LTGRAY);
        RecyclerView lvMenu = findViewById(R.id.lvMenu);
        LinearLayoutManager layout = new LinearLayoutManager(MainActivity.this);
        lvMenu.setLayoutManager(layout);
        List<Map<String, Object>> menuList = createTeishokuList();
        RecyclerListAdapter adapter = new RecyclerListAdapter(menuList);
        lvMenu.setAdapter(adapter);
        DividerItemDecoration decorator = new DividerItemDecoration(MainActivity.this, layout.getOrientation());
        lvMenu.addItemDecoration(decorator);

    }

    private List<Map<String, Object>> createTeishokuList() {
        List<Map<String, Object>> menuList = new ArrayList<>();
        Map<String, Object> menu = new HashMap<>();
        menu.put("name", "から揚げ定食");
        menu.put("price", 800);
        menu.put("illust", R.drawable.food_karaage_lemon);
        menu.put("desc", "若鶏の唐揚げに\nサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);
        menu = new HashMap<>();
        menu.put("name", "ハンバーグ定食");
        menu.put("price", 850);
        menu.put("illust", R.drawable.food_wafu_hamburg);
        menu.put("desc", "手ごねハンバーグに\nサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);
        menu = new HashMap<>();
        menu.put("name", "生姜焼き定食");
        menu.put("price", 850);
        menu.put("illust", R.drawable.food_syougayaki);
        menu.put("desc", "豚の生姜焼きに\nサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);
        menu = new HashMap<>();
        menu.put("name", "ステーキ定食");
        menu.put("price", 1000);
        menu.put("illust", R.drawable.food_beefsteak);
        menu.put("desc", "サーロインステーキに\nサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);
        menu = new HashMap<>();
        menu.put("name", "野菜炒め定食");
        menu.put("price", 850);
        menu.put("illust", R.drawable.food_yasaiitame);
        menu.put("desc", "季節の野菜の炒め物に\nサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);
        menu = new HashMap<>();
        menu.put("name", "とんかつ定食");
        menu.put("price", 900);
        menu.put("illust", R.drawable.food_tonkatsu);
        menu.put("desc", "黒豚ロースのとんかつに\nサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);
        menu = new HashMap<>();
        menu.put("name", "ミンチかつ定食");
        menu.put("price", 850);
        menu.put("illust", R.drawable.food_korokke_menchi);
        menu.put("desc", "合い挽き肉のミンチかつに\nサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);
        menu = new HashMap<>();
        menu.put("name", "チキンカツ定食");
        menu.put("price", 900);
        menu.put("illust", R.drawable.food_chicken_nanban);
        menu.put("desc", "若鶏のチキンカツに\nサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);
        menu = new HashMap<>();
        menu.put("name", "コロッケ定食");
        menu.put("price", 850);
        menu.put("illust", R.drawable.food_croquette);
        menu.put("desc", "男爵芋のコロッケに\nサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);
        menu = new HashMap<>();
        menu.put("name", "回鍋肉定食");
        menu.put("price", 750);
        menu.put("illust", R.drawable.food_hoikoro);
        menu.put("desc", "本格回鍋肉に\nサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);
        menu = new HashMap<>();
        menu.put("name", "麻婆豆腐定食");
        menu.put("price", 800);
        menu.put("illust", R.drawable.food_mabo_doufu);
        menu.put("desc", "ピリリと辛い麻婆豆腐に\nサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);
        menu = new HashMap<>();
        menu.put("name", "青椒肉絲定食");
        menu.put("price", 850);
        menu.put("illust", R.drawable.food_chinjao_rosu);
        menu.put("desc", "本格青椒肉絲に\nサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);
        menu = new HashMap<>();
        menu.put("name", "焼き魚定食");
        menu.put("price", 750);
        menu.put("illust", R.drawable.wasyoku_yakizakana);
        menu.put("desc", "季節の焼き魚に\nサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);
        menu = new HashMap<>();
        menu.put("name", "焼肉定食");
        menu.put("price", 950);
        menu.put("illust", R.drawable.food_gyutan);
        menu.put("desc", "熱々の焼肉に\nサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);
        return menuList;
    }

    private class RecyclerListViewHolder extends RecyclerView.ViewHolder {
        public TextView _tvMenuNameRow;
        public TextView _tvMenuPriceRow;
        public ImageView _ivMenuIllustRow;
        public TextView _tvMenuDescRow;

        public RecyclerListViewHolder(View itemView) {
            super(itemView);
            _tvMenuNameRow = itemView.findViewById(R.id.tvMenuNameRow);
            _tvMenuPriceRow = itemView.findViewById(R.id.tvMenuPriceRow);
            _ivMenuIllustRow = itemView.findViewById(R.id.ivMenuIllustRow);
            _tvMenuDescRow = itemView.findViewById(R.id.tvMenuDescRow);
        }
    }

    private class RecyclerListAdapter extends RecyclerView.Adapter<RecyclerListViewHolder> {
        private List<Map<String, Object>> _listData;
        public  RecyclerListAdapter(List<Map<String, Object>> listData) {
            _listData = listData;
        }

        @NonNull
        @Override
        public RecyclerListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
            View view = inflater.inflate(R.layout.row, parent, false);
            view.setOnClickListener(new ItemClickListener());
            RecyclerListViewHolder holder = new RecyclerListViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerListViewHolder holder, int position) {
            Map<String, Object> item = _listData.get(position);
            String menuName = (String) item.get("name");
            int menuPrice = (Integer) item.get("price");
            String menuPriceStr = String.valueOf(menuPrice);
            int menuIllust = (Integer) item.get("illust");
            String menuDesc = (String) item.get("desc");
            holder._tvMenuNameRow.setText(menuName);
            holder._tvMenuPriceRow.setText(menuPriceStr);
            holder._ivMenuIllustRow.setImageResource(menuIllust);
            holder._tvMenuDescRow.setText(menuDesc);
        }

        @Override
        public int getItemCount() {
            return _listData.size();
        }
    }

    private class ItemClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            TextView tvMenuName = view.findViewById(R.id.tvMenuNameRow);
            String menuName = tvMenuName.getText().toString();
            String msg = getString(R.string.msg_header) + menuName;
            Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
        }
    }
}