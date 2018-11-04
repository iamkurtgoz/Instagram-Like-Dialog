package com.iamkurtgoz.instalikedialog.init;

import android.content.Context;
import android.view.Gravity;

import com.iamkurtgoz.instalikedialog.R;
import com.iamkurtgoz.instalikedialog.builder.BuilderDialogAndroid;
import com.iamkurtgoz.instalikedialog.builder.BuilderListAndroid;
import com.iamkurtgoz.instalikedialog.list.models.DModel;

public class InitListAndroid {

    public Context context;
    private Boolean isCancelable = true, isTitleActive = false;
    private String title = "";
    private int textColor, textSize = 14, textGravity = Gravity.START;
    private boolean itemIconActive = false;

    private DModel[] customData;
    private BuilderListAndroid.DialogClickCallBack dialogClickCallBack;

    public InitListAndroid(Context context, DModel[] customData){
        this.context = context;
        this.customData = customData;
        //default text color.
        this.textColor = context.getResources().getColor(R.color.black);
    }

    public InitListAndroid setDialogClickCallBack(BuilderListAndroid.DialogClickCallBack dialogClickCallBack) {
        this.dialogClickCallBack = dialogClickCallBack;
        return this;
    }
    public InitListAndroid setCancelable(Boolean cancelable) {
        isCancelable = cancelable;
        return this;
    }

    public Boolean getCancelable() {
        return isCancelable;
    }

    public Boolean getTitleActive() {
        return isTitleActive;
    }

    public InitListAndroid setTitle(String title) {
        if (title != null){
            this.title = title;
            this.isTitleActive = true;
        }
        return this;
    }

    public String getTitle() {
        return title;
    }

    public InitListAndroid setTextColor(int textColor) {
        this.textColor = textColor;
        return this;
    }

    public int getTextColor() {
        return textColor;
    }

    public InitListAndroid setTextSize(int textSize) {
        this.textSize = textSize;
        return this;
    }

    public int getTextSize() {
        return textSize;
    }

    public InitListAndroid setTextGravity(int textGravity) {
        this.textGravity = textGravity;
        return this;
    }

    public int getTextGravity() {
        return textGravity;
    }

    public InitListAndroid setItemIconActive(boolean itemIconActive) {
        this.itemIconActive = itemIconActive;
        return this;
    }

    public boolean isItemIconActive() {
        return itemIconActive;
    }

    public DModel[] getCustomData() {
        return customData;
    }

    public BuilderListAndroid.DialogClickCallBack getDialogClickCallBack() {
        return dialogClickCallBack;
    }

    public void show() {
        new BuilderListAndroid(this).show();
    }
}