package com.duke.yinyangli.activity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.duke.yinyangli.R;
import com.duke.yinyangli.utils.ImageUtils;

public class BackAdapter extends BaseAdapter {

    private Context mContext;
    private Bitmap mBitmap;

    public BackAdapter(Context context) {
        mContext = context;
        mBitmap = ImageUtils.blur(context, BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher), 25);
    }

    @Override
    public int getCount() {
        return 15;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder(convertView = LayoutInflater.from(mContext).inflate(R.layout.item_grid_background, parent, false));
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.background.setImageBitmap(mBitmap);
        Animation operatingAnim = AnimationUtils.loadAnimation(mContext, R.anim.rotate_man);
        LinearInterpolator lin = new LinearInterpolator();
        operatingAnim.setInterpolator(lin);
        holder.background.startAnimation(operatingAnim);
        return convertView;
    }

    static final class ViewHolder {

        ImageView background;

        public ViewHolder(View view) {
            background = view.findViewById(R.id.background);
            view.setTag(this);
        }
    }
}
