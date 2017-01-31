package com.emmanuelcorrales.locationspoofer.fragments.dialogs;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

import com.emmanuelcorrales.locationspoofer.R;

public class MockConfigDialogFragment extends DialogFragment
        implements DialogInterface.OnClickListener {

    public static final String TAG = MockConfigDialogFragment.class.getSimpleName();

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        setCancelable(false);
        int messageId;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            messageId = R.string.enable_location_dialog;
        } else {
            messageId = R.string.enable_mock_location_dialog_pre_marshmallow;
        }
        return new AlertDialog.Builder(getActivity())
                .setMessage(messageId)
                .setPositiveButton(R.string.settings, this)
                .create();
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        startActivityForResult(new Intent(android.provider.Settings.ACTION_APPLICATION_DEVELOPMENT_SETTINGS), 0);
    }
}
