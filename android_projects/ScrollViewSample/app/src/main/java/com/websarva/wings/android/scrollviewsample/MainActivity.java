package com.websarva.wings.android.scrollviewsample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.appbar.CollapsingToolbarLayout;

public class MainActivity extends AppCompatActivity {
    private final String urlStr = "https://www.aozora.gr.jp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Toolbarを取得。
        Toolbar toolbar = findViewById(R.id.toolbar);
        // ツールバーにロゴを設定。
        toolbar.setLogo(R.mipmap.ic_launcher);
        // アクションバーにツールバーを設定。
        setSupportActionBar(toolbar);

        CollapsingToolbarLayout toolbarLayout = findViewById(R.id.toolbarLayout);

        // ツールバーにタイトル文字列を設定。
        toolbarLayout.setTitle(getString(R.string.toolbar_title));
        toolbarLayout.setExpandedTitleColor(Color.WHITE);
        toolbarLayout.setCollapsedTitleTextColor(Color.WHITE);


//        // ツールバーのタイトル文字色を設定。
//        toolbarLayout.setTitleTextColor(Color.WHITE);
//        // ツールバーのサブタイトル文字列を設定。
//        toolbarLayout.setSubtitle(R.string.toolbar_subtitle);
//        // ツールバーのサブタイトル文字色を設定。
//        toolbarLayout.setSubtitleTextColor(Color.LTGRAY);
    }

    public void onFabSearchButtonClick(View view) {
        Uri uri = Uri.parse(urlStr);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}

