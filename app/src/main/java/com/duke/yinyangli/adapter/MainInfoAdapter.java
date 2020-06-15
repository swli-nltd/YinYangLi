package com.duke.yinyangli.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.duke.yinyangli.R;
import com.duke.yinyangli.calendar.Lunar;
import com.haibin.calendarview.group.GroupRecyclerAdapter;
import com.haibin.calendarview.library.Article;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

/**
 * 适配器
 * Created by huanghaibin on 2017/12/4.
 */

public class MainInfoAdapter extends GroupRecyclerAdapter<String, Article> {

    private RequestManager mLoader;
    private Lunar mLunar;

    public MainInfoAdapter(Context context) {
        super(context);
        mLoader = Glide.with(context.getApplicationContext());
    }

    public void setLunar(Lunar lunar) {
        mLunar = lunar;
        LinkedHashMap<String, List<Article>> map = new LinkedHashMap<>();
        List<String> titles = new ArrayList<>();
        map.put("今日宜忌", create(0));
        map.put("时辰宜忌", create(1));
        map.put("吉神凶煞", create(2));
        map.put("星宿吉凶", create(3));
        titles.add("今日宜忌");
        titles.add("时辰宜忌");
        titles.add("吉神凶煞");
        titles.add("星宿吉凶");
        resetGroups(map,titles);
    }


    @Override
    protected RecyclerView.ViewHolder onCreateDefaultViewHolder(ViewGroup parent, int type) {
        return new ArticleViewHolder(mInflater.inflate(R.layout.item_list_main, parent, false));
    }

    @Override
    protected void onBindViewHolder(RecyclerView.ViewHolder holder, Article item, int position) {
        ArticleViewHolder h = (ArticleViewHolder) holder;
        h.mTextTitle.setText(item.getTitle());
        h.mTextContent.setText(item.getContent());
        mLoader.load(!TextUtils.isEmpty(item.getImgUrl()) ? item.getImgUrl() : item.getImgRes())
                .centerCrop()
                .into(h.mImageView);
    }

    private static class ArticleViewHolder extends RecyclerView.ViewHolder {
        private TextView mTextTitle,
                mTextContent;
        private ImageView mImageView;

        private ArticleViewHolder(View itemView) {
            super(itemView);
            mTextTitle = itemView.findViewById(R.id.tv_title);
            mTextContent = itemView.findViewById(R.id.tv_content);
            mImageView = itemView.findViewById(R.id.imageView);
        }
    }

    private List<Article> create(int p) {
        List<Article> list = new ArrayList<>();
        if (p == 0) {
            list.add(Article.create("今日宜", mLunar.getDayYi(), R.mipmap.jinriyi));
            list.add(Article.create("今日忌", mLunar.getDayJi(), R.mipmap.jinriji));
        } else if (p == 1) {
            list.add(Article.create("当前时辰宜", mLunar.getTimeYi(), R.mipmap.jinriyi));
            list.add(Article.create("当前时辰忌", mLunar.getTimeJi(), R.mipmap.jinriji));
        } else if (p == 2) {
            list.add(Article.create("今日吉神", mLunar.getDayJiShen(), R.mipmap.ji));
            list.add(Article.create("今日凶煞", mLunar.getDayXiongSha(), R.mipmap.xiong));
        } else if (p == 3) {
            int image = R.mipmap.ji;
            if ("吉".equals(mLunar.getXiuLuck())) {
                image = R.mipmap.ji;
            } else {
                image = R.mipmap.xiong;
            }
            String title = "宿：" + mLunar.getXiu() + "  " + mLunar.getAnimal() + "  " + mLunar.getXiuLuck();
            list.add(Article.create(title, mLunar.getXiuSong().replace(",", ",\n")
                    .replace("，", "，\n"), image));
        }


        return list;
    }
}
