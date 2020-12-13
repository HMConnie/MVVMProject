package cn.connie.mvvm.base;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Created by hinge on 17/5/23.
 */

public class AppManager implements Application.ActivityLifecycleCallbacks {


    // I use four separate variables here. You can, of course, just use two and
    // increment/decrement them instead of using four and incrementing them all.
    private int resumed;
    private int paused;
    private int started;
    private int stopped;
    private final Stack<Activity> activityStack; //activity任务栈
    private static AppManager mInstance;

    public static AppManager getInstance() {
        if (mInstance == null) {
            synchronized (AppManager.class) {
                if (mInstance == null) {
                    mInstance = new AppManager();
                }
            }
        }
        return mInstance;
    }

    private AppManager() {
        this.activityStack = new Stack<>();
        this.resumed = 0;
        this.paused = 0;
        this.started = 0;
        this.stopped = 0;
    }


    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        activityStack.add(activity);
    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        activityStack.remove(activity);
    }

    @Override
    public void onActivityResumed(Activity activity) {
        ++resumed;
    }

    @Override
    public void onActivityPaused(Activity activity) {
        ++paused;
    }


    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
    }

    @Override
    public void onActivityStarted(Activity activity) {
        ++started;
    }

    @Override
    public void onActivityStopped(Activity activity) {
        ++stopped;
    }

    // If you want a static function you can use to check if your application is
    // foreground/background, you can use the following:


    public synchronized boolean isApplicationVisible() {
        return started > stopped;
    }

    public synchronized boolean isApplicationInForeground() {
        return resumed > paused;
    }

    public synchronized boolean isApplicationInBackground() {
        return started == stopped;
    }

    /**
     * 结束所有Activity
     */
    public synchronized void finishAllActivity() {
        for (int i = 0, size = activityStack.size(); i < size; i++) {
            Activity activity = activityStack.get(i);
            if (activity == null) {
                continue;
            }
            activity.finish();
        }
        activityStack.clear();
    }

    public synchronized void finish2MainActivity() {
        Iterator<Activity> iterator = activityStack.iterator();
        while (iterator.hasNext()) {
            Activity activity = iterator.next();
            if (activity == null) {
                continue;
            }
            if (TextUtils.equals("MainActivity", activity.getClass().getSimpleName())) {
                activity.finish();
                iterator.remove();
            }
        }
    }

    /**
     * @param needStatistic 是否需要统计
     */
    public synchronized void finish2MainActivity(Activity activity, boolean needStatistic) {
        if (activity == null) {
            return;
        }
        finish2MainActivity();
    }

    /**
     * 回到桌面
     *
     * @param activity
     */
    public synchronized void appBackHome(Activity activity) {
        Intent launcherIntent = new Intent(Intent.ACTION_MAIN);
        launcherIntent.addCategory(Intent.CATEGORY_HOME);
        activity.startActivity(launcherIntent);
    }

    /**
     * 关闭程序
     */
    public synchronized void appExit() {
        try {
            finishAllActivity();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ActivityManager activityMgr = (ActivityManager) BaseApplication.getInstance().getSystemService(Context.ACTIVITY_SERVICE);
            activityMgr.killBackgroundProcesses(BaseApplication.getInstance().getPackageName());
        }
    }

    public synchronized boolean hasMainActivity() {
        boolean hasMainActivity = false;
        for (int i = 0, size = activityStack.size(); i < size; i++) {
            Activity activity = activityStack.get(i);
            if (activity == null) {
                continue;
            }
            if (TextUtils.equals("MainActivity", activity.getClass().getSimpleName())) {
                hasMainActivity = true;
                break;
            }
        }
        return hasMainActivity;
    }

    public synchronized Activity fromActivity() {
        int index = activityStack.size() - 2;
        if (index >= 0 && activityStack.size() > index) {
            return activityStack.get(index);
        }
        return null;
    }

    public synchronized List<Activity> getActivityFromStack() {
        List<Activity> list = new ArrayList<>();
        int length = activityStack.size() - 1;
        if (length >= 0) {
            for (int i = 0; i < length; i++) {
                list.add(activityStack.get(i));
            }
        }
        return list;
    }

    public synchronized Activity getCurrentActivity() {
        int index = activityStack.size() - 1;
        if (index >= 0 && activityStack.size() > index) {
            return activityStack.get(index);
        }
        return null;
    }

    public synchronized Stack<Activity> getActivityStack() {
        return activityStack;
    }

}