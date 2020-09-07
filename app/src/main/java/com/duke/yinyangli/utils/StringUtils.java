package com.duke.yinyangli.utils;

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
}
