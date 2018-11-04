package com.iamkurtgoz.instalikedialog.builder;

import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.iamkurtgoz.instalikedialog.R;
import com.iamkurtgoz.instalikedialog.init.InitDialogAndroid;
import com.iamkurtgoz.instalikedialog.init.InitListAndroid;
import com.iamkurtgoz.instalikedialog.list.adapters.DAndroidAdapter;
import com.iamkurtgoz.instalikedialog.list.models.DModel;
import com.iamkurtgoz.instalikedialog.view.CircularImageView;
import com.iamkurtgoz.instalikedialog.view.FileOpenToByte;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class BuilderDialogAndroid extends Dialog {

    private InitDialogAndroid initDialog;
    private DialogClickCallBack dialogClickCallBack;

    public BuilderDialogAndroid(InitDialogAndroid initDialog) {
        super(initDialog.context);
        this.initDialog = initDialog;
        this.dialogClickCallBack= initDialog.dialogClickCallBack;
    }

    public interface DialogClickCallBack{
        void onDialogCancelClickListener();
        void onDialogConfirmClickListner();
    }

    @Override
    public void onStart() {
        super.onStart();
        int dialogWidth = ViewGroup.LayoutParams.MATCH_PARENT;
        int dialogHeight = ViewGroup.LayoutParams.WRAP_CONTENT;
        if (getWindow() != null) {
            WindowManager.LayoutParams lp = getWindow().getAttributes();
            lp.gravity = Gravity.CENTER;
            lp.dimAmount = 0.5f;
            lp.flags |= WindowManager.LayoutParams.FLAG_DIM_BEHIND;
            getWindow().setAttributes(lp);
            getWindow().setLayout(dialogWidth, dialogHeight);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setCancelable(initDialog.getCancelable());
        setContentView(R.layout.layout_dialog_android);

        FrameLayout frameContent = (FrameLayout) findViewById(R.id.list_dialog_android_frameContent);
        final CircularImageView circularImageView = (CircularImageView) findViewById(R.id.list_dialog_android_imgAvatar);
        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.list_dialog_android_prgLoading);
        TextView textTitle = (TextView) findViewById(R.id.list_dialog_android_textTitle);
        Button btnCancel = (Button) findViewById(R.id.list_dialog_android_btnCancel);
        Button btnConfirm = (Button) findViewById(R.id.list_dialog_android_btnConfirm);

        circularImageView.setVisibility(initDialog.getImgAvatarActive() ? View.VISIBLE : View.GONE);
        textTitle.setText(initDialog.getTitle());
        textTitle.setTextColor(initDialog.getTextColor());
        textTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, initDialog.getTextSize());

        if (initDialog.getImgAvatarActive()){
            if (initDialog.getProfileIconUrl() != null){

                progressBar.setVisibility(View.VISIBLE);
                circularImageView.setVisibility(View.GONE);
                Picasso.get()
                        .load(initDialog.getProfileIconUrl())
                        .into(circularImageView, new Callback() {
                            @Override
                            public void onSuccess() {
                                progressBar.setVisibility(View.GONE);
                                circularImageView.setVisibility(View.VISIBLE);
                            }

                            @Override
                            public void onError(Exception e) {
                                progressBar.setVisibility(View.GONE);
                                circularImageView.setVisibility(View.VISIBLE);
                            }
                        });
            } else if (initDialog.getProfileIconResource() != -1){
                progressBar.setVisibility(View.GONE);
                circularImageView.setImageResource(initDialog.getProfileIconResource());
            }
        } else {
            frameContent.setVisibility(View.GONE);
        }

        btnCancel.setText(initDialog.getCancelButton());
        btnConfirm.setText(initDialog.getConfirmButton());

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dialogClickCallBack != null){
                    dialogClickCallBack.onDialogCancelClickListener();
                }
                dismiss();
            }
        });

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dialogClickCallBack != null){
                    dialogClickCallBack.onDialogConfirmClickListner();
                }
                dismiss();
            }
        });
    }
}

