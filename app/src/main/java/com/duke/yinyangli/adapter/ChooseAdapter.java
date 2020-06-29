package com.duke.yinyangli.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.duke.yinyangli.R;
import com.duke.yinyangli.activity.ResultActivity;
import com.duke.yinyangli.constants.Constants;
import com.haibin.calendarview.library.Article;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ChooseAdapter extends RecyclerView.Adapter<ChooseAdapter.ViewHolder> {

    private Context mContext;
    private List<Article> mData = new ArrayList<>();

    public ChooseAdapter(Context context) {
        mContext = context;
        loadRes();
    }

    private void loadRes() {
        mData.add(Article.create("蓍草占卜", "", R.mipmap.zhanbushicao).setType(Constants.TYPE.TYPE_CAO));
        mData.add(Article.create("掷钱占卜", "", R.mipmap.qian).setType(Constants.TYPE.TYPE_QIAN));
        mData.add(Article.create("称骨算命", "", R.mipmap.qian).setType(Constants.TYPE.TYPE_QIAN));
        mData.add(Article.create("生辰八字", "", R.mipmap.qian).setType(Constants.TYPE.TYPE_QIAN));
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_list_choose, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Article article = mData.get(position);
        holder.imageView.setImageResource(article.getImgRes());
        holder.titleView.setText(article.getTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ResultActivity.start(mContext, article);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView titleView;
        private ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.item_image);
            titleView = itemView.findViewById(R.id.item_title);
        }
    }
}
