package com.duke.yinyangli.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.duke.yinyangli.R;
import com.duke.yinyangli.adapter.AllResultAdapter;
import com.duke.yinyangli.base.BaseActivity;
import com.duke.yinyangli.constants.Constants;
import com.duke.yinyangli.dialog.SimpleDialog;
import com.haibin.calendarview.library.Article;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

public class XingZuoPeiDuiActivity extends BaseActivity {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private AllResultAdapter mAdapter;
    private Article mAriticle;

    @Override
    public int getLayoutId() {
        return R.layout.activity_xingzuopeidui;
    }

    public static void start(Context context, Article article) {
        context.startActivity(new Intent(context, XingZuoPeiDuiActivity.class)
                .putExtra(Constants.INTENT_KEY.KEY_MODEL, article));
    }

    @Override
    public boolean requestButterKnife() {
        return true;
    }

    @Override
    public void initView() {
        super.initView();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mAdapter = new AllResultAdapter(this));
    }

    @Override
    public void initData() {
        super.initData();
        mAriticle = (Article) getIntent().getSerializableExtra(Constants.INTENT_KEY.KEY_MODEL);
        title.setText(mAriticle.getTitle());

        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SimpleDialog.init(XingZuoPeiDuiActivity.this, mAriticle.getTitle()
                        , getString(R.string.tip_xingmingpingfen), null)
                        .showCancel(false)
                        .setConfirmText(R.string.known)
                        .setConfirmTextColor(R.color.blue_2288BB)
                        .showDialog();
            }
        });

    }
}
