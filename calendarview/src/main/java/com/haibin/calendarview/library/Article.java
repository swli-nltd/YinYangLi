package com.haibin.calendarview.library;

import java.io.Serializable;
import java.util.List;

/**
 * 一个简单的bean
 * Created by huanghaibin on 2017/12/4.
 */
@SuppressWarnings("all")
public class Article implements Serializable {
    private int id;
    private String title;
    private String content;
    private String imgUrl;
    private String desc;
    private String date;
    private int type;
    private int imgRes;


    public static Article create(String title, String content, String imgUrl) {
        Article article = new Article();
        article.setTitle(title);
        article.setContent(content);
        article.setImgUrl(imgUrl);
        return article;
    }
    public static Article create(String title, List<String> list, int imgRes) {
        Article article = new Article();
        article.setTitle(title);
        StringBuilder sb = new StringBuilder();
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i ++) {
                sb.append(list.get(i));
                if (i < list.size() - 1) {
                    sb.append(",");
                }
            }
            article.setContent(sb.toString());
        }
        article.setImgResource(imgRes);
        return article;
    }

    public static Article create(String title, String content, int imgRes) {
        Article article = new Article();
        article.setTitle(title);
        article.setContent(content);
        article.setImgResource(imgRes);
        return article;
    }


    public int getId() {
        return id;
    }

    public int getType() {
        return type;
    }

    public Article setType(int type) {
        this.type = type;
        return this;
    }

    public Article setId(int id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Article setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Article setContent(String content) {
        this.content = content;
        return this;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public Article setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
        return this;
    }

    public String getDesc() {
        return desc;
    }

    public Article setDesc(String desc) {
        this.desc = desc;
        return this;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getImgRes() {
        return imgRes;
    }

    public void setImgRes(int imgRes) {
        this.imgRes = imgRes;
    }

    public void setImgResource(int imgRes) {
        this.imgRes = imgRes;
    }
}
