package com.websarva.wings.android.taskmanagementapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class ShowDetailsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_details);

        //ここに処理を書く

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //ここに処理を書く
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // 戻り値用の変数を用意
        boolean returnVal = true;
        //ここに処理を書く

        return returnVal;
    }

    // ボタンのリスナクラス
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v){
            //ここに処理を書く

        }
    }
}