package com.websarva.wings.android.taskmanagementapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class TaskDatabaseHelper extends SQLiteOpenHelper {
    // データベース名の文字列
    private static final String DATABASE_NAME = "taskmanagement.db";
    // データベースバージョンの文字列
    private static final int DATABASE_VERSION = 1;
    // テーブル名の文字列
    private static final String TABLE_NAME = "task";

    // コンストラクタ
    public TaskDatabaseHelper(Context context) {
        // 親コンストラクタの呼び出し
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // テーブルの作成用SQL文字列の作成
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE ");
        sb.append(TABLE_NAME);
        sb.append(" (");
        sb.append("_id INTEGER PRIMARY KEY AUTOINCREMENT,");
        sb.append("name TEXT,");
        sb.append("finish_at INTEGER NOT NULL,");
        sb.append("status INTEGER NOT NULL,");
        sb.append("notification INTEGER NOT NULL,");
        sb.append("task_group INTEGER NOT NULL,");
        sb.append("color INTEGER NOT NULL,");
        sb.append("created_at INTEGER NOT NULL,");
        sb.append("updated_at INTEGER,");
        sb.append("delete_at INTEGER");
        sb.append(");");
        String sql = sb.toString();

        // SQLの実行
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public String getDatabaseName() {
        return TABLE_NAME;
    }
}
