package com.duke.yinyangli.utils.core;

import android.content.Context;
import android.text.TextUtils;

import com.duke.yinyangli.bean.ChengGuItem;
import com.duke.yinyangli.interfaces.OnLoadListener;
import com.duke.yinyangli.utils.JsonUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 称骨算命
 */
public class ChengguUtils {
 
    int yy[] = {0, 6, 8, 7, 5, 15, 6, 16, 15, 7, 9, 12, 10,
        7, 15, 6, 5, 14, 14, 9, 7, 7, 9, 12, 8,
        7, 13, 5, 14, 5, 9, 17, 5, 7, 12, 8, 8,
        6, 19, 6, 8, 16, 10, 6, 12, 9, 6, 7, 12,
        5, 9, 8, 7, 8, 15, 9, 16, 8, 8, 19, 12};
    int mm[] = {0, 6, 7, 18, 9, 5, 16, 9, 15, 18, 8, 9, 5};
    int dd[] = {0, 5, 10, 8, 15, 16, 15, 8, 16, 8, 16, 19, 17, 8, 17, 10,
        8, 9, 18, 5, 15, 10, 9, 8, 9, 15, 18, 7, 8, 16, 6};
    int hh[] = {0, 0, 6, 7, 10, 9, 16, 10, 8, 8, 9, 6, 6, 16};

    private static ChengguUtils mInstance;

    public static ChengguUtils getInstance() {
        if (mInstance == null) {
            mInstance = new ChengguUtils();
        }
        return mInstance;
    }
    /**
     *
     * @param year 年
     * @param month 月
     * @param day 日
     * @param hour 时
     * @return
     */
    public int[] chenggu(int year, int month, int day, int hour) {
        int zong, zong1, zong2, n;
        if (hour % 2 == 0) {
            n = (hour + 2) / 2;
        } else {
            n = (hour + 3) / 2;
        }
        zong = yy[(year - 1821) % 60 + 1] + mm[month] + dd[day] + hh[n];
        zong1 = zong % 10;
        zong2 = zong / 10;
 
        System.out.print("你的命有" + zong2 + "两" + zong1 + "钱!\n\n");
        return new int[]{zong2, zong1};
    }


    public void getJson(Context context, String name, OnLoadListener<ChengGuItem> listener) {
        InputStream is = null;
        ByteArrayOutputStream bos = null;
        try {
            is = context.getAssets().open("chenggu/" + name + ".json");
            bos = new ByteArrayOutputStream();
            byte[] bytes = new byte[4 * 1024];
            int len = 0;
            while ((len = is.read(bytes)) != -1) {
                bos.write(bytes, 0, len);
            }
            final String json = new String(bos.toByteArray());
            if (!TextUtils.isEmpty(json)) {
                ChengGuItem item = null;
                item = JsonUtils.fromJson(json, ChengGuItem.class);
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
