package com.websarva.wings.android.loginsample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btClick = findViewById(R.id.login);
        LoginListener listener = new LoginListener();
        btClick.setOnClickListener(listener);

        Button btForgotClick = findViewById(R.id.forgot);
        ForgotListener listener1 = new ForgotListener();
        btForgotClick.setOnClickListener(listener1);
    }

    private class LoginListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            EditText inputName = findViewById(R.id.name);
            EditText inputPw = findViewById(R.id.password);
            TextView msg = findViewById(R.id.msg);

            String name = inputName.getText().toString();
            String pw = inputPw.getText().toString();

            Map<String, String> saveData = new HashMap();
            saveData.put("aaa", "aaa");
            saveData.put("bbb", "bbb");
            saveData.put("ccc", "ccc");

            if (saveData.get(name).equals(pw)) {
                msg.setText("ようこそ！" + name + "さん");
            } else {
                msg.setText("アカウント名、パスワードが間違っています");
            }
        }
    }

    private class ForgotListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            TextView msg = findViewById(R.id.msg);
            msg.setText("ご登録のメールアドレスに認証コードを送信しました。");
        }
    }
}