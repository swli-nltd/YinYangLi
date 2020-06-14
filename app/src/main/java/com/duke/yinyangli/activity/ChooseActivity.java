package com.duke.yinyangli.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.duke.yinyangli.R;
import com.duke.yinyangli.adapter.ChooseAdapter;
import com.duke.yinyangli.base.BaseActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

public class ChooseActivity extends BaseActivity {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    public static void start(Context context) {
        context.startActivity(new Intent(context, ChooseActivity.class));
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_choose;
    }

    @Override
    public void initView() {
        super.initView();
        title.setText(R.string.select);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ChooseAdapter(this));
    }

}
