package com.websarva.wings.android.taskmanagementapplication;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.fragment.app.DialogFragment;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EditTaskFragment extends Fragment implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // フラグメントで表示する画面をXMLファイルからインフレート
        View view = inflater.inflate(R.layout.fragment_edit_task, container, false);

        //ここに処理を書く

        return view;
    }


    //時間の登録に関する処理
    //ここは演習対象外（処理を書く必要なし）
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        // 月を文字列で格納する変数
        // ※月は０からのカウントの値が返されるので、+1する
        String monthStr = String.valueOf(month + 1);
        // 月が１～９だった場合
        if((month + 1) < 10) {
            // 月の数値の前に"0"を追加する
            monthStr = "0" + monthStr;
        }

        // 日を文字列で格納する変数
        String dayOfMonthStr = String.valueOf(dayOfMonth);
        // 日が１～９だった場合
        if(dayOfMonth < 10) {
            // 日の数値の前に"0"を追加する
            dayOfMonthStr = "0" + dayOfMonthStr;
        }

        // 表示する形式の文字列を作成
        String dateStr = year + "/" + monthStr + "/" + dayOfMonthStr;

        // 完了日を表示するTextViewにdateStrを設定
        View fragmentView = getView();
        TextView tvEditTaskCompletionDate = fragmentView.findViewById(R.id.tvEditTaskCompletionDate);
        tvEditTaskCompletionDate.setText(dateStr);
    }

    //日付の登録に関する処理
    //ここは演習対象外（処理を書く必要なし）
    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        // 時間を文字列で格納する変数
        String hourOfDayStr = String.valueOf(hourOfDay);
        // 時間が１～９だった場合
        if(hourOfDay < 10) {
            // 時間の数値の前に"0"を追加する
            hourOfDayStr = "0" + hourOfDayStr;
        }

        // 分を文字列で格納する変数
        String minuteStr = String.valueOf(minute);
        // 分が１～９だった場合
        if(minute < 10) {
            // 分の数値の前に"0"を追加する
            minuteStr = "0" + minuteStr;
        }

        // 表示する形式の文字列を作成
        String timeStr = hourOfDayStr + ":" + minuteStr;

        // 完了時刻を表示するTextViewにtimeStrを設定
        View fragmentView = getView();
        TextView tvEditTaskCompletionTime = fragmentView.findViewById(R.id.tvEditTaskCompletionTime);
        tvEditTaskCompletionTime.setText(timeStr);
    }

    //日付の登録に関する処理
    //ここは演習対象外（処理を書く必要なし）
    private class OnEditDateButtonClickListener implements View.OnClickListener {
        // 入力値を受け取るクラスをDatePickerFragmentに渡すフィールド
        EditTaskFragment _editTaskFragment;

        // コンストラクタ
        public OnEditDateButtonClickListener(EditTaskFragment editTaskFragment) {
            // 入力値を受け取るクラスを取得
            _editTaskFragment = editTaskFragment;
        }

        @Override
        public void onClick(View v) {
            // 日付選択ダイアログを生成
            DialogFragment dialogFragment = new DatePickerFragment(_editTaskFragment);
            // ダイアログを表示
            dialogFragment.show(getActivity().getSupportFragmentManager(), "datePicker");
        }
    }

    //時間の登録に関する処理
    //ここは演習対象外（処理を書く必要なし）
    private class OnEditTimeButtonClickListener implements View.OnClickListener {
        // 入力値を受け取るクラスをTimePickerFragmentに渡すフィールド
        EditTaskFragment _editTaskFragment;

        // コンストラクタ
        public OnEditTimeButtonClickListener(EditTaskFragment editTaskFragment) {
            // 入力値を受け取るクラスを取得
            _editTaskFragment = editTaskFragment;
        }

        @Override
        public void onClick(View v) {
            // 時刻選択ダイアログを生成
            DialogFragment dialogFragment = new TimePickerFragment(_editTaskFragment);
            // ダイアログを表示
            dialogFragment.show(getActivity().getSupportFragmentManager(), "timePicker");
        }
    }
}