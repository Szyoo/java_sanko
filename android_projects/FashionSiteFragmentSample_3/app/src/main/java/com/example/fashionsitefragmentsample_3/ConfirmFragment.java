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

public class ConfirmFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private boolean _isLayoutXLarge = true;

    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentManager manager = getFragmentManager();
        ItemListFragment itemListFragment = (ItemListFragment) manager.findFragmentById(R.id.fragmentItemList);
        if (itemListFragment == null) {
            _isLayoutXLarge = false;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Activity parentActivity = getActivity();
        View view = inflater.inflate(R.layout.fragment_confirm, container, false);

        Bundle extras;
        if (_isLayoutXLarge) {
            extras = getArguments();
        } else {
            Intent intent = parentActivity.getIntent();
            extras = intent.getExtras();
        }

        String name = "";
        String price = "";
        if (extras != null) {
            name = extras.getString("name");
            price = extras.getString("price");
        }

        TextView tvItemName = view.findViewById(R.id.tvConfirmItemName);
        TextView tvItemPrice = view.findViewById(R.id.tvConfirmItemPrice);

        tvItemName.setText(name);
        tvItemPrice.setText(price);

        Button btOrderButton = view.findViewById(R.id.btOrderButton);
        btOrderButton.setOnClickListener(new OrderButtonClickListener());

        Button btBackButton = view.findViewById(R.id.btBackButton);
        btBackButton.setOnClickListener(new BackButtonClickListener());

        return view;
    }

    private class OrderButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            TextView tvItemName = getView().findViewById(R.id.tvConfirmItemName);
            TextView tvItemPrice = getView().findViewById(R.id.tvConfirmItemPrice);

            String name = tvItemName.getText().toString();
            String price = tvItemPrice.getText().toString();

            Bundle bundle = new Bundle();
            bundle.putString("name", name);
            bundle.putString("price", price);

            if (_isLayoutXLarge) {
                FragmentManager manager = getFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                CompleteFragment completeFragment = new CompleteFragment();
                completeFragment.setArguments(bundle);
                transaction.replace(R.id.confirmFrame, completeFragment);
                transaction.commit();
            } else {
                Activity parentActivity = getActivity();
                Intent intent = new Intent(parentActivity, CompleteActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("price", price);
                startActivity(intent);
            }
        }
    }


    private class BackButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            if (_isLayoutXLarge) {
                FragmentManager manager = getFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.remove(ConfirmFragment.this);
                transaction.commit();
            } else {
                Activity parentActivity = getActivity();
                parentActivity.finish();
            }
        }
    }
}