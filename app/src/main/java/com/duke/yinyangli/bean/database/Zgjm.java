package com.duke.yinyangli.bean.database;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "zgjm", createInDb = false)
public class Zgjm {

    @Id
    @Property(nameInDb = "id")
    private Long id;

    @Property(nameInDb = "jmlb")
    private String jmlb;

    @Property(nameInDb = "title")
    private String title;

    @Property(nameInDb = "content")
    private String content;

    @Generated(hash = 101863617)
    public Zgjm(Long id, String jmlb, String title, String content) {
        this.id = id;
        this.jmlb = jmlb;
        this.title = title;
        this.content = content;
    }

    @Generated(hash = 376632342)
    public Zgjm() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJmlb() {
        return this.jmlb;
    }

    public void setJmlb(String jmlb) {
        this.jmlb = jmlb;
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
