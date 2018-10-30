package com.iamkurtgoz.instalikedialog.list.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.andexert.library.RippleView;
import com.iamkurtgoz.instalikedialog.R;
import com.iamkurtgoz.instalikedialog.list.models.DModel;
import com.iamkurtgoz.instalikedialog.main.Init;

public class DAdapter extends ArrayAdapter<DModel> {

    public ClickCallBack clickCallBack;
    public interface ClickCallBack{
        void onClickListener(DModel model, int position);
    }

    public void setClickCallBack(ClickCallBack clickCallBack) {
        this.clickCallBack = clickCallBack;
    }

    private Init initDialog;
    private final LayoutInflater inflater;
    private final Context context;
    private ViewHolder holder;
    private DModel[] customData;

    public DAdapter(Init initDialog, DModel[] customData) {
        super(initDialog.context,0, customData);
        this.initDialog = initDialog;
        this.context = initDialog.context;
        this.customData = customData;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return customData.length;
    }

    @Override
    public DModel getItem(int position) {
        return customData[position];
    }

    @Override
    public long getItemId(int position) {
        return customData[position].hashCode();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if (convertView == null) {

            convertView = inflater.inflate(R.layout.list_item_custom_instagram_like_dialog_row, null);

            holder = new ViewHolder();
            holder.rippleView = (RippleView) convertView.findViewById(R.id.list_item_custom_instagram_like_dialog_row_rippleView);
            holder.textTitle = (TextView) convertView.findViewById(R.id.list_item_custom_instagram_like_dialog_row_textTitle);
            holder.imgItemIcon = (ImageView) convertView.findViewById(R.id.list_item_custom_instagram_like_dialog_row_imgItemIcon);
            convertView.setTag(holder);

        }
        else{
            //Get viewholder we already created
            holder = (ViewHolder)convertView.getTag();
        }

        final DModel instagramModel = customData[position];
        if(instagramModel != null){
            holder.imgItemIcon.setVisibility(initDialog.isItemIconActive() ? View.VISIBLE : View.GONE);
            if (initDialog.isItemIconActive()){
                holder.imgItemIcon.setImageResource(instagramModel.getIcon());
            }

            holder.textTitle.setGravity(initDialog.getTextGravity());
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
        ImageView imgItemIcon;
        TextView textTitle;

    }
}