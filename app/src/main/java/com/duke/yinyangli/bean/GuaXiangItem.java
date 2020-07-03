package com.duke.yinyangli.bean;

import com.duke.yinyangli.utils.core.ZhanBuUtils;

public class GuaXiangItem {

    private int value;//真实值，24,28,32,36
    private int yang;//1为阳，2为阴
    private String valueName;

    public GuaXiangItem(int value, boolean bian) {
        this.value = value;
        if (bian) {
            yang = ZhanBuUtils.getBianGua(value);
        } else {
            yang = ZhanBuUtils.getGua(value);
        }
        valueName = ZhanBuUtils.getResultCaoString(value);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getYang() {
        return yang;
    }

    public void setYang(int yang) {
        this.yang = yang;
    }

    public String getValueName() {
        return valueName;
    }
}
