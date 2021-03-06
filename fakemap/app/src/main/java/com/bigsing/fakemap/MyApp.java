package com.bigsing.fakemap;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

import com.tencent.bugly.Bugly;

/**
 * Created by sing on 2017/4/19.
 */

public class MyApp extends Application {
    public static Context mContext;
    //程序通用的配置文件
    private static SharedPreferences mSP;

    public static SharedPreferences getSharedPreferences() {
        return mSP;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        //7.0以及上，必须设置为MODE_PRIVATE，否则会出现奔溃，但此时XSharedPreferences读取不到内容
        if (Build.VERSION.SDK_INT >= 24) {
            mSP = getSharedPreferences(Constant.TAG, MODE_PRIVATE);
        } else {
            mSP = getSharedPreferences(Constant.TAG, MODE_WORLD_READABLE);
        }
        Bugly.init(mContext, "c733286b0d", false);
    }
}
