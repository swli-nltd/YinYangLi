package com.duke.yinyangli.bean.database;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "xingzuo", createInDb = false)
public class XingZuo {
    @Property(nameInDb = "title")
    private String title;//星座名：水瓶座

    @Property(nameInDb = "content")
    private String content;//星座运势

    @Generated(hash = 1330546069)
    public XingZuo(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Generated(hash = 1071142893)
    public XingZuo() {
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
