package com.iamkurtgoz.instalikedialog.builder;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.widget.ListView;
import android.widget.TextView;

import com.iamkurtgoz.instalikedialog.R;
import com.iamkurtgoz.instalikedialog.init.InitListAndroid;
import com.iamkurtgoz.instalikedialog.list.adapters.DAndroidAdapter;
import com.iamkurtgoz.instalikedialog.list.models.DModel;

public class BuilderListAndroid extends Dialog {

    private InitListAndroid initDialog;
    private DialogClickCallBack dialogClickCallBack;

    public BuilderListAndroid(InitListAndroid initDialog) {
        super(initDialog.context);
        this.initDialog = initDialog;
        this.dialogClickCallBack = initDialog.getDialogClickCallBack();
    }

    public interface DialogClickCallBack{
        void onDialogClickListener(DModel model, int position);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setCancelable(initDialog.getCancelable());
        setContentView(R.layout.layout_list_android);

        ListView listView = (ListView) findViewById(R.id.layout_list_android_listView);
        TextView textTitle = (TextView) findViewById(R.id.layout_list_android_textTitle);

        textTitle.setText(initDialog.getTitle());
        textTitle.setTextColor(initDialog.getTextColor());
        textTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, initDialog.getTextSize());
        textTitle.setVisibility(initDialog.getTitleActive() ? View.VISIBLE : View.GONE);


        DAndroidAdapter customAdapter = new DAndroidAdapter(initDialog, initDialog.getCustomData());
        customAdapter.setClickCallBack(new DAndroidAdapter.ClickCallBack() {
            @Override
            public void onClickListener(DModel model, int position) {
                if (dialogClickCallBack != null){
                    dialogClickCallBack.onDialogClickListener(model, position);
                }
                dismiss();
            }
        });
        listView.setAdapter(customAdapter);

    }
}

