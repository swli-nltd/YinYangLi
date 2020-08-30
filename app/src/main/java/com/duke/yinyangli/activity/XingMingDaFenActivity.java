package com.duke.yinyangli.activity;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.duke.yinyangli.R;
import com.duke.yinyangli.adapter.AllResultAdapter;
import com.duke.yinyangli.base.BaseActivity;
import com.duke.yinyangli.constants.Constants;
import com.duke.yinyangli.dialog.SimpleDialog;
import com.duke.yinyangli.utils.SoftKeyBoardListener;
import com.duke.yinyangli.utils.ToastUtil;
import com.haibin.calendarview.library.Article;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;

public class XingMingDaFenActivity extends BaseActivity {

    @BindView(R.id.edit_name)
    EditText editName;
    @BindView(R.id.submit)
    View submit;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private AllResultAdapter mAdapter;
    private Article mAriticle;

    public static void start(Context context, Article article) {
        context.startActivity(new Intent(context, XingMingDaFenActivity.class)
                .putExtra(Constants.INTENT_KEY.KEY_MODEL, article));
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_xingmingdafen;
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
            }
        });

        editName.requestFocus();

    }


    @OnClick(R.id.submit)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.submit:
                if (!TextUtils.isEmpty(editName.getText())
                        && !TextUtils.isEmpty(editName.getText().toString())
                        && !TextUtils.isEmpty(editName.getText().toString().trim())) {
                    String name = editName.getText().toString();
                    showProgressDialog();
                    //todo
                } else {
                    ToastUtil.show(this, "请输入您的名字");
                }
                break;
            default:break;
        }
    }
}
