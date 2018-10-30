package com.iamkurtgoz.instalikedialog.main;


import android.content.Context;

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


    public Init init(DModel[] customData, Builder.DialogClickCallBack dialogClickCallBack){
        return new Init(context, customData, dialogClickCallBack);
    }
}
