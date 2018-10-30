package com.iamkurtgoz.instalikedialog_sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.iamkurtgoz.instalikedialog.list.models.DModel;
import com.iamkurtgoz.instalikedialog.main.Builder;
import com.iamkurtgoz.instalikedialog.main.InstaDialog;

public class MainActivity extends AppCompatActivity implements Builder.DialogClickCallBack {

    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.activity_main_btnDialog);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });
    }

    private void openDialog(){
        DModel[] customData = new DModel[]{
                new DModel(getString(R.string.follow), R.drawable.instagram_icon),
                new DModel(getString(R.string.get_profile), R.drawable.instagram_icon_2),
                new DModel(getString(R.string.block), R.drawable.instagram_icon_3)
        };

        InstaDialog.with(MainActivity.this)
                .init(customData, this)
                .setTitle("Instagram Dialog")
                .setTextSize(15)
                .setTextGravity(Gravity.START)
                .setCancelable(true)
                .setItemIconActive(true)
                .show();
    }

    @Override
    public void onDialogClickListener(DModel model, int position) {
        Toast.makeText(this, "Text : " + model.getTitle() + ", position : " + position, Toast.LENGTH_SHORT).show();
    }
}
