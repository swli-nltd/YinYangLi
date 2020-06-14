package com.duke.yinyangli.utils;

import java.util.Random;

public class ZhanBuUtils {

    public static String getResultCaoString(int result) {
        switch (result) {
            case 24:
                return "老阴";
            case 28:
                return "少阳";
            case 32:
                return "少阴";
            case 36:
                return "老阳";
                default:break;
        }
        return "少阴";
    }

    public static int getResultCao() {
        Random random = new Random();
        int first = random.nextInt(40) + 5;
        int second;
        int third;
        int fourth;
        if (first % 4 == 0) {
            second = random.nextInt(32) + 5;
            if (second % 4 == 1 || second % 4 == 2) {
                third = random.nextInt(28) + 5;
                if (third % 4 == 1 || third == 2) {
                    fourth = 32;
                } else {
                    fourth = 28;
                }
            } else {
                third = random.nextInt(24) + 5;
                if (third % 4 == 1 || third == 2) {
                    fourth = 28;
                } else {
                    fourth = 24;
                }
            }
        } else {
            second = random.nextInt(36) + 5;
            if (second % 4 == 1 || second % 4 == 2) {
                third = random.nextInt(32) + 5;
                if (third % 4 == 1 || third % 4 == 2) {
                    fourth = 36;
                } else {
                    fourth = 32;
                }
            } else {
                third = random.nextInt(28) + 5;
                if (third % 4 == 1 || third % 4 == 2) {
                    fourth = 32;
                } else {
                    fourth = 28;
                }
            }
        }
        return fourth;
    }
}
