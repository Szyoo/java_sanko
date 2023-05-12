package com.websarva.wings.android.taskmanagementapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegistrationActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        //アクションバーの戻るメニュ‐作成
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.registration_option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // 戻り値用の変数を用意
        boolean returnVal = true;
        //ここに処理を書く
        int itemId = item.getItemId();
        Bundle bundle = new Bundle();
        switch (itemId) {
            case R.id.optionsMenuRegistration:
                FragmentManager manager = getSupportFragmentManager();
                EditTaskFragment editTaskFragment =
                        (EditTaskFragment) manager.findFragmentById(R.id.etEditTaskDescription);
                View view = editTaskFragment.getView();
                EditText etTaskDescription =
                        view.findViewById(R.id.etEditTaskDescription);
                String taskDescription = etTaskDescription.getText().toString();
                bundle.putString("taskDescription", taskDescription);

                TextView tvTaskFinishDate = view.findViewById(R.id.tvEditTaskCompletionDate);
                String taskFinishDate = tvTaskFinishDate.getText().toString();
                TextView tvTaskFinishTime = view.findViewById(R.id.tvEditTaskCompletionDate);
                String taskFinishTime = tvTaskFinishTime.getText().toString();

                Date finishDateTime = null;
                SimpleDateFormat dateTimeFormat =
                        new SimpleDateFormat("yyyy/MM/dd HH:mm");
                try {
                    finishDateTime = dateTimeFormat.parse(taskFinishDate + "" + taskFinishTime);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                Long finishDateTimeLong = finishDateTime.getTime();
                bundle.putLong("finishDateTime", finishDateTimeLong);

                Spinner spTaskStatus = view.findViewById(R.id.spEditTaskStatus);
                int taskStatus = spTaskStatus.getSelectedItemPosition();
                bundle.putInt("taskStatus", taskStatus);

                RadioGroup rgTaskNotification =
                        view.findViewById(R.id.rgEditTaskNotification);
                int checkedTaskNotificationId =
                        rgTaskNotification.getCheckedRadioButtonId();
                switch (checkedTaskNotificationId) {
                    case R.id.rbEditNotify:
                        bundle.putInt("checkedTaskNotificationId", 0);
                        break;
                    case R.id.rbEditNotNotify:
                        bundle.putInt("checkedTaskNotificationId", 1);
                        break;
                    default:
                        break;
                }

                RadioGroup rgTaskGroup = view.findViewById(R.id.rgEditTaskGroup);
                int checkedTaskGroupId = rgTaskGroup.getCheckedRadioButtonId();
                switch (checkedTaskGroupId) {
                    case R.id.rbEditImportant:
                        bundle.putInt("checkedTaskGroupId", 0);
                        break;
                    case R.id.rbEditEmergency:
                        bundle.putInt("checkedTaskGroupId", 1);
                        break;
                    case R.id.rbEditNote:
                        bundle.putInt("checkedTaskGroupId", 2);
                        break;
                    case R.id.rbEditNotsetGroup:
                        bundle.putInt("checkedTaskGroupId", 3);
                        break;
                    default:
                        break;
                }

                RadioGroup rgTaskColor = view.findViewById(R.id.rgEditTaskBarColor);
                int checkedTaskColorId = rgTaskColor.getCheckedRadioButtonId();
                switch (checkedTaskColorId) {
                    case R.id.rbEditBlue:
                        bundle.putInt("checkedTaskGroupId", 0);
                        break;
                    case R.id.rbEditRed:
                        bundle.putInt("checkedTaskGroupId", 1);
                        break;
                    case R.id.rbEditGreen:
                        bundle.putInt("checkedTaskGroupId", 2);
                        break;
                    case R.id.rbEditNotsetColor:
                        bundle.putInt("checkedTaskGroupId", 3);
                        break;
                    default:
                        break;
                }

                RegistrationConfirmationDialogFragment registrationConfirmationDialogFragment
                        = new RegistrationConfirmationDialogFragment();

                registrationConfirmationDialogFragment.setArguments(bundle);

                registrationConfirmationDialogFragment.show(getSupportFragmentManager(),
                        "registrationConfirmationDialogFragment");
                break;
            case android.R.id.home:
                CancelConfirmationDialogFragment cancelConfirmationDialogFragment
                        = new CancelConfirmationDialogFragment();
                bundle.putString("dialogMessage",
                        getString(R.string.task_registration_cancel_dialog_msg));
                bundle.putString("positiveMessage",
                        getString(R.string.btn_finish));

                cancelConfirmationDialogFragment.show(getSupportFragmentManager(),
                        "cancelConfirmationDialogFragment");

                break;
            default:
                returnVal = super.onOptionsItemSelected(item);
        }

        return returnVal;
    }

}