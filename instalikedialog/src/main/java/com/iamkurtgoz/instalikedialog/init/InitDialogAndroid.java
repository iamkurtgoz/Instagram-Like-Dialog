package com.iamkurtgoz.instalikedialog.init;

import android.content.Context;
import android.view.Gravity;

import com.iamkurtgoz.instalikedialog.R;
import com.iamkurtgoz.instalikedialog.builder.BuilderDialogAndroid;
import com.iamkurtgoz.instalikedialog.builder.BuilderListAndroid;
import com.iamkurtgoz.instalikedialog.list.models.DModel;

public class InitDialogAndroid {

    public Context context;
    private Boolean isCancelable = true;
    private String title = "", cancelButton = "", confirmButton = "";
    private int textColor, textSize = 14;
    private boolean imgAvatarActive = false;

    private String profileIconUrl = null;
    private int profileIconResource = -1;

    public BuilderDialogAndroid.DialogClickCallBack dialogClickCallBack;

    public InitDialogAndroid(Context context, String title, String cancelButton, String confirmButton){
        this.context = context;
        this.title = title;
        this.cancelButton = cancelButton;
        this.confirmButton = confirmButton;

        //default text color.
        this.textColor = context.getResources().getColor(R.color.black);
    }

    public InitDialogAndroid setDialogClickCallBack(BuilderDialogAndroid.DialogClickCallBack dialogClickCallBack) {
        this.dialogClickCallBack = dialogClickCallBack;
        return this;
    }

    public InitDialogAndroid setCancelable(Boolean cancelable) {
        isCancelable = cancelable;
        return this;
    }

    public Boolean getCancelable() {
        return isCancelable;
    }


    public String getTitle() {
        return title;
    }

    public InitDialogAndroid setTextColor(int textColor) {
        this.textColor = textColor;
        return this;
    }

    public int getTextColor() {
        return textColor;
    }

    public InitDialogAndroid setTextSize(int textSize) {
        this.textSize = textSize;
        return this;
    }

    public int getTextSize() {
        return textSize;
    }

    public boolean getImgAvatarActive() {
        return imgAvatarActive;
    }

    public String getCancelButton() {
        return cancelButton;
    }

    public String getConfirmButton() {
        return confirmButton;
    }

    public InitDialogAndroid setProfileIconResource(int profileIconResource) {
        this.profileIconResource = profileIconResource;
        this.imgAvatarActive = true;
        return this;
    }

    public int getProfileIconResource() {
        return profileIconResource;
    }

    public InitDialogAndroid setProfileIconUrl(String profileIconUrl) {
        this.profileIconUrl = profileIconUrl;
        this.imgAvatarActive = true;
        return this;
    }

    public String getProfileIconUrl() {
        return profileIconUrl;
    }

    public void show() {
        new BuilderDialogAndroid(this).show();
    }
}
