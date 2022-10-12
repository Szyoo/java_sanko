package com.websarva.wings.android.cakelistsample;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class OrderConfirmDialogFragment extends DialogFragment {

    private String orderItem;

    public void setOrderItem(String orderItem) {
        this.orderItem = orderItem;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.dialog_title);
        builder.setMessage(R.string.dialog_msg);
        builder.setPositiveButton(R.string.dialog_btn_ok, new DialogButtonClickListener());
        builder.setNegativeButton(R.string.dialog_btn_cancel, new DialogButtonClickListener());
        builder.setNeutralButton(R.string.dialog_btn_contact, new DialogButtonClickListener());
        AlertDialog dialog = builder.create();
        return dialog;
    }

    private class DialogButtonClickListener implements DialogInterface.OnClickListener {

        @Override
        public void onClick(DialogInterface dialog, int which) {
            String msg = "";
            switch (which) {
                case DialogInterface.BUTTON_POSITIVE:
                    msg = orderItem + getString(R.string.dialog_toast_ok);
                    break;
                case DialogInterface.BUTTON_NEGATIVE:
                    msg = getString(R.string.dialog_toast_cancel);
                    break;
                case DialogInterface.BUTTON_NEUTRAL:
                    msg = getString(R.string.dialog_toast_contact);
                    break;
                default:
                    break;
            }
            Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();
        }
    }
}
