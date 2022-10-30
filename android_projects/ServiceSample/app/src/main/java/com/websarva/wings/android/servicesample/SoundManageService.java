package com.websarva.wings.android.servicesample;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.IBinder;
import android.util.Log;

import java.io.IOException;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class SoundManageService extends Service {



    @Override
    public void onDestroy() {
        // プレーヤーが再生中なら…
        if(_player.isPlaying()) {
            // プレーヤーを停止。
            _player.stop();
        }
        // プレーヤーを解放。
        _player.release();
        // プレーヤー用フィールドをnullに。
        _player = null;
    }

    /**
     * メディア再生準備が完了した時のリスナクラス。
     */
    private class PlayerPreparedListener implements MediaPlayer.OnPreparedListener {
        @Override
        public void onPrepared(MediaPlayer mp) {
        }
    }

    /**
     * メディア再生が終了した時のリスナクラス。
     */
    private class PlayerCompletionListener implements MediaPlayer.OnCompletionListener {
        @Override
        public void onCompletion(MediaPlayer mp) {
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}

