package com.websarva.wings.android.locationinfosearchsample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {
    //緯度フィールド。
//    private double _latitude = 0;
    //経度フィールド
//    private double _longitude = 0;
    //FusedLocationProviderClientオブジェクトフィールド。
    private FusedLocationProviderClient _fusedLocationClient;
    //LocationRequestオブジェクトフィールド。
    private LocationRequest _locationRequest;
    //位置情報が変更された時の処理を行うコールバックオブジェクトフィールド。
    private OnUpdateLocation _onUpdateLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // FusedLocationProviderClientオブジェクトを取得。
        _fusedLocationClient =
                LocationServices.getFusedLocationProviderClient(MainActivity.this);
        // LocationRequestオブジェクトを生成。
        _locationRequest = LocationRequest.create();
        // 位置情報の更新間隔を設定。
        _locationRequest.setInterval(5000);
        // 位置情報の最短更新間隔を設定。
        _locationRequest.setFastestInterval(1000);
        // 位置情報の取得精度を設定。
        _locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        // 位置情報が変更された時の処理を行うコールバックオブジェクトを生成。
        _onUpdateLocation = new OnUpdateLocation();
    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//
//        // 位置情報の追跡を開始。
//        if (ActivityCompat.checkSelfPermission
//                (this, Manifest.permission.ACCESS_FINE_LOCATION)
//                != PackageManager.PERMISSION_GRANTED) {
//
//            // ACCESS_FINE_LOCATIONの許可が下りていないなら…
//            if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//                // ACCESS_FINE_LOCATIONの許可を求めるダイアログを表示。その際、リクエストコードを1000に設定。
//                String[] permissions = {Manifest.permission.ACCESS_FINE_LOCATION};
//                ActivityCompat.requestPermissions(MainActivity.this, permissions, 1000);
//                // onResume()メソッドを終了。
//                return;
//
//            }
//            _fusedLocationClient.requestLocationUpdates(_locationRequest, _onUpdateLocation, Looper.getMainLooper());
//        }
//    }

    @Override
    public void onRequestPermissionsResult
            (int requestCode, @NonNull String[] permissions, @NonNull  int[] grantResults) {

        //テキスト通りに書くとエラーが出る人は以下を追記
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        // ACCESS_FINE_LOCATIONに対するパーミションダイアログでかつ許可を選択したなら…

        if (requestCode == 1000 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            // 再度ACCESS_FINE_LOCATIONの許可が下りていないかどうかのチェックをし、
            // 降りていないなら処理を中止。
            if (ActivityCompat.checkSelfPermission
                    (MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            // 位置情報の追跡を開始。
            _fusedLocationClient.requestLocationUpdates
                    (_locationRequest, _onUpdateLocation, Looper.getMainLooper());
        }
    }

//    @Override
//    protected void onPause() {
//        super.onPause();
//
//        // 位置情報の追跡を停止。
//        _fusedLocationClient.removeLocationUpdates(_onUpdateLocation);
//    }

    /**
     * 地図検索ボタンがタップされたときの処理メソッド。
     */
    public void onMapSearchButtonClick(View view) {
        // 入力欄に入力されたキーワード文字列を取得。
        EditText etSearchWord = findViewById(R.id.etSearchWord);
        String searchWord = etSearchWord.getText().toString();

        try {
            // 入力されたキーワードをURLエンコード。
            searchWord = URLEncoder.encode(searchWord, "UTF-8");
            // マップアプリと連携するURI文字列を生成。
            String uriStr = "geo:0,0?q=" + searchWord;
            // URI文字列からURIオブジェクトを生成。
            Uri uri = Uri.parse(uriStr);
            // Intentオブジェクトを生成。
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            // アクティビティを起動。
            startActivity(intent);
        } catch (UnsupportedEncodingException ex) {
            Log.e("MainActivity", "検索キーワード変換失敗", ex);
        }
    }

    /**
     * 現在地の地図表示ボタンがタップされたときの処理メソッド。
     */
    public void onMapShowButtonClick(View view) {

        EditText etLatitude = findViewById(R.id.etLatitude);
        EditText etLongitude = findViewById(R.id.etLongitude);
        String latitude = etLatitude.getText().toString();
        String longitude = etLongitude.getText().toString();


        // フィールドの緯度と経度の値をもとにマップアプリと連携するURI文字列を生成。
        String uriStr = "geo:" + latitude + "," + longitude;

        // URI文字列からURIオブジェクトを生成。
        Uri uri = Uri.parse(uriStr);
        // Intentオブジェクトを生成。
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        // アクティビティを起動。
        startActivity(intent);
    }

    public void onNowLocationButtonClick(View view) {
        if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            String[] permissions = {Manifest.permission.ACCESS_FINE_LOCATION};
            ActivityCompat.requestPermissions(MainActivity.this, permissions, 1000);
            return;
        }
        _fusedLocationClient.requestLocationUpdates(_locationRequest, _onUpdateLocation, Looper.getMainLooper());
    }

    /**
     * 位置情報が変更された時の処理を行うコールバッククラス。
     */
    private class OnUpdateLocation extends LocationCallback {
        @Override
        public void onLocationResult(LocationResult locationResult) {
            if (locationResult != null) {
                // 直近の位置情報を取得。
                Location location = locationResult.getLastLocation();
                if (location != null) {
                    // locationオブジェクトから緯度を取得。
                    double latitude = location.getLatitude();
                    // locationオブジェクトから経度を取得。
                    double longitude = location.getLongitude();
                    // 取得した緯度をTextViewに表示。
//                    TextView tvLatitude = findViewById(R.id.tvLatitude);
//                    tvLatitude.setText(Double.toString(latitude));
                    // 取得した経度をTextViewに表示。
//                    TextView tvLongitude = findViewById(R.id.tvLongitude);
//                    tvLongitude.setText(Double.toString(longitude));


                    EditText etLatitude = findViewById(R.id.etLatitude);
                    EditText etLongitude = findViewById(R.id.etLongitude);
                    etLatitude.setText(Double.toString(latitude));
                    etLongitude.setText(Double.toString(longitude));
                    _fusedLocationClient.removeLocationUpdates(_onUpdateLocation);
                }
            }
        }
    }
}


