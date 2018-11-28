package com.iamkurtgoz.instalikedialog.init;

import android.app.Dialog;
import android.content.Context;

import com.iamkurtgoz.instalikedialog.R;
import com.iamkurtgoz.instalikedialog.builder.BuilderProgressDialog;

public class InitProgressDialog {

    private Context context;
    private Boolean isCancelable = true, withoutLottie = false;
    private String title = "";
    private int textColor, textSize = 14;
    private int lottieRaw = R.raw.settings_loading, repeatCount = -1;

    public InitProgressDialog(Context context){
        this.context = context;
    }

    public InitProgressDialog setCancelable(Boolean cancelable) {
        isCancelable = cancelable;
        return this;
    }

    public InitProgressDialog setTitle(String title) {
        this.title = title;
        return this;
    }

    public InitProgressDialog setTextColor(int textColor) {
        this.textColor = textColor;
        return this;
    }

    public InitProgressDialog setTextSize(int textSize) {
        this.textSize = textSize;
        return this;
    }

    public InitProgressDialog setLottieRaw(int lottieRaw) {
        this.lottieRaw = lottieRaw;
        return this;
    }

    public InitProgressDialog setRepeatCount(int repeatCount) {
        this.repeatCount = repeatCount;
        return this;
    }

    public InitProgressDialog setWithoutLottie(Boolean withoutLottie) {
        this.withoutLottie = withoutLottie;
        return this;
    }

    public Boolean getCancelable() {
        return isCancelable;
    }

    public String getTitle() {
        return title;
    }

    public int getTextColor() {
        return textColor;
    }

    public int getTextSize() {
        return textSize;
    }

    public int getLottieRaw() {
        return lottieRaw;
    }

    public int getRepeatCount() {
        return repeatCount;
    }

    public Boolean getWithoutLottie() {
        return withoutLottie;
    }

    public Context getContext() {
        return context;
    }

    public Dialog build(){
        return BuilderProgressDialog.with(this);
    }
}
