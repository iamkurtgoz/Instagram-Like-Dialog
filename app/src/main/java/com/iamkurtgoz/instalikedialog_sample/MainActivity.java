package com.iamkurtgoz.instalikedialog_sample;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.iamkurtgoz.instalikedialog.builder.BuilderDialogAndroid;
import com.iamkurtgoz.instalikedialog.builder.BuilderListAndroid;
import com.iamkurtgoz.instalikedialog.list.models.DModel;
import com.iamkurtgoz.instalikedialog.main.InstaDialog;

public class MainActivity extends AppCompatActivity {

    private Button button1, button2, button3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.activity_main_btnDialog1);
        button2 = (Button) findViewById(R.id.activity_main_btnDialog2);
        button3 = (Button) findViewById(R.id.activity_main_btnDialog3);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAndroidListDialog();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAndroidDialog();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openProgressDialog();
            }
        });
    }

    private void openAndroidListDialog(){
        DModel[] customData = new DModel[]{
                new DModel(getString(R.string.follow), R.drawable.instagram_icon),
                new DModel(getString(R.string.get_profile), R.drawable.instagram_icon_2),
                new DModel(getString(R.string.block), R.drawable.instagram_icon_3)
        };

        InstaDialog.with(MainActivity.this)
                .androidList(customData)
                .setDialogClickCallBack(new BuilderListAndroid.DialogClickCallBack() {
                    @Override
                    public void onDialogClickListener(DModel model, int position) {
                        Toast.makeText(MainActivity.this, "Text : " + model.getTitle() + ", position : " + position, Toast.LENGTH_SHORT).show();
                    }
                })
                .setTextSize(15)
                .setTextGravity(Gravity.START)
                .setCancelable(true)
                .setItemIconActive(false)
                .show();
    }

    private void openAndroidDialog(){
        InstaDialog.with(MainActivity.this)
                .androidDialog("Fikrini değiştirirsen, @iamkurtgoz'e tekrar takip isteği göndermen gerekecek.", "İptal", "Kabul")
                .setProfileIconUrl("https://instagram.fist4-1.fna.fbcdn.net/vp/807d164c60a4e48041b9a095c5da5df7/5C691F53/t51.2885-19/s640x640/20838301_1915234258688325_4142410044761178112_n.jpg")
                .setDialogClickCallBack(new BuilderDialogAndroid.DialogClickCallBack() {
                    @Override
                    public void onDialogCancelClickListener() {
                        Toast.makeText(MainActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onDialogConfirmClickListner() {
                        Toast.makeText(MainActivity.this, "Confirm", Toast.LENGTH_SHORT).show();
                    }
                }).show();
    }

    /**
     * default value R.raw.settings_loading
     *
     */
    private void openProgressDialog(){
        InstaDialog.with(MainActivity.this)
                .progressDialog()
                .setWithoutLottie(false)
                .setTitle("Wait")
                .setTextColor(Color.BLACK)
                .build().show();
    }

}
