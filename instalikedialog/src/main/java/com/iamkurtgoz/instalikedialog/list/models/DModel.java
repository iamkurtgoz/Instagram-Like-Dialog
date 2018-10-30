package com.iamkurtgoz.instalikedialog.list.models;

import android.content.Context;
import android.graphics.Color;

import com.iamkurtgoz.instalikedialog.R;

public class DModel {

    private String title;
    private int color = Color.BLACK;
    private int icon = R.drawable.instagram_icon;

    public DModel(String title){
        this.title = title;
    }

    public DModel(String title, int icon){
        this.title = title;
        this.icon = icon;
    }

    public DModel(String title, int icon, int color){
        this.title = title;
        this.icon = icon;
        this.color = color;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
