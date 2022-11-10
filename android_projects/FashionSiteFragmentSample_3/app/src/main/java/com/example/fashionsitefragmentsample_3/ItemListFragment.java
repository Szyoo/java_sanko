package com.example.fashionsitefragmentsample_3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemListFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String[] FROM = {"name", "price"};
    private static final int[] TO = {R.id.tvItemNameRow, R.id.tvItemPriceRow};

    // TODO: Rename and change types of parameters
    private ListView _menu;
    private List<Map<String, String>> _itemList;

    private boolean _isLayoutXLarge = true;

    public ItemListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Activity parentActivity = getActivity();
        View ConfirmFrame = parentActivity.findViewById(R.id.confirmFrame);
        if (ConfirmFrame == null) {
            _isLayoutXLarge = false;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Activity parentActivity = getActivity();
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);
        _menu = view.findViewById(R.id.menu);
        _itemList = createTopsList();
        SimpleAdapter adapter = new SimpleAdapter(parentActivity, _itemList, R.layout.row, FROM, TO);
        _menu.setAdapter(adapter);

        _menu.setOnItemClickListener(new ListItemClickListener());
        return view;
    }

    private List<Map<String, String>> createTopsList() {
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

    private class ListItemClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Map<String, String> item = (Map<String, String>) parent.getItemAtPosition(position);

            String name = item.get("name");
            String price = item.get("price");
            Activity parentActivity = getActivity();
            Bundle bundle = new Bundle();
            bundle.putString("name", name);
            bundle.putString("price", price);

            if (_isLayoutXLarge) {
                FragmentManager manager = getFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                ConfirmFragment cf = new ConfirmFragment();
                cf.setArguments(bundle);
                transaction.replace(R.id.confirmFrame, cf);
                transaction.commit();
            } else {
                Intent intent = new Intent(parentActivity, ConfirmActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        }
    }
}