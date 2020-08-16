package com.duke.yinyangli.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.duke.yinyangli.R;
import com.duke.yinyangli.bean.ChengGuItem;
import com.duke.yinyangli.bean.JieGuaItem;
import com.duke.yinyangli.bean.database.Rgnm;
import com.duke.yinyangli.bean.database.Rysmn;
import com.duke.yinyangli.bean.database.ShuXiang;
import com.duke.yinyangli.calendar.Lunar;
import com.duke.yinyangli.calendar.Solar;
import com.haibin.calendarview.library.Article;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class AllResultAdapter extends RecyclerView.Adapter<AllResultAdapter.ViewHolder> {

    private Context mContext;
    private List<Article> mData;

    public AllResultAdapter(Context context) {
        mContext = context;
    }


    public void setResult(Rgnm rgnm, Rysmn month, Rysmn day, Rysmn time, ShuXiang shuXiang, Lunar lunar, Solar solar) {
        if (mData == null) {
            mData = new ArrayList<>();
        } else {
            mData.clear();
        }
        List<String> birthdays = new ArrayList<>();
        birthdays.add("公历（阳历）：" + solar.getYear() + "年 " + solar.getMonth() + "月 " + solar.getDay() + "日 " + solar.getHour() + "时");
        birthdays.add("农历（阴历）：" + lunar.getYearInChinese() + "年 " + lunar.getMonthInChinese() + "月 " + lunar.getDayInChinese() + " " + lunar.getTimeZhi2());
        mData.add(Article.create("出生日期：", birthdays, 0));
        mData.add(Article.create("生肖：" + lunar.getYearShengXiao(), "生肖个性" + shuXiang.getContent(), 0));
        mData.add(Article.create("八字", getStringFromList(lunar.getBaZi()), 0));
        mData.add(Article.create("五行", getStringFromList(lunar.getBaZiWuXing()), 0));
        mData.add(Article.create("纳音", getStringFromList(lunar.getBaZiNaYin()), 0));
        mData.add(Article.create("十二值星", lunar.getZhiXing(), 0));
        List<String> shishen = new ArrayList<>();
        shishen.add("干：" + lunar.getBaZiShiShenGan());
        shishen.add("支：" + lunar.getBaZiShiShenZhi());
        mData.add(Article.create("十神", shishen, 0));
        mData.add(Article.create("四宫", lunar.getGong(), 0));
        mData.add(Article.create("七政", lunar.getZheng(), 0));
        mData.add(Article.create("四神兽", lunar.getShou(), 0));
        mData.add(Article.create("日干心性", rgnm.getRgxx(), 0));
        mData.add(Article.create("日干支层次", rgnm.getRgcz(), 0));
        mData.add(Article.create("日干支分析", rgnm.getRgzfx(), 0));
        List<String> mingli = new ArrayList<>();
        mingli.add(lunar.getMonthInChinese() + "生：" + month.getMingmi());
        mingli.add(lunar.getDayInChinese() + "生：" + day.getMingmi());
        mingli.add(lunar.getTimeZhi2() + "生：" + time.getMingmi());
        mData.add(Article.create("月日时命理", rgnm.getRgzfx(), 0));
        mData.add(Article.create("性格分析", rgnm.getXgfx(), 0));
        mData.add(Article.create("爱情分析", rgnm.getAqfx(), 0));
        mData.add(Article.create("事业分析", rgnm.getSyfx(), 0));
        mData.add(Article.create("财运分析", rgnm.getCyfx(), 0));
        mData.add(Article.create("健康分析", rgnm.getJkfx(), 0));

        notifyDataSetChanged();
    }

    private String getStringFromList(List<String> list) {
        StringBuilder sb = new StringBuilder();
        if (list != null && !list.isEmpty()) {
            for (String item : list) {
                sb.append(item);
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public void setResult(JieGuaItem item) {
        if (mData == null) {
            mData = new ArrayList<>();
        } else {
            mData.clear();
        }
        mData.add(Article.create("解卦：" + item.getLevel() + " " + item.getDescription()
                + " " + item.getSecondName(), item.getJiegua(), 0));
        mData.add(Article.create("周易卦爻辞原文", item.getYuanwen(), 0));
        mData.add(Article.create("周易卦爻辞解文", item.getJiewen(), 0));
        mData.add(Article.create("卦爻辞注解", item.getZhujie(), 0));
        mData.add(Article.create("卦爻卦辞诗", item.getGuacishi(), 0));
        notifyDataSetChanged();
    }

    public void setResult(Calendar calendar, int[] result, ChengGuItem chengGuItem) {
        if (mData == null) {
            mData = new ArrayList<>();
        } else {
            mData.clear();
        }
        Lunar lunar = Lunar.fromDate(calendar.getTime());
        mData.add(Article.create("出生时间", lunar.getYearInChinese()
                + " " + lunar.getMonthInChinese()
                + " " + lunar.getDayInChinese()
                + " " + lunar.getTimeZhi() + "时", 0));
        mData.add(Article.create("骨重", "你的命有" + result[0] + "两" + result[1]
                + "钱\n\n", 0));
        mData.add(Article.create("称骨歌", chengGuItem.getChengguge(), 0));
        if (!TextUtils.isEmpty(chengGuItem.getZhujie())) {
            mData.add(Article.create("注解", chengGuItem.getZhujie(), 0));
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_list_all_result, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.updateView(mContext, position, mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData != null ? mData.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView title, content;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_title);
            content = itemView.findViewById(R.id.tv_content);
        }

        public void updateView(Context context, int position, Article article) {
            title.setText(article.getTitle());
            content.setText(article.getContent());
        }
    }
}
