package com.iamkurtgoz.instalikedialog.list.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.andexert.library.RippleView;
import com.iamkurtgoz.instalikedialog.R;
import com.iamkurtgoz.instalikedialog.list.models.CustomInstagramLikeDialogModel;

import java.util.ArrayList;

public class CustomInstagramLikeDialogAdapter extends ArrayAdapter<CustomInstagramLikeDialogModel> {

    public ClickCallBack clickCallBack;
    public interface ClickCallBack{
        void onClickListener(CustomInstagramLikeDialogModel model, int position);
    }

    public void setClickCallBack(ClickCallBack clickCallBack) {
        this.clickCallBack = clickCallBack;
    }

    private final LayoutInflater inflater;
    private final Context context;
    private ViewHolder holder;
    private final ArrayList<CustomInstagramLikeDialogModel> arrayModel;

    public CustomInstagramLikeDialogAdapter(Context context, ArrayList<CustomInstagramLikeDialogModel> arrayModel) {
        super(context,0, arrayModel);
        this.context = context;
        this.arrayModel = arrayModel;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return arrayModel.size();
    }

    @Override
    public CustomInstagramLikeDialogModel getItem(int position) {
        return arrayModel.get(position);
    }

    @Override
    public long getItemId(int position) {
        return arrayModel.get(position).hashCode();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if (convertView == null) {

            convertView = inflater.inflate(R.layout.list_item_custom_instagram_like_dialog_row, null);

            holder = new ViewHolder();
            holder.rippleView = (RippleView) convertView.findViewById(R.id.list_item_custom_instagram_like_dialog_row_rippleView);
            holder.textTitle = (TextView) convertView.findViewById(R.id.list_item_custom_instagram_like_dialog_row_textTitle);
            convertView.setTag(holder);

        }
        else{
            //Get viewholder we already created
            holder = (ViewHolder)convertView.getTag();
        }

        final CustomInstagramLikeDialogModel instagramModel = arrayModel.get(position);
        if(instagramModel != null){
            holder.textTitle.setText(instagramModel.getTitle());
            holder.textTitle.setTextColor(instagramModel.getColor());
            holder.rippleView.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {
                @Override
                public void onComplete(RippleView rippleView) {
                    if (clickCallBack!=null){
                        clickCallBack.onClickListener(instagramModel,position);
                    }
                }
            });
        }
        return convertView;
    }

    private static class ViewHolder {
        RippleView rippleView;
        TextView textTitle;;

    }
}