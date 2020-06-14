package com.duke.yinyangli.base;

import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.gyf.immersionbar.ImmersionBar;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity {

    private Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ImmersionBar.with(this).statusBarColor(android.R.color.white).statusBarDarkFont(true, 0).init();

        if (useEventBus()) {
            EventBus.getDefault().register(this);
        }
        setContentView(getLayoutId());
        if (requestButterKnife()) {
            unbinder = ButterKnife.bind(this);
        }
        initView();
        initData();
    }

    public void initData() {};
    public void initView() {};
    public abstract int getLayoutId();
    public boolean useEventBus() {
        return false;
    }
    public boolean requestButterKnife() {
        return false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unbinder != null && requestButterKnife()) {
            unbinder.unbind();
            unbinder = null;
        }
    }
}
