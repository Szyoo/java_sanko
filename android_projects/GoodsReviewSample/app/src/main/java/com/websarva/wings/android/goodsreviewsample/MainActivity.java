package com.websarva.wings.android.goodsreviewsample;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int _iceCreamId = -1;
    private String _iceCreamName = "";
    private DatabaseHelper _helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lvIceCream = findViewById(R.id.lvIceCream);
        lvIceCream.setOnItemClickListener(new ListItemClickListener());
        _helper = new DatabaseHelper(MainActivity.this);
    }

    @Override
    protected void onDestroy() {
        _helper.close();
        super.onDestroy();
    }

    public void onSaveButtonClick(View view) {
        EditText etReview = findViewById(R.id.etReview);
        String review = etReview.getText().toString();

        SQLiteDatabase db = _helper.getWritableDatabase();

        String sqlDelete = "DELETE FROM iceCreamReview WHERE _id = ?";
        SQLiteStatement stmt = db.compileStatement(sqlDelete);
        stmt.bindLong(1, _iceCreamId);
        stmt.executeUpdateDelete();

        String sqlInsert = "INSERT INTO iceCreamReview (_id, name, review) VALUES (?, ?, ?)";
        stmt = db.compileStatement(sqlInsert);
        stmt.bindLong(1, _iceCreamId);
        stmt.bindString(2, _iceCreamName);
        stmt.bindString(3, review);
        stmt.executeInsert();

        etReview.setText("");
        TextView tvReview = findViewById(R.id.tvReview);
        tvReview.setText("");
        TextView tvIceCreamName = findViewById(R.id.tvIceCreamName);
        tvIceCreamName.setText(getString(R.string.tv_name));
        Button btnSave = findViewById(R.id.btnSave);
        btnSave.setEnabled(false);

    }

    private class ListItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            _iceCreamId = position;
            _iceCreamName = (String) parent.getItemAtPosition(position);
            TextView tvIceCreamName = findViewById(R.id.tvIceCreamName);
            tvIceCreamName.setText(_iceCreamName);
            Button btnSave = findViewById(R.id.btnSave);
            btnSave.setEnabled(true);

            SQLiteDatabase db = _helper.getWritableDatabase();
            String sql = "SELECT * FROM iceCreamReview WHERE _id = " + _iceCreamId;
            Cursor cursor = db.rawQuery(sql, null);
            String review = "";
            while (cursor.moveToNext()) {
                int idxReview = cursor.getColumnIndex("review");
                review = cursor.getString(idxReview);
            }

            TextView tvReview = findViewById(R.id.tvReview);
            tvReview.setText(review);
        }
    }
}