package com.duke.yinyangli.bean;

import com.haibin.calendarview.library.Article;

import java.util.List;

public class MainInfoModel {
    private String title;
    private List<Article> list;

    public MainInfoModel(String title, List<Article> list) {
        this.title = title;
        this.list = list;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Article> getList() {
        return list;
    }

    public void setList(List<Article> list) {
        this.list = list;
    }
}
