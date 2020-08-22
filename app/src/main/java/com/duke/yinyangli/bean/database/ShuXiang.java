package com.duke.yinyangli.bean.database;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Property;

@Entity(nameInDb = "shuxiang", createInDb = false)
public class ShuXiang {

    @Property(nameInDb = "title")
    private String title;//属相

    @Property(nameInDb = "content")
    private String content;//属相命运

    @Generated(hash = 1857868818)
    public ShuXiang(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Generated(hash = 527992104)
    public ShuXiang() {
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
