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
        "versionCode": 3,
        "totalBytes": 2,
        "forceUpdate": 1,
            "updateTitle": "有新的更新",
            "updateMessage": "1.算卦可选项完善到10种；
2.增加付费提醒，付费渠道暂无",
            "downloadUrl": "http://d.6short.com/ntw7"
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
