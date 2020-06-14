package com.duke.yinyangli.activity;

import com.duke.yinyangli.R;
import com.duke.yinyangli.adapter.MainInfoAdapter;
import com.duke.yinyangli.base.BaseActivity;
import com.duke.yinyangli.calendar.Lunar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.gyf.immersionbar.ImmersionBar;
import com.haibin.calendarview.group.GroupItemDecoration;
import com.haibin.calendarview.group.GroupRecyclerView;
import com.haibin.calendarview.library.Article;
import com.haibin.calendarview.library.ArticleAdapter;
import com.haibin.calendarview.library.Calendar;
import com.haibin.calendarview.library.CalendarLayout;
import com.haibin.calendarview.library.CalendarView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

import androidx.recyclerview.widget.LinearLayoutManager;
import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements
        CalendarView.OnCalendarSelectListener,
        CalendarView.OnYearChangeListener,
        View.OnClickListener {

    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.tv_month_day)
    TextView mTextMonthDay;
    @BindView(R.id.tv_year)
    TextView mTextYear;
    @BindView(R.id.tv_lunar)
    TextView mTextLunar;
    @BindView(R.id.tv_current_day)
    TextView mTextCurrentDay;
    @BindView(R.id.calendarView)
    CalendarView mCalendarView;
    @BindView(R.id.rl_tool)
    RelativeLayout mRelativeTool;
    @BindView(R.id.calendarLayout)
    CalendarLayout mCalendarLayout;
    @BindView(R.id.recyclerView)
    GroupRecyclerView mRecyclerView;

    private int mYear;
    private Lunar mCurrentLunar;
    private MainInfoAdapter mAdapter;

    public static void show(Context context) {
        context.startActivity(new Intent(context, MainActivity.class));
    }

    @Override
    public boolean requestButterKnife() {
        return true;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        super.initView();
        mTextMonthDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mCalendarLayout.isExpand()) {
                    mCalendarLayout.expand();
                    return;
                }
                mCalendarView.showYearSelectLayout(mYear);
                mTextLunar.setVisibility(View.GONE);
                mTextYear.setVisibility(View.GONE);
                mTextMonthDay.setText(String.valueOf(mYear));
            }
        });
        findViewById(R.id.fl_current).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCalendarView.scrollToCurrent();
                //mCalendarView.addSchemeDate(getSchemeCalendar(2019, 6, 1, 0xFF40db25, "假"));
//                int year = 2019;
//                int month = 6;
//                Map<String, Calendar> map = new HashMap<>();
//                map.put(getSchemeCalendar(year, month, 3, 0xFF40db25, "假").toString(),
//                        getSchemeCalendar(year, month, 3, 0xFF40db25, "假"));
//                map.put(getSchemeCalendar(year, month, 6, 0xFFe69138, "事").toString(),
//                        getSchemeCalendar(year, month, 6, 0xFFe69138, "事"));
//                map.put(getSchemeCalendar(year, month, 9, 0xFFdf1356, "议").toString(),
//                        getSchemeCalendar(year, month, 9, 0xFFdf1356, "议"));
//                map.put(getSchemeCalendar(year, month, 13, 0xFFedc56d, "记").toString(),
//                        getSchemeCalendar(year, month, 13, 0xFFedc56d, "记"));
//                mCalendarView.addSchemeDate(map);
            }
        });
        mCalendarView.setOnCalendarSelectListener(this);
        mCalendarView.setOnYearChangeListener(this);
        mTextYear.setText(String.valueOf(mCalendarView.getCurYear()));
        mYear = mCalendarView.getCurYear();
        mTextMonthDay.setText(mCalendarView.getCurMonth() + "月" + mCalendarView.getCurDay() + "日");
        mTextLunar.setText("今日");
        mTextCurrentDay.setText(String.valueOf(mCalendarView.getCurDay()));

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new GroupItemDecoration<String, Article>());
        mRecyclerView.setAdapter(mAdapter = new MainInfoAdapter(this));
    }

    @Override
    public void initData() {
        int year = mCalendarView.getCurYear();
        int month = mCalendarView.getCurMonth();
        int currentDay = mCalendarView.getCurDay();
        mCurrentLunar = Lunar.fromDate(mCalendarView.getSelectedCalendar().getDate());
        mAdapter.setLunar(mCurrentLunar);
        mRecyclerView.notifyDataSetChanged();

        String ji = mCurrentLunar.getDayTianShenLuck();

        Map<String, Calendar> map = new HashMap<>();
        map.put(getSchemeCalendar(year, month, currentDay, 0xFF40db25, ji).toString(),
                getSchemeCalendar(year, month, currentDay, 0xFF40db25, ji));
//        map.put(getSchemeCalendar(year, month, 6, 0xFFe69138, "事").toString(),
//                getSchemeCalendar(year, month, 6, 0xFFe69138, "事"));
//        map.put(getSchemeCalendar(year, month, 9, 0xFFdf1356, "议").toString(),
//                getSchemeCalendar(year, month, 9, 0xFFdf1356, "议"));
//        map.put(getSchemeCalendar(year, month, 13, 0xFFedc56d, "记").toString(),
//                getSchemeCalendar(year, month, 13, 0xFFedc56d, "记"));
//        map.put(getSchemeCalendar(year, month, 14, 0xFFedc56d, "记").toString(),
//                getSchemeCalendar(year, month, 14, 0xFFedc56d, "记"));
//        map.put(getSchemeCalendar(year, month, 15, 0xFFaacc44, "假").toString(),
//                getSchemeCalendar(year, month, 15, 0xFFaacc44, "假"));
//        map.put(getSchemeCalendar(year, month, 18, 0xFFbc13f0, "记").toString(),
//                getSchemeCalendar(year, month, 18, 0xFFbc13f0, "记"));
//        map.put(getSchemeCalendar(year, month, 25, 0xFF13acf0, "假").toString(),
//                getSchemeCalendar(year, month, 25, 0xFF13acf0, "假"));
//        map.put(getSchemeCalendar(year, month, 27, 0xFF13acf0, "多").toString(),
//                getSchemeCalendar(year, month, 27, 0xFF13acf0, "多"));
        //此方法在巨大的数据量上不影响遍历性能，推荐使用
        mCalendarView.setSchemeDate(map);
    }

    private Calendar getSchemeCalendar(int year, int month, int day, int color, String text) {
        Calendar calendar = new Calendar();
        calendar.setYear(year);
        calendar.setMonth(month);
        calendar.setDay(day);
        calendar.setSchemeColor(color);//如果单独标记颜色、则会使用这个颜色
        calendar.setScheme(text);
        calendar.addScheme(new Calendar.Scheme());
        calendar.addScheme(0xFF008800, "假");
        calendar.addScheme(0xFF008800, "节");
        return calendar;
    }

    @Override
    @OnClick(R.id.fab)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fab:
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                break;
            default:break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCalendarOutOfRange(Calendar calendar) {

    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onCalendarSelect(Calendar calendar, boolean isClick) {
        mTextLunar.setVisibility(View.VISIBLE);
        mTextYear.setVisibility(View.VISIBLE);
        mTextMonthDay.setText(calendar.getMonth() + "月" + calendar.getDay() + "日");
        mTextYear.setText(String.valueOf(calendar.getYear()));
        mTextLunar.setText(calendar.getLunar());
        mYear = calendar.getYear();

        Log.e("onDateSelected", "  -- " + calendar.getYear() +
                "  --  " + calendar.getMonth() +
                "  -- " + calendar.getDay() +
                "  --  " + isClick + "  --   " + calendar.getScheme());
    }

    @Override
    public void onYearChange(int year) {
        mTextMonthDay.setText(String.valueOf(year));
    }

}
