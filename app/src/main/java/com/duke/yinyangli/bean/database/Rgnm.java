package com.duke.yinyangli.bean.database;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Keep;
import org.greenrobot.greendao.annotation.Property;

@Entity(nameInDb = "rgnm")
public class Rgnm {

    @Id
    private Long id;

    @Property(nameInDb = "rgz")
    private String rgz;//日干支

    @Property(nameInDb = "rgxx")
    private String rgxx;//日干性格

    @Property(nameInDb = "rgcz")
    private String rgcz;//日干支层次

    @Property(nameInDb = "rgzfx")
    private String rgzfx;//日干支分析

    @Property(nameInDb = "xgfx")
    private String xgfx;//性格分析

    @Property(nameInDb = "aqfx")
    private String aqfx;//爱情分析

    @Property(nameInDb = "syfx")
    private String syfx;//事业分析

    @Property(nameInDb = "cyfx")
    private String cyfx;//财运分析

    @Property(nameInDb = "jkfx")
    private String jkfx;//健康分析

    @Generated(hash = 968667188)
    public Rgnm(Long id, String rgz, String rgxx, String rgcz, String rgzfx,
            String xgfx, String aqfx, String syfx, String cyfx, String jkfx) {
        this.id = id;
        this.rgz = rgz;
        this.rgxx = rgxx;
        this.rgcz = rgcz;
        this.rgzfx = rgzfx;
        this.xgfx = xgfx;
        this.aqfx = aqfx;
        this.syfx = syfx;
        this.cyfx = cyfx;
        this.jkfx = jkfx;
    }

    @Generated(hash = 51751164)
    public Rgnm() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRgz() {
        return rgz;
    }

    public void setRgz(String rgz) {
        this.rgz = rgz;
    }

    public String getRgxx() {
        return rgxx;
    }

    public void setRgxx(String rgxx) {
        this.rgxx = rgxx;
    }

    public String getRgcz() {
        return rgcz;
    }

    public void setRgcz(String rgcz) {
        this.rgcz = rgcz;
    }

    public String getRgzfx() {
        return rgzfx;
    }

    public void setRgzfx(String rgzfx) {
        this.rgzfx = rgzfx;
    }

    public String getXgfx() {
        return xgfx;
    }

    public void setXgfx(String xgfx) {
        this.xgfx = xgfx;
    }

    public String getAqfx() {
        return aqfx;
    }

    public void setAqfx(String aqfx) {
        this.aqfx = aqfx;
    }

    public String getSyfx() {
        return syfx;
    }

    public void setSyfx(String syfx) {
        this.syfx = syfx;
    }

    public String getCyfx() {
        return cyfx;
    }

    public void setCyfx(String cyfx) {
        this.cyfx = cyfx;
    }

    public String getJkfx() {
        return jkfx;
    }

    public void setJkfx(String jkfx) {
        this.jkfx = jkfx;
    }
}
