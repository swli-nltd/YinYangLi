package com.duke.yinyangli.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.widget.ImageView;
import android.widget.TextView;

import com.duke.yinyangli.R;
import com.duke.yinyangli.adapter.GuaXiangAdapter;
import com.duke.yinyangli.base.BaseActivity;
import com.duke.yinyangli.constants.Constants;
import com.duke.yinyangli.utils.ZhanBuUtils;
import com.haibin.calendarview.library.Article;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ResultActivity extends BaseActivity {

    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.result_origin)
    TextView resultView;
    @BindView(R.id.result_master)
    TextView resultMaster;
    @BindView(R.id.result_changed)
    TextView resultChanged;
    @BindView(R.id.result_origin_list)
    RecyclerView resultOriginList;
    @BindView(R.id.result_master_list)
    RecyclerView resultMasterList;
    @BindView(R.id.result_changed_list)
    RecyclerView resultChangedList;

    private int mCaoCount;
    private List<Integer> list;
    private GuaXiangAdapter mOriginAdapter;
    private GuaXiangAdapter mMasterAdapter;
    private GuaXiangAdapter mChangedAdapter;

    public static void start(Context context, Article article) {
        context.startActivity(new Intent(context, ResultActivity.class)
                .putExtra(Constants.INTENT_KEY.KEY_MODEL, article));
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_result;
    }

    @Override
    public void initView() {
        super.initView();
        resultOriginList.setLayoutManager(new LinearLayoutManager(this));
        resultOriginList.setAdapter(mOriginAdapter = new GuaXiangAdapter(this, true));
        resultMasterList.setLayoutManager(new LinearLayoutManager(this));
        resultMasterList.setAdapter(mMasterAdapter = new GuaXiangAdapter(this, false));
        resultChangedList.setLayoutManager(new LinearLayoutManager(this));
        resultChangedList.setAdapter(mChangedAdapter = new GuaXiangAdapter(this, false));
    }

    @Override
    public void initData() {
        super.initData();
        mHandler = new MyHandler(this);
        Article article = (Article) getIntent().getSerializableExtra(Constants.INTENT_KEY.KEY_MODEL);
        title.setText(article.getTitle());

        image.setImageResource(R.mipmap.zhanbushicao);
        setResult(article);
    }

    private void setResult(Article article) {
        switch (article.getId()) {
            case Constants.TYPE.TYPE_CAO:
                getResultCao();
                break;
            default:
                break;
        }
    }

    private void getResultCao() {
        mCaoCount = 0;
        if (list == null) {
            list = new ArrayList<>();
        } else {
            list.clear();
        }
        int result = ZhanBuUtils.getResultCao();
        list.add(result);
        mOriginAdapter.refreshData(ZhanBuUtils.getGua(list, 0));
        mHandler.sendEmptyMessageDelayed(0, 400);
    }

    @Override
    public void onHandleMessage(Message msg) {
        super.onHandleMessage(msg);
        mCaoCount++;
        if (mCaoCount >= 6) {
            mHandler.removeMessages(0);
            Collections.reverse(list);

            mOriginAdapter.refreshData(ZhanBuUtils.getGua(list, 1));
            mMasterAdapter.refreshData(ZhanBuUtils.getGua(list, 2));
            mChangedAdapter.refreshData(ZhanBuUtils.getGua(list, 3));
        } else {
            int result = ZhanBuUtils.getResultCao();
            list.add(result);
            mOriginAdapter.refreshData(ZhanBuUtils.getGua(list, 0));
            mHandler.sendEmptyMessageDelayed(0, 400);
        }
    }

}
