package com.iamkurtgoz.instalikedialog.builder;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieDrawable;
import com.iamkurtgoz.instalikedialog.R;
import com.iamkurtgoz.instalikedialog.init.InitProgressDialog;

public class BuilderProgressDialog extends Dialog {

    public static BuilderProgressDialog with(InitProgressDialog initProgressDialog) {
        return new BuilderProgressDialog(initProgressDialog);
    }

    private BuilderProgressDialog(InitProgressDialog initProgressDialog){
        super(initProgressDialog.getContext());
        this.initProgressDialog = initProgressDialog;
        setCancelable(initProgressDialog.getCancelable());
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

    private InitProgressDialog initProgressDialog;
    private LottieAnimationView lottieAnimationView;
    private TextView textTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setContentView(R.layout.layout_progress_dialog);

        lottieAnimationView = (LottieAnimationView) findViewById(R.id.layout_progress_dialog_lottieView);
        textTitle = (TextView) findViewById(R.id.layout_progress_dialog_textTitle);

        textTitle.setText(initProgressDialog.getTitle());
        textTitle.setTextColor(initProgressDialog.getTextColor());
        textTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, initProgressDialog.getTextSize());
        if (initProgressDialog.getTitle().trim().equalsIgnoreCase("")){
            textTitle.setVisibility(View.GONE);
        }

        if (initProgressDialog.getLottieRaw() != -1){
            lottieAnimationView.setAnimation(initProgressDialog.getLottieRaw());
        }
        lottieAnimationView.setRepeatCount(initProgressDialog.getRepeatCount());
    }

}