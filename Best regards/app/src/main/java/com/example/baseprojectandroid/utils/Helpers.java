package com.example.baseprojectandroid.utils;

import android.app.Activity;
import android.app.Dialog;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import com.example.baseprojectandroid.R;

public class Helpers {
    public static Dialog showLoadingDialog(Activity activity){
        Dialog dialog = new Dialog(activity);
        dialog.setContentView(R.layout.loading_dialog_layout);
        return dialog;
    }

    public static void hideFragmentDialog(Fragment fragmentManager,String content){
        Fragment prev = fragmentManager.getFragmentManager().findFragmentByTag(content);
        if (prev != null) {
            DialogFragment df = (DialogFragment) prev;
            df.dismiss();
        }
    }

}
