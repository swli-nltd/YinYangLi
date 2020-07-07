package com.duke.yinyangli.activity;

import android.content.Context;
import android.content.Intent;

import com.duke.yinyangli.R;
import com.duke.yinyangli.base.BaseActivity;

public class SettingActivity extends BaseActivity {

    public static void start(Context context) {
        context.startActivity(new Intent(context, SettingActivity.class));
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_setting;
    }
}
