package com.duke.yinyangli.bean.database;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "shuxianglove", createInDb = false)
public class ShuXiangLove {

    @Id
    @Property(nameInDb = "id")
    private Long id;

    @Property(nameInDb = "shengxiao1")
    private String shengxiao1;

    @Property(nameInDb = "shengxiao2")
    private String shengxiao2;

    @Property(nameInDb = "title")
    private String title;

    @Property(nameInDb = "content1")
    private String content1;

    @Property(nameInDb = "content11")
    private String content11;

    @Property(nameInDb = "content2")
    private String content2;

    @Property(nameInDb = "content22")
    private String content22;

    @Generated(hash = 1585770670)
    public ShuXiangLove(Long id, String shengxiao1, String shengxiao2, String title,
            String content1, String content11, String content2, String content22) {
        this.id = id;
        this.shengxiao1 = shengxiao1;
        this.shengxiao2 = shengxiao2;
        this.title = title;
        this.content1 = content1;
        this.content11 = content11;
        this.content2 = content2;
        this.content22 = content22;
    }

    @Generated(hash = 850841414)
    public ShuXiangLove() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShengxiao1() {
        return this.shengxiao1;
    }

    public void setShengxiao1(String shengxiao1) {
        this.shengxiao1 = shengxiao1;
    }

    public String getShengxiao2() {
        return this.shengxiao2;
    }

    public void setShengxiao2(String shengxiao2) {
        this.shengxiao2 = shengxiao2;
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

    public String getContent11() {
        return this.content11;
    }

    public void setContent11(String content11) {
        this.content11 = content11;
    }

    public String getContent2() {
        return this.content2;
    }

    public void setContent2(String content2) {
        this.content2 = content2;
    }

    public String getContent22() {
        return this.content22;
    }

    public void setContent22(String content22) {
        this.content22 = content22;
    }
}
