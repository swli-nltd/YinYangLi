package com.duke.yinyangli.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import com.duke.yinyangli.R;
import com.duke.yinyangli.view.MyProgressBar;

public class LoadingDialog extends Dialog {

    private MyProgressBar myProgressBar;

    private Context mContext;

    public LoadingDialog(Context context) {
        super(context);
        mContext = context;
        init(context);
    }

    public LoadingDialog(Context context, int theme) {
        super(context, theme);
        mContext = context;
        init(context);
    }

    private void init(Context context) {
        setContentView(R.layout.comm_progress_layout);
        myProgressBar = (MyProgressBar) findViewById(R.id.progress);
    }

    @Override
    public void show() {
        if (!((Activity) mContext).isFinishing()) {
            myProgressBar.show();
            super.show();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        myProgressBar.stop();
    }

    @Override
    public void dismiss() {
        myProgressBar.stop();
        super.dismiss();
    }
}