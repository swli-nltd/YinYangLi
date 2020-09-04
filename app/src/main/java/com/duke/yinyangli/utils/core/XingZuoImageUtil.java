package com.duke.yinyangli.utils.core;

import android.widget.ImageView;

import com.duke.yinyangli.R;

public class XingZuoImageUtil {

    public static void setImage(ImageView image, String xingzuo) {
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
}
