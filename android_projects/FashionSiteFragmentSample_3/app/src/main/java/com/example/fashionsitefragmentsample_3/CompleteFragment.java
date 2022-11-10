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
import android.widget.Button;
import android.widget.TextView;

public class CompleteFragment extends Fragment {
    private boolean _isLayoutXLarge = true;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentManager manager = getFragmentManager();
        ItemListFragment itemListFragment = (ItemListFragment) manager.findFragmentById(R.id.fragmentItemList);
        if(itemListFragment == null) {
            _isLayoutXLarge = false;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Activity parentActivity = getActivity();
        View view = inflater.inflate(R.layout.fragment_complete, container, false);

        Bundle extras;
        if (_isLayoutXLarge) {
            extras = getArguments();
        } else {
            Intent intent = parentActivity.getIntent();
            extras = intent.getExtras();

        }

        String name = "";
        String price = "";
        if(extras != null) {
            name = extras.getString("name");
            price = extras.getString("price");
        }

        name = extras.getString("name");
        price = extras.getString("price");

        TextView tvItemName = view.findViewById(R.id.tvItemName);
        TextView tvItemPrice = view.findViewById(R.id.tvItemPrice);

        tvItemName.setText(name);
        tvItemPrice.setText(price);

        Button btBackButton = view.findViewById(R.id.btBackButton);
        btBackButton.setOnClickListener(new BackButtonClickListener());

        return view;
    }


    private class BackButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            if(_isLayoutXLarge) {
                FragmentManager manager = getFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.remove(CompleteFragment.this);
                transaction.commit();
            } else {
                Activity parentActivity = getActivity();
                parentActivity.finish();
            }
        }
    }
}