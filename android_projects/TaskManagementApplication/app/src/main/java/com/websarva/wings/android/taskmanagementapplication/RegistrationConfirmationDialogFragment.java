package com.websarva.wings.android.taskmanagementapplication;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;
import java.util.Date;

public class RegistrationConfirmationDialogFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        //ここに処理を書く
        //AlertDialog dialog = null;の部分は開発の際に削除してダイアログの生成処理に書き換えること
        AlertDialog.Builder builder=new AlertDialog.Builder((getActivity()));
        builder.setMessage(R.string.task_registration_cancel_dialog_msg);
        builder.setPositiveButton(R.string.btn_registration,new DialogButtonClickListener());
        builder.setNegativeButton(R.string.btn_cancel,new DialogButtonClickListener());
        AlertDialog dialog = builder.create();
        return dialog;
    }

    private class DialogButtonClickListener implements DialogInterface.OnClickListener {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            //ここに処理を書く
            switch (which) {
                case DialogInterface.BUTTON_POSITIVE:
                    Bundle bundle = getArguments();
                    String taskDescription = bundle.getString("taskDescription");
                    long finishDateTime = bundle.getLong("finishDateTime");
                    int taskStatus = bundle.getInt("taskStatus");
                    int checkedTaskNotificationId = bundle.getInt("checkedTaskNotificationId");
                    int checkedTaskGroupId = bundle.getInt("checkedTaskGroupId");
                    int checkedTaskColorId = bundle.getInt("checkedTaskColorId");

                    TaskDatabaseHelper helper = new TaskDatabaseHelper(getActivity());
                    SQLiteDatabase db = helper.getWritableDatabase();

                    String sql = "INSERT INTO task " +
                            "(name, finish_at, status, notification, task_group, color, created_at) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?)";
                    SQLiteStatement stmt = db.compileStatement(sql);
                    stmt.bindString(1, taskDescription);
                    stmt.bindLong(2, finishDateTime);
                    stmt.bindLong(3, taskStatus);
                    stmt.bindLong(4, checkedTaskNotificationId);
                    stmt.bindLong(5, checkedTaskGroupId);
                    stmt.bindLong(6, checkedTaskColorId);

                    long today = new Date(System.currentTimeMillis()).getTime();
                    stmt.bindLong(7, today);
                    stmt.executeInsert();
                    getActivity().finish();
                case DialogInterface.BUTTON_NEGATIVE:
                    break;
            }
        }
    }
}
