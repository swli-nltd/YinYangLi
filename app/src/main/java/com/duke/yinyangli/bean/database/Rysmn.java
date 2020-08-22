package com.duke.yinyangli.bean.database;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Property;

@Entity(nameInDb = "rysmn", createInDb = false)
public class Rysmn {

    @Id
    @Property(nameInDb = "id")
    private Long id;

    @Property(nameInDb = "siceng")
    private String siceng;//时辰（六月/十二日/子时）

    @Property(nameInDb = "mingmi")
    private String mingmi;//命秘

    @Generated(hash = 1805217352)
    public Rysmn(Long id, String siceng, String mingmi) {
        this.id = id;
        this.siceng = siceng;
        this.mingmi = mingmi;
    }

    @Generated(hash = 1085522793)
    public Rysmn() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSiceng() {
        return siceng;
    }

    public void setSiceng(String siceng) {
        this.siceng = siceng;
    }

    public String getMingmi() {
        return mingmi;
    }

    public void setMingmi(String mingmi) {
        this.mingmi = mingmi;
    }
}
