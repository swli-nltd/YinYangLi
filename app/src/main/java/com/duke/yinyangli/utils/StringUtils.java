package com.duke.yinyangli.utils;

import android.content.Context;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

public class StringUtils {

    public static String getString(String origin) {
        return origin
                .replace("&nbsp;", " ")
                .replace("<BR>", "\n")
                .replace("<p>", "")
                .replace("</p>", "")
                .replace("<br>", "")
                .replace("<br/>", "")
                .replace("<br />", "")
                .replace("</font>", "")
                .replaceAll("<font.*>", "");
    }

    public static void setTextTwoLast(Context context, TextView tv, String before, String center, String last, int color) {
        SpannableString spanString = new SpannableString(before + center + last);
        spanString.setSpan(new ForegroundColorSpan(context.getResources().getColor(color))
                , before.length(), (before + center).length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); // 设置前景色为洋红色
        tv.setText(spanString);
    }
}
