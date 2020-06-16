package com.duke.yinyangli.bean;

public class JieGuaItem {

    private String code;
    private String name;
    private String description;
    private String level;
    private String secondName;
    private String guaci;
    private String result;

    public JieGuaItem(String code, String name, String description, String level, String secondName) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.level = level;
        this.secondName = secondName;
    }
    public JieGuaItem(String code, String name, String description, String level) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.level = level;
    }

    public JieGuaItem() {
    }

    public String getSecondName() {
        return secondName;
    }

    public JieGuaItem setSecondName(String secondName) {
        this.secondName = secondName;
        return this;
    }

    public String getGuaci() {
        return guaci;
    }

    public JieGuaItem setGuaci(String guaci) {
        this.guaci = guaci;
        return this;
    }

    public String getLevel() {
        return level;
    }

    public JieGuaItem setLevel(String level) {
        this.level = level;
        return this;
    }

    public String getResult() {
        return result;
    }

    public JieGuaItem setResult(String result) {
        this.result = result;
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
