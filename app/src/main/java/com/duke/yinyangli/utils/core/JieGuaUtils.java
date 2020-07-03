package com.duke.yinyangli.utils.core;

import android.content.Context;
import android.text.TextUtils;

import com.duke.yinyangli.bean.JieGuaItem;
import com.duke.yinyangli.interfaces.OnLoadListener;
import com.duke.yinyangli.utils.JsonUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class JieGuaUtils {

    private static JieGuaUtils mInstance;

    public static JieGuaUtils getInstance() {
        if (mInstance == null) {
            mInstance = new JieGuaUtils();
        }
        return mInstance;
    }

    public void getGuaJson(Context context, String name, OnLoadListener<JieGuaItem> listener) {
        InputStream is = null;
        ByteArrayOutputStream bos = null;
        try {
            is = context.getAssets().open("zhanbu/" + name + ".json");
            bos = new ByteArrayOutputStream();
            byte[] bytes = new byte[4 * 1024];
            int len = 0;
            while ((len = is.read(bytes)) != -1) {
                bos.write(bytes, 0, len);
            }
            final String json = new String(bos.toByteArray());
            if (!TextUtils.isEmpty(json)) {
                JieGuaItem item = null;
                item = JsonUtils.fromJson(json, JieGuaItem.class);
                if (listener != null) {
                    if (item != null) {
                        listener.onLoad(json, item);
                    } else {
                        listener.onLoad(json, null);
                    }
                }
            } else {
                if (listener != null) {
                    listener.onLoad(json, null);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
                if (bos != null) {
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
