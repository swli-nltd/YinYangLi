package com.duke.yinyangli.utils;

import com.duke.yinyangli.bean.JieGuaItem;

import java.util.HashMap;

public class JieGuaUtils {

    private JieGuaUtils mInstance;
    private HashMap<String, JieGuaItem> mMaps;

    public JieGuaUtils getInstance() {
        if (mInstance == null) {
            mInstance = new JieGuaUtils();
        }
        return mInstance;
    }

    public void init() {
        if (mInstance == null) {
            getInstance();
        }
        mMaps = new HashMap<>();
        mMaps.put("111111", new JieGuaItem(0x111111, "乾", "乾为天", "上上卦", "刚健中正"));
        mMaps.put("000000", new JieGuaItem(0x000000, "坤", "坤为地", "上上卦", "柔顺伸展"));
        mMaps.put("010001", new JieGuaItem(0x010001, "屯", "水雷屯", "下下卦", "起始维艰"));
        mMaps.put("100010", new JieGuaItem(0x100010, "蒙", "山水蒙", "中下卦", "启蒙奋发"));
        mMaps.put("010111", new JieGuaItem(0x010111, "需", "水天需", "中上卦", "守正待机"));
        mMaps.put("111010", new JieGuaItem(0x111010, "讼", "天水讼", "中下卦", "慎争戒讼"));
        mMaps.put("000010", new JieGuaItem(0x000010, "师", "地水师", "中上卦", "行险而顺"));
        mMaps.put("010000", new JieGuaItem(0x010000, "比", "水地比", "上上卦", "诚信团结"));
        mMaps.put("110111", new JieGuaItem(0x110111, "小畜", "风天小畜", "下下卦", "蓄养待进"));
        mMaps.put("111011", new JieGuaItem(0x111011, "履", "天泽履", "中上卦", "脚踏实地"));
        mMaps.put("000111", new JieGuaItem(0x000111, "泰", "地天泰", "中中卦", "应时而变"));
        mMaps.put("111000", new JieGuaItem(0x111000, "否", "天地否", "中中卦", "不交不通"));
        mMaps.put("111101", new JieGuaItem(0x111101, "同人", "天火同人", "中上卦", "上下和同"));
        mMaps.put("101111", new JieGuaItem(0x101111, "大有", "天火大有", "上上卦", "顺天依时"));
        mMaps.put("000100", new JieGuaItem(0x000100, "谦", "地山谦", "中中卦", "内高外低"));
        mMaps.put("001000", new JieGuaItem(0x001000, "豫", "雷地豫", "中中卦", "顺时依势"));
        mMaps.put("011001", new JieGuaItem(0x011001, "随", "泽雷随", "中中卦", "随时变通"));
        mMaps.put("100110", new JieGuaItem(0x100110, "蛊", "山风蛊", "中中卦", "振疲起衰"));
        mMaps.put("000011", new JieGuaItem(0x000011, "临", "地泽临", "中上卦", "教民保民"));
        mMaps.put("110000", new JieGuaItem(0x110000, "观", "风地观", "中上卦", "观下瞻上"));
        mMaps.put("101001", new JieGuaItem(0x101001, "噬嗑", "火雷噬嗑", "上上卦", "刚柔相济"));
        mMaps.put("100101", new JieGuaItem(0x100101, "贲", "山火贲", "中上卦", "饰外扬质"));
        mMaps.put("100000", new JieGuaItem(0x100000, "剥", "山地剥", "中下卦", "顺势而止"));
        mMaps.put("000001", new JieGuaItem(0x000001, "复", "地雷复", "中中卦", "寓动于顺"));
        mMaps.put("111001", new JieGuaItem(0x111001, "无妄", "天雷无妄", "下下卦", "无妄而得"));
        mMaps.put("100111", new JieGuaItem(0x100111, "大畜", "山天大畜", "中上卦", " 止而不止"));
        mMaps.put("100001", new JieGuaItem(0x100001, "颐", "山雷颐", "上上卦", "纯正以养"));
        mMaps.put("011110", new JieGuaItem(0x011110, "大过", "泽风大过", "中下卦", "十分行动"));
        mMaps.put("010010", new JieGuaItem(0x010010, "坎", "坎为水", "下下卦", "行险用险"));
        mMaps.put("101101", new JieGuaItem(0x101101, "离", "离为火", "中上卦", "附和依托"));
        mMaps.put("011100", new JieGuaItem(0x011100, "咸", "泽山咸", "中上卦", "相互感应"));
        mMaps.put("001110", new JieGuaItem(0x001110, "恒", "雷凤恒", "中上卦", "恒心有成"));
        mMaps.put("111100", new JieGuaItem(0x111100, "遁", "天山遁", "下下卦", "遁世救世"));
        mMaps.put("001111", new JieGuaItem(0x001111, "大壮", "雷天大壮", "中上卦", "壮勿妄动"));
        mMaps.put("101000", new JieGuaItem(0x101000, "晋", "火地晋", "中上卦", "求进发展"));
        mMaps.put("000101", new JieGuaItem(0x000101, "明夷", "地火明夷", "中下卦", "晦而转明"));
        mMaps.put("110101", new JieGuaItem(0x110101, "家人", "风火家人", "下下卦", "诚威治业"));
        mMaps.put("101011", new JieGuaItem(0x101011, "睽", "火泽睽", "下下卦", "异中求同"));
        mMaps.put("010100", new JieGuaItem(0x010100, "蹇", "水山蹇", "下下卦", "险阻在前"));
        mMaps.put("001010", new JieGuaItem(0x001010, "解", "雷水解", "中上卦", "柔道致治"));
        mMaps.put("100011", new JieGuaItem(0x100011, "损", "山泽损", "下下卦", "损益制衡"));
        mMaps.put("110001", new JieGuaItem(0x110001, "益", "风雷益", "上上卦", "损上益下"));
        mMaps.put("011111", new JieGuaItem(0x011111, "夬", "泽天夬", "上上卦", "决而能和"));
        mMaps.put("111110", new JieGuaItem(0x111110, "姤", "天风姤", "上卦", "天下有风"));
        mMaps.put("011000", new JieGuaItem(0x011000, "萃", "泽地萃", "中上卦", "荟萃聚集"));
        mMaps.put("000110", new JieGuaItem(0x000110, "升", "地风升", "上上卦", "柔顺谦虚"));
        mMaps.put("011010", new JieGuaItem(0x011010, "困", "泽水困", "中上卦", "困境求通"));
        mMaps.put("010110", new JieGuaItem(0x010110, "井", "水风井", "上上卦", "求贤若渴"));
        mMaps.put("011101", new JieGuaItem(0x011101, "革", "泽火革", "上上卦", "顺天应人"));
        mMaps.put("101110", new JieGuaItem(0x101110, "鼎", "火风鼎", "中下卦", "稳重图变"));
        mMaps.put("001001", new JieGuaItem(0x001001, "震", "震为雷", "中上卦", "临危不乱"));
        mMaps.put("100100", new JieGuaItem(0x100100, "艮", "艮为山", "中下卦", "动静适时"));
        mMaps.put("110100", new JieGuaItem(0x110100, "渐", "风山渐", "上上卦", "渐进蓄德"));
        mMaps.put("001011", new JieGuaItem(0x001011, "归妹", "雷泽归妹", "下下卦", "立家兴业"));
        mMaps.put("001101", new JieGuaItem(0x001101, "丰", "雷火丰", "上上卦", "日中则斜"));
        mMaps.put("101100", new JieGuaItem(0x101100, "旅", "火山旅", "下下卦", "依义顺时"));
        mMaps.put("110110", new JieGuaItem(0x110110, "巽", "巽为风", "中上卦", "谦逊受益"));
        mMaps.put("011011", new JieGuaItem(0x011011, "兑", "兑为泽", "上上卦", "刚内柔外"));
        mMaps.put("110010", new JieGuaItem(0x110010, "涣", "风水涣", "下下卦", "拯救涣散"));
        mMaps.put("010011", new JieGuaItem(0x010011, "节", "水泽节", "上上卦", "万物有节"));
        mMaps.put("110011", new JieGuaItem(0x110011, "中孚", "风泽中孚", "下下卦", "诚信立身"));
        mMaps.put("001100", new JieGuaItem(0x001100, "小过", "雷山小过", "中上卦", "行动有度"));
        mMaps.put("010101", new JieGuaItem(0x010101, "既济", "水火既济", "中上卦", "盛极将衰"));
        mMaps.put("101010", new JieGuaItem(0x101010, "未济", "火水未济", "中下卦", "事业未竟"));
    }
}
