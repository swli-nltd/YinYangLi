package com.duke.yinyangli.bean;

import com.duke.yinyangli.base.BaseModel;

public class VersionResponse extends BaseModel {

    private int versionCode;
    private String updateTitle;
    private String updateMessage;
    private long totalBytes;
    private String downloadUrl;
    private String forceUpdate;//1强制更新，不显示cancel

    /*{
        "versionCode": 2,
        "totalBytes": 2,
        "forceUpdate": 1,
            "updateTitle": "有新的更新",
            "updateMessage": "1.增加八卦算命
2.在已有的四种算卦方式中增加温馨提示弹窗
3.优化蓍草占卜法的算法
4.在首页增加当天神兽等日期信息及时辰信息
5.启动页底部增加版本号
6.预增六种可选，敬请期待",
            "downloadUrl": "http://d.firim.info/ntw7"
    }*/
    public long getTotalBytes() {
        return totalBytes;
    }

    public void setTotalBytes(long totalBytes) {
        this.totalBytes = totalBytes;
    }

    public int getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(int versionCode) {
        this.versionCode = versionCode;
    }

    public String getUpdateMessage() {
        return updateMessage;
    }

    public void setUpdateMessage(String updateMessage) {
        this.updateMessage = updateMessage;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public String getUpdateTitle() {
        return updateTitle;
    }

    public void setUpdateTitle(String updateTitle) {
        this.updateTitle = updateTitle;
    }

    public String getForceUpdate() {
        return forceUpdate;
    }

    public void setForceUpdate(String forceUpdate) {
        this.forceUpdate = forceUpdate;
    }
}
