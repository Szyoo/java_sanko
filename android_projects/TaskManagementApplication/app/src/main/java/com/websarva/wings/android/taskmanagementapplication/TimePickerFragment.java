package com.websarva.wings.android.taskmanagementapplication;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;

import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class TimePickerFragment extends DialogFragment {
    // 呼び出し側のEditTaskFragmentを格納するフィールド
    private EditTaskFragment _editTaskFragment;

    public TimePickerFragment(EditTaskFragment editTaskFragment) {
        // ダイアログの結果を受け取るクラスをフィールドに代入
        _editTaskFragment = editTaskFragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Calendarを取得
        final Calendar c = Calendar.getInstance();
        // 現在時刻をそれぞれ、時間、分で取得
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        // TimePickerDialogを生成し、インスタンスをreturnする
        return new TimePickerDialog(getActivity(), _editTaskFragment, hour, minute, DateFormat.is24HourFormat(getActivity()));
    }
}