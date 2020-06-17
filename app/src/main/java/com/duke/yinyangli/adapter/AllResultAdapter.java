package com.duke.yinyangli.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.duke.yinyangli.R;
import com.duke.yinyangli.activity.ResultActivity;
import com.duke.yinyangli.bean.JieGuaItem;
import com.haibin.calendarview.library.Article;

import java.util.ArrayList;
import java.util.List;

public class AllResultAdapter extends RecyclerView.Adapter<AllResultAdapter.ViewHolder> {

    private Context mContext;
    private List<Article> mData;

    public AllResultAdapter(Context context) {
        mContext = context;
    }

    public void setResult(JieGuaItem item) {
        if (mData == null) {
            mData = new ArrayList<>();
        } else {
            mData.clear();
        }
        mData.add(Article.create("解卦：" + item.getLevel() + " " + item.getDescription()
                + " " + item.getSecondName(), item.getJiegua(), 0));
        mData.add(Article.create("周易卦爻辞原文", item.getYuanwen(), 0));
        mData.add(Article.create("周易卦爻辞解文", item.getJiewen(), 0));
        mData.add(Article.create("卦爻辞注解", item.getZhujie(), 0));
        mData.add(Article.create("卦爻卦辞诗", item.getGuacishi(), 0));
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_list_all_result, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.updateView(mContext, position, mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData != null ? mData.size() : 0;
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView title, content;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_title);
            content = itemView.findViewById(R.id.tv_content);
        }

        public void updateView(Context context, int position, Article article) {
            title.setText(article.getTitle());
            content.setText(article.getContent());
        }
    }
}
