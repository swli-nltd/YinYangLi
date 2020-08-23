package com.duke.yinyangli.utils.core;

import com.duke.yinyangli.bean.GuaXiangItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ZhanBuUtils {

    public static String getGua(List<Integer> list, boolean bian) {
        StringBuilder sb = new StringBuilder();
        for (Integer result : list) {
            sb.append(getGua(result, bian));
            sb.append("\n");
        }
        return sb.toString();
    }

    public static String getGua(int result, boolean bian) {
        switch (result) {
            case 24:
                return bian ? "——-" :"— —";
            case 28:
                return "——-";
            case 32:
                return "— —";
            case 36:
                return bian ? "— —" : "——-";
            default:break;
        }
        return "— —";
    }

    public static int getGua(int result) {
        switch (result) {
            case 6:
            case 24:
                return 0;
            case 7:
            case 28:
                return 1;
            case 8:
            case 32:
                return 0;
            case 9:
            case 36:
                return 1;
            default:break;
        }
        return 0;
    }

    public static int getBianGua(int result) {
        switch (result) {
            case 6:
            case 24:
                return 1;
            case 7:
            case 28:
                return 1;
            case 8:
            case 32:
                return 0;
            case 9:
            case 36:
                return 0;
            default:break;
        }
        return 0;
    }


    public static String getResultCaoString(int result) {
        switch (result) {
            case 6:
            case 24:
                return "老阴";
            case 28:
            case 7:
                return "少阳";
            case 8:
            case 32:
                return "少阴";
            case 9:
            case 36:
                return "老阳";
                default:break;
        }
        return "少阴";
    }

    public static int getResultCao() {
        Random random = new Random();
        int first;
        int second;
        int third;

        first = random.nextInt(48) + 1;
        if (first % 4 == 0) {
            first = 8;
        } else {
            first = 4;
        }
        second = random.nextInt(48 - first) + 1;
        if (second % 4 == 1 || second % 4 == 2) {
            second = 4;
        } else {
            second = 8;
        }
        third = random.nextInt(48 - first - second) + 1;
        if (third % 4 == 1 || third % 4 == 2) {
            third = 4;
        } else {
            third = 8;
        }
        return 48 - first - second - third;
    }

    public static List<GuaXiangItem> getGua(List<Integer> list, int type) {
        List<GuaXiangItem> guaList = new ArrayList<>();
        if (type == 0) {
            for (int i = list.size() - 1; i >= 0; i --) {
                guaList.add(new GuaXiangItem(list.get(i), false));
            }
        } else {
            for (int i = 0; i < list.size(); i ++) {
                guaList.add(new GuaXiangItem(list.get(i), type == 3));
            }
        }
        return guaList;
    }

    public static String getCode(List<Integer> list, boolean bian) {
        StringBuilder sb = new StringBuilder();
        for (Integer integer : list) {
            sb.append(bian ? getBianGua(integer) : getGua(integer));
        }
        return sb.toString();
    }

    public static int getResultQian() {
        Random random = new Random();
        int total = 0;
        for (int i = 0; i < 3; i ++) {
            total += random.nextInt(2) + 2;
        }
        return total;
    }
}
