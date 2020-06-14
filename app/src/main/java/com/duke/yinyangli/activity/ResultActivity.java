package com.duke.yinyangli.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.widget.ImageView;
import android.widget.TextView;

import com.duke.yinyangli.R;
import com.duke.yinyangli.base.BaseActivity;
import com.duke.yinyangli.constants.Constants;
import com.duke.yinyangli.utils.ZhanBuUtils;
import com.haibin.calendarview.library.Article;
import com.haibin.calendarview.library.LunarUtil;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ResultActivity extends BaseActivity {

    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.result)
    TextView resultView;
    private int mCaoCount;

    public static void start(Context context, Article article) {
        context.startActivity(new Intent(context, ResultActivity.class)
                .putExtra(Constants.INTENT_KEY.KEY_MODEL, article));
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_result;
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
                default:break;
        }
    }

    private void getResultCao() {
        mCaoCount = 0;
        int result = ZhanBuUtils.getResultCao();
        resultView.setText("卦象\n\n" + result + ":" + ZhanBuUtils.getResultCaoString(result));
        mHandler.sendEmptyMessageDelayed(0, 400);
    }

    @Override
    public void onHandleMessage(Message msg) {
        super.onHandleMessage(msg);
        mCaoCount ++;
        if (mCaoCount >= 6) {
            mHandler.removeMessages(0);
            String origin = resultView.getText().toString();
            resultView.setText(origin + "\n\n" + "解卦：");
        } else {
            int result = ZhanBuUtils.getResultCao();
            String origin = resultView.getText().toString();
            resultView.setText(origin + "\n" + result + ":" + ZhanBuUtils.getResultCaoString(result));
            mHandler.sendEmptyMessageDelayed(0, 400);
        }
    }
}
