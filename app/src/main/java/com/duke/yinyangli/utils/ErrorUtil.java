package com.duke.yinyangli.utils;

import android.content.Context;
import android.text.TextUtils;

import com.duke.yinyangli.R;

public class ErrorUtil {

    public static void handleError(Context context, String url, String code, String error) {
        String errorInfo = context.getString(R.string.error_internet);
        if (!TextUtils.isEmpty(error)) {
            errorInfo = error;
        }
        ToastUtil.show(context, errorInfo);
        return;
    }
}
