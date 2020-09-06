package com.duke.yinyangli.bean.database;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "zhuge", createInDb = false)
public class Zhuge {

    @Id
    @Property(nameInDb = "id")
    private Long id;

    @Property(nameInDb = "title")
    private String title;

    @Property(nameInDb = "content")
    private String content;

    @Generated(hash = 1618233969)
    public Zhuge(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    @Generated(hash = 1032550830)
    public Zhuge() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
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
