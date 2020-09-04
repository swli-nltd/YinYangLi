package com.duke.yinyangli.activity;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.duke.yinyangli.MyApplication;
import com.duke.yinyangli.R;
import com.duke.yinyangli.adapter.AllResultAdapter;
import com.duke.yinyangli.base.BaseActivity;
import com.duke.yinyangli.bean.database.Astro;
import com.duke.yinyangli.bean.database.AstroDao;
import com.duke.yinyangli.bean.database.DaoSession;
import com.duke.yinyangli.bean.database.XingZuo;
import com.duke.yinyangli.bean.database.XingZuoDao;
import com.duke.yinyangli.bean.database.XingZuoLove;
import com.duke.yinyangli.bean.database.XingZuoLoveDao;
import com.duke.yinyangli.constants.Constants;
import com.duke.yinyangli.dialog.SimpleDialog;
import com.duke.yinyangli.utils.ThreadHelper;
import com.duke.yinyangli.utils.ToastUtil;
import com.duke.yinyangli.utils.core.XingZuoImageUtil;
import com.haibin.calendarview.library.Article;

import org.angmarch.views.NiceSpinner;
import org.angmarch.views.OnSpinnerItemSelectedListener;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;

public class XingZuoPeiDuiActivity extends BaseActivity {

    @BindView(R.id.spinner_first)
    NiceSpinner mSpinner1;
    @BindView(R.id.spinner_second)
    NiceSpinner mSpinner2;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.image_left)
    ImageView mLeftImage;
    @BindView(R.id.image_right)
    ImageView mRightImage;
    @BindView(R.id.submit)
    View mSubmit;

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
                        , getString(R.string.tip_xingzuopeidui), null)
                        .showCancel(false)
                        .setConfirmText(R.string.known)
                        .setConfirmTextColor(R.color.blue_2288BB)
                        .showDialog();
            }
        });
    }

    @OnClick(R.id.submit)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.submit:
                String xingzuoNv = (String) mSpinner1.getSelectedItem();
                String xingzuoNan = (String) mSpinner2.getSelectedItem();
                if (TextUtils.isEmpty(xingzuoNv)) {
                    ToastUtil.show(this, "请选择您的星座");
                }
                if (TextUtils.isEmpty(xingzuoNan)) {
                    ToastUtil.show(this, "请选择另一位的星座");
                }
                showProgressDialog();
                ThreadHelper.INST.execute(new Runnable() {
                    @Override
                    public void run() {
                        DaoSession daoSession = MyApplication.getInstance().getDao();
                        XingZuoLove xingZuoLove = daoSession.getXingZuoLoveDao().queryBuilder()
                                .where(XingZuoLoveDao.Properties.Xingzuo1.eq(xingzuoNv)
                                        , XingZuoLoveDao.Properties.Xingzuo2.eq(xingzuoNan)).unique();

                        List<Article> articles = new ArrayList<>();
                        articles.add(Article.create(xingZuoLove.getTitle(), xingZuoLove.getContent1(), ""));
                        articles.add(Article.create(xingZuoLove.getContent2(), "", ""));

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                mAdapter.setResult(articles);
                                mSpinner1.setEnabled(false);
                                mSpinner2.setEnabled(false);
                                mSubmit.setVisibility(View.GONE);
                                XingZuoImageUtil.setImage(mLeftImage, xingzuoNv);
                                XingZuoImageUtil.setImage(mRightImage, xingzuoNan);
                                dismissProgressDialog();
                            }
                        });
                    }
                });
                break;
                default:break;
        }
    }

}
