package com.duke.yinyangli.utils.core;

import android.widget.ImageView;

import com.duke.yinyangli.R;

public class ImageUtil {

    public static void setXingZuoImage(ImageView image, String xingzuo) {
        switch (xingzuo) {
            case "水瓶座":
                image.setImageResource(R.mipmap.xingzuo_shuiping);
                break;
            case "白羊座":
                image.setImageResource(R.mipmap.xingzuo_baiyang);
                break;
            case "金牛座":
                image.setImageResource(R.mipmap.xingzuo_jinniu);
                break;
            case "双子座":
                image.setImageResource(R.mipmap.xingzuo_shuangzi);
                break;
            case "巨蟹座":
                image.setImageResource(R.mipmap.xingzuo_juxie);
                break;
            case "狮子座":
                image.setImageResource(R.mipmap.xingzuo_shizi);
                break;
            case "处女座":
                image.setImageResource(R.mipmap.xingzuo_chunv);
                break;
            case "天秤座":
                image.setImageResource(R.mipmap.xingzuo_tiancheng);
                break;
            case "天蝎座":
                image.setImageResource(R.mipmap.xingzuo_tianxie);
                break;
            case "射手座":
                image.setImageResource(R.mipmap.xingzuo_sheshou);
                break;
            case "摩羯座":
                image.setImageResource(R.mipmap.xingzuo_mojie);
                break;
            case "双鱼座":
                image.setImageResource(R.mipmap.xingzuo_shuangyu);
                break;
            default:break;
        }
    }

    public static void setShuXiangImage(ImageView image, String shuxiang) {
        switch (shuxiang) {
            case "鼠":
                image.setImageResource(R.mipmap.shengxiao_shu);
                break;
            case "牛":
                image.setImageResource(R.mipmap.shengxiao_niu);
                break;
            case "虎":
                image.setImageResource(R.mipmap.shengxiao_hu);
                break;
            case "兔":
                image.setImageResource(R.mipmap.shengxiao_tu);
                break;
            case "龙":
                image.setImageResource(R.mipmap.shengxiao_long);
                break;
            case "蛇":
                image.setImageResource(R.mipmap.shengxiao_she);
                break;
            case "马":
                image.setImageResource(R.mipmap.shengxiao_ma);
                break;
            case "羊":
                image.setImageResource(R.mipmap.shengxiao_yang);
                break;
            case "猴":
                image.setImageResource(R.mipmap.shengxiao_hou);
                break;
            case "鸡":
                image.setImageResource(R.mipmap.shengxiao_ji);
                break;
            case "狗":
                image.setImageResource(R.mipmap.shengxiao_gou);
                break;
            case "猪":
                image.setImageResource(R.mipmap.shengxiao_zhu);
                break;
            default:break;
        }
    }
}
