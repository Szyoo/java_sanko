package com.websarva.wings.android.mediaplayersample;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.switchmaterial.SwitchMaterial;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    //メディアプレーヤーフィールド。

    private MediaPlayer _player;
    private Map<String, Uri> audioList = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _player = new MediaPlayer();

        String audioFileUriStr = "android.resource://" + getPackageName() + "/" + R.raw.cat;
        Uri audioFileUri = Uri.parse(audioFileUriStr);
        audioList.put("cat", audioFileUri);

        audioFileUriStr = "android.resource://" + getPackageName() + "/" + R.raw.cow;
        audioFileUri = Uri.parse(audioFileUriStr);
        audioList.put("cow", audioFileUri);

        audioFileUriStr = "android.resource://" + getPackageName() + "/" + R.raw.dog;
        audioFileUri = Uri.parse(audioFileUriStr);
        audioList.put("dog", audioFileUri);

        audioFileUriStr = "android.resource://" + getPackageName() + "/" + R.raw.pig;
        audioFileUri = Uri.parse(audioFileUriStr);
        audioList.put("pig", audioFileUri);

        audioFileUriStr = "android.resource://" + getPackageName() + "/" + R.raw.wolf;
        audioFileUri = Uri.parse(audioFileUriStr);
        audioList.put("wolf", audioFileUri);


        List<String> keys = new ArrayList<>();
        for (String key : audioList.keySet()) {
            keys.add(key);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, keys);
        ListView lvAudio = findViewById(R.id.lvAudio);
        lvAudio.setAdapter(adapter);
        lvAudio.setOnItemClickListener(new ListItemClickListener());

        SwitchMaterial loopSwitch = findViewById(R.id.switchLoop);
        loopSwitch.setOnCheckedChangeListener(new LoopSwitchChangedListener());

        audioPreparation("cat");
    }

    private class ListItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String item = (String) parent.getItemAtPosition(position);
            Uri uri = audioList.get(item);
            try {
                _player.reset();
                _player.setDataSource(MainActivity.this, uri);
                _player.setOnPreparedListener(new PlayerPreparedListener());
                _player.setOnCompletionListener(new PlayerCompletionListener());
                _player.prepare();
            } catch (IOException ex) {
                Log.e("MediaSample", "メディアプレーヤー準備の例外発生", ex);
            }

            TextView tvCurrentSelect = findViewById(R.id.tvCurrentSelect);
            tvCurrentSelect.setText(item);
        }
    }

    @Override
    protected void onDestroy() {
        if (_player.isPlaying()) {
            _player.stop();
        }
        _player.release();
        _player = null;
        super.onDestroy();
    }

    /**
     * 再生ボタンタップ時の処理メソッド。
     */
    public void onPlayButtonClick(View view) {
        // 再生ボタンを取得。
        Button btPlay = findViewById(R.id.btPlay);
        // プレーヤーが再生中だったら…
        if (_player.isPlaying()) {
            // プレーヤーを一時停止。
            _player.pause();
            // 再生ボタンのラベルを「再生」に設定。
            btPlay.setText(R.string.bt_play_play);
        }
        // プレーヤーが再生中じゃなかったら…
        else {
            // プレーヤーを再生。
            _player.start();
            // 再生ボタンのラベルを「一時停止」に設定。
            btPlay.setText(R.string.bt_play_pause);
        }
    }

    /**
     * 戻るボタンタップ時の処理メソッド。
     */
    public void onBackButtonClick(View view) {
        // 再生位置を先頭に変更。
        _player.seekTo(0);
    }

    /**
     * 進むボタンタップ時の処理メソッド。
     */
    public void onForwardButtonClick(View view) {
        // 現在再生中のメディファイルの長さを取得。
        int duration = _player.getDuration();
        // 再生位置を終端に変更。
        _player.seekTo(duration);
        // 再生中でないなら…
        if (!_player.isPlaying()) {
            // 再生を開始。
            _player.start();
        }
    }

    /**
     * プレーヤーの再生準備が整った時のリスナクラス。
     */
    private class PlayerPreparedListener implements MediaPlayer.OnPreparedListener {
        @Override
        public void onPrepared(MediaPlayer mp) {
            // 各ボタンをタップ可能に設定。
            Button btPlay = findViewById(R.id.btPlay);
            btPlay.setEnabled(true);
            Button btBack = findViewById(R.id.btBack);
            btBack.setEnabled(true);
            Button btForward = findViewById(R.id.btForward);
            btForward.setEnabled(true);
        }
    }

    /**
     * 再生が終了したときのリスナクラス。
     */
    private class PlayerCompletionListener implements MediaPlayer.OnCompletionListener {
        @Override
        public void onCompletion(MediaPlayer mp) {
            // ループ設定がされていないならば…
            if (!_player.isLooping()) {
                // 再生ボタンのラベルを「再生」に設定。
                Button btPlay = findViewById(R.id.btPlay);
                btPlay.setText(R.string.bt_play_play);
            }
        }
    }

    /**
     * リピート再生スイッチの切替時のリスナクラス。
     */
    private class LoopSwitchChangedListener implements CompoundButton.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            // ループするかどうかを設定。
            _player.setLooping(isChecked);
        }
    }

    private void audioPreparation(String key){
        Uri uri = audioList.get(key);
        try {
            boolean isLooping = _player.isLooping();
            _player.reset();
            _player.setDataSource(MainActivity.this, uri);
            _player.setOnPreparedListener(new PlayerPreparedListener());
            _player.setOnCompletionListener(new PlayerCompletionListener());
            _player.prepareAsync();
            _player.setLooping(isLooping);
        }
        catch (IOException ex) {
            Log.e("MediaSample", "メディアプレーヤー準備の例外発生", ex);
        }

        Button btPlay = findViewById(R.id.btPlay);
        btPlay.setText(R.string.bt_play_play);

        TextView tvCurrentSelect = findViewById(R.id.tvCurrentSelect);
        tvCurrentSelect.setText(key);
    }
}

