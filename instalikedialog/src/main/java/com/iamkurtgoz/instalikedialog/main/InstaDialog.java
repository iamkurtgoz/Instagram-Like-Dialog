package com.iamkurtgoz.instalikedialog.main;


import android.content.Context;

import com.iamkurtgoz.instalikedialog.builder.BuilderDialogAndroid;
import com.iamkurtgoz.instalikedialog.builder.BuilderListAndroid;
import com.iamkurtgoz.instalikedialog.init.InitDialogAndroid;
import com.iamkurtgoz.instalikedialog.init.InitListAndroid;
import com.iamkurtgoz.instalikedialog.list.models.DModel;

public class InstaDialog {


    private Context context;
    private static InstaDialog instaDialog;

    public static InstaDialog with(Context context) {
        if (instaDialog == null) {
            synchronized (InstaDialog.class) {
                if (instaDialog == null) {
                    instaDialog = new InstaDialog(context);
                }
            }
        }
        return instaDialog;
    }

    private InstaDialog(Context context){
        this.context = context;
    }

    public InitListAndroid androidList(Context context, DModel[] customData){
        return new InitListAndroid(context, customData);
    }

    public InitDialogAndroid androidDialog(String title, String cancelButton, String confirmButton){
        return new InitDialogAndroid(context, title, cancelButton, confirmButton);
    }
}
