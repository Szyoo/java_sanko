package com.websarva.wings.android.taskmanagementapplication;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class CancelConfirmationDialogFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // フラグメントに埋め込まれた引き継ぎデータを取得
        Bundle bundle = getArguments();

        // ダイアログビルダーを生成
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // ダイアログのメッセージを設定
        builder.setMessage(bundle.getString("dialogMessage"));
        // Positive Buttonを設定
        builder.setPositiveButton(bundle.getString("positiveMessage"), new DialogButtonClickListener());
        // Negative Buttonを設定
        builder.setNegativeButton(R.string.btn_cancel, new DialogButtonClickListener());
        // ダイアログオブジェクトを生成し、リターン
        AlertDialog dialog = builder.create();

        return dialog;
    }

    private class DialogButtonClickListener implements DialogInterface.OnClickListener {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            // タップされたボタンに応じて処理を行う
            switch(which) {
                case DialogInterface.BUTTON_POSITIVE:
                    // 所属しているアクティビティを取得
                    Activity parentActivity = getActivity();
                    // アクティビティを終了
                    parentActivity.finish();
                    break;
                case DialogInterface.BUTTON_NEGATIVE:
                    break;
                default:
                    break;
            }
        }
    }
}
