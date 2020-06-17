package com.duke.yinyangli.bean;

public class JieGuaItem {

    private String code;
    private String name;
    private String description;
    private String level;
    private String secondName;

    private String jiegua;
    private String yuanwen;
    private String jiewen;
    private String zhujie;
    private String guacishi;

    public JieGuaItem() {
    }

    public String getSecondName() {
        return secondName;
    }

    public JieGuaItem setSecondName(String secondName) {
        this.secondName = secondName;
        return this;
    }

    public String getJiegua() {
        return jiegua;
    }

    public void setJiegua(String jiegua) {
        this.jiegua = jiegua;
    }

    public String getYuanwen() {
        return yuanwen;
    }

    public void setYuanwen(String yuanwen) {
        this.yuanwen = yuanwen;
    }

    public String getJiewen() {
        return jiewen;
    }

    public void setJiewen(String jiewen) {
        this.jiewen = jiewen;
    }

    public String getZhujie() {
        return zhujie;
    }

    public void setZhujie(String zhujie) {
        this.zhujie = zhujie;
    }

    public String getGuacishi() {
        return guacishi;
    }

    public void setGuacishi(String guacishi) {
        this.guacishi = guacishi;
    }

    public String getLevel() {
        return level;
    }

    public JieGuaItem setLevel(String level) {
        this.level = level;
        return this;
    }

    public String getCode() {
        return code;
    }

    public JieGuaItem setCode(String code) {
        this.code = code;
        return this;
    }

    public String getName() {
        return name;
    }

    public JieGuaItem setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public JieGuaItem setDescription(String description) {
        this.description = description;
        return this;
    }
}
