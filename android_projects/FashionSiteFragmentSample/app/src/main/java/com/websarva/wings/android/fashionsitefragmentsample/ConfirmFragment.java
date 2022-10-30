package com.websarva.wings.android.fashionsitefragmentsample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmFragment extends Fragment {
    private boolean _isLayoutXLarge = true;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentManager manager = getFragmentManager();
        ItemListFragment goodsListFragment = (ItemListFragment) manager.findFragmentById(R.id.fragmentItemList);
        if(goodsListFragment == null) {
            _isLayoutXLarge = false;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Activity parentActivity = getActivity();
        View view = inflater.inflate(R.layout.fragment_confirm, container, false);

        Bundle extras;
        if(_isLayoutXLarge) {
            extras = getArguments();
        }else {
            Intent intent = parentActivity.getIntent();
            extras = intent.getExtras();
        }

        String name = "";
        String price = "";
        if (extras != null) {
            name = extras.getString("name");
            price = extras.getString("price");
        }
        TextView tvGoodsName = view.findViewById(R.id.tvConfirmationGoodsName);
        TextView tvGoodsPrice = view.findViewById(R.id.tvConfirmationGoodsPrice);

        tvGoodsName.setText(name);
        tvGoodsPrice.setText(price);

        Button btOrderButton = view.findViewById(R.id.btOrderButton);
        btOrderButton.setOnClickListener(new OrderButtonClickListener());

        Button btBackButton = view.findViewById(R.id.btBackButton);
        btBackButton.setOnClickListener(new BackButtonClickListener());

        return view;
    }

    private class OrderButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            TextView tvGoodsName = getView().findViewById(R.id.tvConfirmationGoodsName);
            TextView tvGoodsPrice = getView().findViewById(R.id.tvConfirmationGoodsPrice);
            String name = tvGoodsName.getText().toString();
            String price = tvGoodsPrice.getText().toString();
            Activity parentActivity = getActivity();
            Intent intent = new Intent(parentActivity, CompleteActivity.class);
            intent.putExtra("name", name);
            intent.putExtra("price", price);
            startActivity(intent);
        }
    }

    private class BackButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            if(_isLayoutXLarge) {
                FragmentManager manager = getFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.remove(ConfirmFragment.this);
                transaction.commit();
            }
            else {
                Activity parentActivity = getActivity();
                parentActivity.finish();
            }
        }
    }
}