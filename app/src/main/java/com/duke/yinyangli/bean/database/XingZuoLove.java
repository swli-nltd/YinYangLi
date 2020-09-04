package com.duke.yinyangli.bean.database;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "xingzuolove", createInDb = false)
public class XingZuoLove {


    @Property(nameInDb = "xingzuo1")
    private String xingzuo1;//女方星座


    @Property(nameInDb = "xingzuo2")
    private String xingzuo2;//男方星座


    @Property(nameInDb = "title")
    private String title;//title


    @Property(nameInDb = "content1")
    private String content1;//星级评分


    @Property(nameInDb = "content2")
    private String content2;//评测内容


    @Generated(hash = 122661059)
    public XingZuoLove(String xingzuo1, String xingzuo2, String title,
            String content1, String content2) {
        this.xingzuo1 = xingzuo1;
        this.xingzuo2 = xingzuo2;
        this.title = title;
        this.content1 = content1;
        this.content2 = content2;
    }


    @Generated(hash = 21964815)
    public XingZuoLove() {
    }


    public String getXingzuo1() {
        return this.xingzuo1;
    }


    public void setXingzuo1(String xingzuo1) {
        this.xingzuo1 = xingzuo1;
    }


    public String getXingzuo2() {
        return this.xingzuo2;
    }


    public void setXingzuo2(String xingzuo2) {
        this.xingzuo2 = xingzuo2;
    }


    public String getTitle() {
        return this.title;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    public String getContent1() {
        return this.content1;
    }


    public void setContent1(String content1) {
        this.content1 = content1;
    }


    public String getContent2() {
        return this.content2;
    }


    public void setContent2(String content2) {
        this.content2 = content2;
    }

}
