package com.duke.yinyangli.activity;

import android.content.Intent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.duke.yinyangli.R;
import com.duke.yinyangli.base.BaseActivity;

import butterknife.BindView;

public class StartActivity extends BaseActivity {

    private static final long DURATION_DELAY = 2000;
    @BindView(R.id.logo)
    ImageView logo;
    @BindView(R.id.slogen)
    TextView slogen;

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
        }, DURATION_DELAY);
        Animation operatingAnim = AnimationUtils.loadAnimation(this, R.anim.rotate);

        LinearInterpolator lin = new LinearInterpolator();
        operatingAnim.setInterpolator(lin);
        logo.startAnimation(operatingAnim);
//        YoYo.with(Techniques.RotateIn).duration(DURATION_DELAY / 2).pivotX(50).pivotY(50).repeatMode(1).playOn(logo);
        YoYo.with(Techniques.Landing).duration(DURATION_DELAY / 2).repeatMode(-1).playOn(slogen);
    }
}
