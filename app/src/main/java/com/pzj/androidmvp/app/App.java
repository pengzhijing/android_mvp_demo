package com.pzj.androidmvp.app;

import android.app.Application;

import com.pzj.androidmvp.util.ActivityUtil;
import com.pzj.androidmvp.util.LogUtil;
import com.pzj.androidmvp.util.XUtil;

/**
 * Description : App
 *
 * @author JeffPeng
 * @date 2020/2/8
 */


public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化
        XUtil.initialize(this);
        //设置打印开关
        LogUtil.setIsLog(true);
        //注册Activity生命周期
        registerActivityLifecycleCallbacks(ActivityUtil.getActivityLifecycleCallbacks());
    }

}
