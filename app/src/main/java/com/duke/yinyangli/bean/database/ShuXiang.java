package com.duke.yinyangli.bean.database;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Property;

@Entity(nameInDb = "shuxiang")
public class ShuXiang {

    @Id
    private Long id;

    @Property(nameInDb = "title")
    private String title;//属相

    @Property(nameInDb = "content")
    private String content;//属相命运

    @Generated(hash = 836973599)
    public ShuXiang(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    @Generated(hash = 527992104)
    public ShuXiang() {
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
