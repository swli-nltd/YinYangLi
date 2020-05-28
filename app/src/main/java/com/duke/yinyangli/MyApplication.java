package com.duke.yinyangli;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.bytedance.boost_multidex.BoostMultiDex;
import com.bytedance.boost_multidex.Result;

public class MyApplication extends Application {

    private static MyApplication sInstance;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);

        Result result = BoostMultiDex.install(this);
        if (result != null && result.fatalThrowable != null) {
            Log.e("BMD", "exception occored " + result.fatalThrowable);
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
    }

    public static Context getInstance() {
        if (sInstance != null) {
            return sInstance;
        } else {
            return null;
        }
    }

    public static Context getContext() {
        if (sInstance != null) {
            return sInstance.getApplicationContext();
        } else {
            return null;
        }
    }
}
