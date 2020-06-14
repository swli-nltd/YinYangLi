package com.duke.yinyangli.base;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.duke.yinyangli.R;
import com.gyf.immersionbar.ImmersionBar;

import org.greenrobot.eventbus.EventBus;

import java.lang.ref.WeakReference;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity {

    private Unbinder unbinder;
    public TextView title;
    public ImageView left;
    public ImageView right;
    public MyHandler mHandler;

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
    public void initView() {
        title = findViewById(R.id.title);
        left = findViewById(R.id.left);
        if (left != null) {
            left.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onBackPressed();
                }
            });
        }
    };
    public abstract int getLayoutId();
    public boolean useEventBus() {
        return false;
    }
    public boolean requestButterKnife() {
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unbinder != null && requestButterKnife()) {
            unbinder.unbind();
            unbinder = null;
        }
    }

    protected static final class MyHandler extends Handler {

        private WeakReference<BaseActivity> weakReference;

        public MyHandler(BaseActivity activity) {
            this.weakReference = new WeakReference<BaseActivity>(activity);
        }

        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().onHandleMessage(msg);
            }
        }

    }

    public void onHandleMessage(Message msg) {

    }
}
