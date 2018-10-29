package com.iamkurtgoz.instalikedialog.main;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.widget.ListView;
import android.widget.TextView;

import com.iamkurtgoz.instalikedialog.R;
import com.iamkurtgoz.instalikedialog.list.adapters.CustomInstagramLikeDialogAdapter;
import com.iamkurtgoz.instalikedialog.list.models.CustomInstagramLikeDialogModel;

import java.util.ArrayList;

public class InstaDialog extends Dialog implements CustomInstagramLikeDialogAdapter.ClickCallBack{

    private Context context;
    private ListView listView;
    private TextView textTitle;

    private ArrayList<CustomInstagramLikeDialogModel> arrayList;
    private DialogClickCallBack dialogClickCallBack;

    private Boolean isCancelable = true, isTitleActive = false;
    private String title = "";
    private int textColor, textSize = 14;

    public InstaDialog(Context context, ArrayList<CustomInstagramLikeDialogModel> arrayList) {
        super(context);
        this.context = context;
        this.arrayList = arrayList;

        this.textColor = context.getResources().getColor(R.color.black);
    }

    public InstaDialog(Context context, ArrayList<CustomInstagramLikeDialogModel> arrayList, DialogClickCallBack dialogClickCallBack) {
        super(context);
        this.context = context;
        this.arrayList = arrayList;
        this.dialogClickCallBack = dialogClickCallBack;

        this.textColor = context.getResources().getColor(R.color.black);
    }

    public InstaDialog setDialogClickCallBack(DialogClickCallBack dialogClickCallBack) {
        this.dialogClickCallBack = dialogClickCallBack;
        return this;
    }

    public interface DialogClickCallBack{
        void onDialogClickListener(CustomInstagramLikeDialogModel model, int position);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setCancelable(isCancelable);
        setContentView(R.layout.layout_instadialog);
        listView = (ListView) findViewById(R.id.layout_instadialog_listView);
        textTitle = (TextView) findViewById(R.id.layout_instadialog_textTitle);
        textTitle.setText(title);
        textTitle.setTextColor(textColor);
        textTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
        textTitle.setVisibility(isTitleActive ? View.VISIBLE : View.GONE);

        CustomInstagramLikeDialogAdapter customAdapter = new CustomInstagramLikeDialogAdapter(context,arrayList);
        customAdapter.setClickCallBack(this);
        listView.setAdapter(customAdapter);
    }

    public InstaDialog setDialogCancelable(boolean isCancelable){
        this.isCancelable = isCancelable;
        return this;
    }

    public InstaDialog setTextTitle(String title){
        if (title != null || !TextUtils.isEmpty(title)){
            this.title = title;
            this.isTitleActive = true;
        } else {
            this.isTitleActive = false;
        }
        return this;
    }

    public InstaDialog setTextColor(int color){
        this.textColor = color;
        return this;
    }

    public InstaDialog setTextSize(int textSize){
        this.textSize = textSize;
        return this;
    }

    @Override
    public void onClickListener(CustomInstagramLikeDialogModel model, int position) {
        if (dialogClickCallBack != null){
            dialogClickCallBack.onDialogClickListener(model, position);
        }
        dismiss();
    }
}
