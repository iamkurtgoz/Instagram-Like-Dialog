package com.iamkurtgoz.instalikedialog.list.models;

import android.content.Context;

import com.iamkurtgoz.instalikedialog.R;

public class CustomInstagramLikeDialogModel {

    private String title;
    private int color, id = -1;

    public CustomInstagramLikeDialogModel(String title, Context context){
        this.title = title;
        color = context.getResources().getColor(R.color.black);
    }

    public CustomInstagramLikeDialogModel(String title, int id, Context context){
        this.title = title;
        this.id = id;
        color = context.getResources().getColor(R.color.black);
    }

    public CustomInstagramLikeDialogModel(String title, int color){
        this.title = title;
        this.color = color;
    }


    public CustomInstagramLikeDialogModel(String title, int id, int color){
        this.title = title;
        this.id = id;
        this.color = color;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getColor() {
        return color;
    }
}
