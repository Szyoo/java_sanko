package com.websarva.wings.android.backgroundmediaplayersample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Intentオブジェクトを取得。
        Intent intent = getIntent();
        // 通知のタップからの引き継ぎデータを取得。
        boolean fromNotification =
                intent.getBooleanExtra("fromNotification", false);
        // 引き継ぎデータが存在、つまり通知のタップからならば…
        if(fromNotification) {
            // 再生ボタンをタップ不可に、停止ボタンをタップ可に変更。
//            Button btPlay = findViewById(R.id.btPlay);
//            Button btStop = findViewById(R.id.btStop);
//            btPlay.setEnabled(false);
//            btStop.setEnabled(true);

            Intent serviceIntent = new Intent(MainActivity.this, SoundManageService.class);
            startService(serviceIntent);
        }
    }

    /**
     * 再生ボタンタップ時の処理メソッド。
     *
     * @param view 画面部品
     */
    public void onPlayButtonClick(View view) {
        // インテントオブジェクトを生成。
        Intent intent = new Intent(MainActivity.this, SoundManageService.class);
        // サービスを起動。
        startService(intent);
        // 再生ボタンをタップ不可に、停止ボタンをタップ可に変更。
        Button btPlay = findViewById(R.id.btPlay);
        Button btStop = findViewById(R.id.btStop);
        btPlay.setEnabled(false);
        btStop.setEnabled(true);
    }

    /**
     * 停止ボタンタップ時の処理メソッド。
     *
     * @param view 画面部品
     */
    public void onStopButtonClick(View view) {
        // インテントオブジェクトを生成。
        Intent intent = new Intent(MainActivity.this, SoundManageService.class);
        // サービスを停止。
        stopService(intent);
        // 再生ボタンをタップ可に、停止ボタンをタップ不可に変更。
        Button btPlay = findViewById(R.id.btPlay);
        Button btStop = findViewById(R.id.btStop);
        btPlay.setEnabled(true);
        btStop.setEnabled(false);
    }
}


