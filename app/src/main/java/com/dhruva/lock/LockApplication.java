package com.dhruva.lock;

import com.balsikandar.crashreporter.CrashReporter;
import com.dhruva.lock.activities.lock.GestureUnlockActivity;
import com.dhruva.lock.base.BaseActivity;
import com.dhruva.lock.utils.SpUtil;

import org.litepal.LitePalApplication;

import java.util.ArrayList;
import java.util.List;



public class LockApplication extends LitePalApplication {

    private static LockApplication application;
    private static List<BaseActivity> activityList;

    public static LockApplication getInstance() {
        return application;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;

        //Crash reporter utility
        CrashReporter.initialize(this, getCacheDir().getPath());

        SpUtil.getInstance().init(application);
        activityList = new ArrayList<>();
    }

    public void doForCreate(BaseActivity activity) {
        activityList.add(activity);
    }

    public void doForFinish(BaseActivity activity) {
        activityList.remove(activity);
    }

    public void clearAllActivity() {
        try {
            for (BaseActivity activity : activityList) {
                if (activity != null && !clearAllWhiteList(activity))
                    activity.clear();
            }
            activityList.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean clearAllWhiteList(BaseActivity activity) {
        return activity instanceof GestureUnlockActivity;
    }
}
