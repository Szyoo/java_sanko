package com.websarva.wings.android.taskmanagementapplication;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TaskDetailsFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // フラグメントで表示する画面をXMLファイルからインフレート
        View view = inflater.inflate(R.layout.fragment_task_details, container, false);

        //ここに処理を書く
        Bundle bundle = getArguments();
        int taskId = bundle.getInt("_id");

        TaskDatabaseHelper helper = new TaskDatabaseHelper(getActivity());
        SQLiteDatabase db = helper.getWritableDatabase();
        String sql = "SELECT * FROM task WHERE _id = " + taskId;
        Cursor cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            int taskNameIdx = cursor.getColumnIndex("name");
            String taskName = cursor.getString(taskNameIdx);
            TextView tvTaskName = view.findViewById(R.id.tvTaskDetailDescription);
            tvTaskName.setText(taskName);

            int taskFinishDateTimeIdx = cursor.getColumnIndex("finish_at");
            Long taskFinishDateTime = cursor.getLong(taskFinishDateTimeIdx);
            Date finishDateTime = new Date(taskFinishDateTime);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
            String finishDate = dateFormat.format(finishDateTime);
            String finishTime = timeFormat.format(finishDateTime);
            TextView tvFinishDate = view.findViewById(R.id.tvTaskDetailFinishDate);
            tvFinishDate.setText(finishDate);
            TextView tvFinishTime = view.findViewById(R.id.tvTaskDetailFinishTime);
            tvFinishTime.setText(finishTime);

            int taskStatusIdx = cursor.getColumnIndex("status");
            int taskStatus = cursor.getInt(taskStatusIdx);

            String[] taskStatusArray = getResources().getStringArray(R.array.sp_task_status);
            String taskStatusStr = taskStatusArray[taskStatus];
            TextView tvTaskStatus = view.findViewById(R.id.tvTaskDetailStatus);
            tvTaskStatus.setText(taskStatusStr);
            int taskNotificationIdx = cursor.getColumnIndex("notification");
            int taskNotification = cursor.getInt(taskNotificationIdx);
            TextView tvTaskNotification = view.findViewById(R.id.tvTaskDetailNotify);
            switch (taskNotification) {
                case 0:
                    tvTaskNotification.setText(R.string.rb_notify);
                    break;
                case 1:
                    tvTaskNotification.setText(R.string.rb_not_notify);
                    break;
                default:
                    break;
            }
            int taskGroupIdx = cursor.getColumnIndex("task_group");
            int taskGroup = cursor.getInt(taskGroupIdx);
            TextView tvTaskGroup = view.findViewById(R.id.tvTaskDetailGroup);
            switch (taskGroup) {
                case 0:
                    tvTaskGroup.setText(R.string.important);
                    break;
                case 1:
                    tvTaskGroup.setText(R.string.emergency);
                    break;
                case 2:
                    tvTaskGroup.setText(R.string.note);
                    break;
                case 3:
                    tvTaskGroup.setText(R.string.not_set);
                    break;
                default:
                    break;
            }
            int taskColorIdx = cursor.getColumnIndex("color");
            int taskColor = cursor.getInt(taskColorIdx);
            TextView tvTaskColor = view.findViewById(R.id.tvTaskDetailColor);
            switch (taskColor) {
                case 0:
                    tvTaskColor.setText(R.string.rb_blue);
                    break;
                case 1:
                    tvTaskColor.setText(R.string.rb_red);
                    break;
                case 2:
                    tvTaskColor.setText(R.string.rb_green);
                    break;
                case 3:
                    tvTaskColor.setText(R.string.not_set);
                    break;
                default:
                    break;
            }
        }
        return view;
    }

}