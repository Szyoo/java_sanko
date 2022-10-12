package com.websarva.wings.android.fashionsitefragmentsample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class CompleteFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Activity parentActivity = getActivity();
        View view = inflater.inflate(R.layout.fragment_complete, container, false);

        Intent intent = parentActivity.getIntent();
        String name = intent.getStringExtra("name");
        String price = intent.getStringExtra("price");
        TextView tvGoodsName = view.findViewById(R.id.tvOrderGoodsName);
        TextView tvGoodsPrice = view.findViewById(R.id.tvOrderGoodsPrice);

        tvGoodsName.setText(name);
        tvGoodsPrice.setText(price);

        Button btBackButton = view.findViewById(R.id.btBackButton);
        btBackButton.setOnClickListener(new BackButtonClickListener());

        return view;
    }

    private class BackButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Activity parentActivity = getActivity();
            parentActivity.finish();
        }
    }
}