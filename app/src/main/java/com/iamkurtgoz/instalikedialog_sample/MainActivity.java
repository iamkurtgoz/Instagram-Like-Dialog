package com.iamkurtgoz.instalikedialog_sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.iamkurtgoz.instalikedialog.list.models.CustomInstagramLikeDialogModel;
import com.iamkurtgoz.instalikedialog.main.InstaDialog;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements InstaDialog.DialogClickCallBack {

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
        ArrayList<CustomInstagramLikeDialogModel> arrayList = new ArrayList<>();
        arrayList.add(new CustomInstagramLikeDialogModel(
                getString(R.string.follow),
                MainActivity.this
        )); //default value, color = black, special id = -1

        arrayList.add(new CustomInstagramLikeDialogModel(
                getString(R.string.get_profile),
                1,
                getResources().getColor(R.color.blue)
        )); //color = blue, special id = 1

        arrayList.add(new CustomInstagramLikeDialogModel(
                getString(R.string.block),
                123,
                getResources().getColor(R.color.brand_red)
        )); //color red, special id = 123

        //new InstaDialog(MainActivity.this, arrayList).setDialogClickCallBack(this).show();
        //or
        new InstaDialog(MainActivity.this, arrayList, this)
                .setTextTitle("Instagram Like Dialog")
                .setTextColor(getResources().getColor(R.color.blue))
                .setTextSize(18)
                .setDialogCancelable(true).show();
    }

    @Override
    public void onDialogClickListener(CustomInstagramLikeDialogModel model, int position) {
        Toast.makeText(this, "Text : " + model.getTitle() + ", position : " + position, Toast.LENGTH_SHORT).show();
    }
}
