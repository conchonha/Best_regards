package com.example.baseprojectandroid.utils;

import android.app.Activity;
import android.app.Dialog;

import com.example.baseprojectandroid.R;

public class Helpers {
    public static Dialog showLoadingDialog(Activity activity){
        Dialog dialog = new Dialog(activity);
        dialog.setContentView(R.layout.loading_dialog_layout);
        return dialog;
    }
}
