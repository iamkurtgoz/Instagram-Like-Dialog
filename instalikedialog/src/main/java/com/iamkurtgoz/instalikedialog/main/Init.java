package com.iamkurtgoz.instalikedialog.main;

import android.content.Context;
import android.view.Gravity;

import com.iamkurtgoz.instalikedialog.R;
import com.iamkurtgoz.instalikedialog.list.models.DModel;

public class Init {

    public Context context;
    private Boolean isCancelable = true, isTitleActive = false;
    private String title = "";
    private int textColor, textSize = 14, textGravity = Gravity.START, titleIconResource = R.drawable.instagram_icon_2;
    private boolean titleIconActive = false, itemIconActive = false;

    private DModel[] customData;
    private Builder.DialogClickCallBack dialogClickCallBack;

    public Init(Context context, DModel[] customData, Builder.DialogClickCallBack dialogClickCallBack){
        this.context = context;
        this.customData = customData;
        this.dialogClickCallBack = dialogClickCallBack;

        //default text color.
        this.textColor = context.getResources().getColor(R.color.black);
    }

    public Init setCancelable(Boolean cancelable) {
        isCancelable = cancelable;
        return this;
    }

    public Boolean getCancelable() {
        return isCancelable;
    }

    public Boolean getTitleActive() {
        return isTitleActive;
    }

    public Init setTitle(String title) {
        if (title != null){
            this.title = title;
            this.isTitleActive = true;
        }
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Init setTextColor(int textColor) {
        this.textColor = textColor;
        return this;
    }

    public int getTextColor() {
        return textColor;
    }

    public Init setTextSize(int textSize) {
        this.textSize = textSize;
        return this;
    }

    public int getTextSize() {
        return textSize;
    }

    public Init setTextGravity(int textGravity) {
        this.textGravity = textGravity;
        return this;
    }

    public int getTextGravity() {
        return textGravity;
    }

    public Init setItemIconActive(boolean itemIconActive) {
        this.itemIconActive = itemIconActive;
        return this;
    }

    public boolean isItemIconActive() {
        return itemIconActive;
    }

    public boolean isTitleIconActive() {
        return titleIconActive;
    }

    public Init setTitleIconResource(int titleIconResource) {
        this.titleIconResource = titleIconResource;
        this.titleIconActive = true;
        return this;
    }

    public int getTitleIconResource() {
        return titleIconResource;
    }

    public DModel[] getCustomData() {
        return customData;
    }

    public Builder.DialogClickCallBack getDialogClickCallBack() {
        return dialogClickCallBack;
    }

    public void show() {
        new Builder(this).show();
    }
}
