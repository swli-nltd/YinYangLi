package com.duke.yinyangli.activity;

import android.content.Intent;

import com.duke.yinyangli.R;
import com.duke.yinyangli.base.BaseActivity;

public class StartActivity extends BaseActivity {

    @Override
    public int getLayoutId() {
        return R.layout.activity_start;
    }

    @Override
    public void initView() {
        super.initView();
        mHandler = new MyHandler(this);
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        MainActivity.show(StartActivity.this);
                    }
                });
            }
        }, 0);
    }
}
