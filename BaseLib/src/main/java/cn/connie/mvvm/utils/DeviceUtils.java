package cn.connie.mvvm.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import com.google.gson.Gson;

import java.lang.reflect.Method;
import java.math.BigDecimal;

import cn.connie.mvvm.base.AppManager;
import cn.connie.mvvm.base.BaseApplication;

/**
 * Describe: 获取手机信息
 * Created by zdh on 2019-08-05.
 */
public class DeviceUtils {

    private static double mInch = 0;
    private static String mDeviceInfo = "";

    /**
     * 获取当前手机系统版本号
     *
     * @return 系统版本号
     */
    public static String getSystemVersion() {
        return Build.VERSION.RELEASE;
    }

    /**
     * 获取手机型号
     *
     * @return 手机型号
     */
    public static String getSystemModel() {
        return Build.MODEL;
    }

    /**
     * 获取手机厂商
     *
     * @return 手机厂商
     */
    public static String getDeviceBrand() {
        return Build.BRAND;
    }

    /**
     * 获取应用的ApplicationId
     *
     * @return
     */
    public static String getApplicationId() {
        try {
            String pkName = BaseApplication.getInstance().getPackageName();

            return pkName;
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * 获取屏幕的宽高
     */
    public static String getScreenWH() {
        Point point = new Point();
        WindowManager windowManager = (WindowManager) BaseApplication.getInstance().getSystemService(Context.WINDOW_SERVICE);
        //不含虚拟按键
//        windowManager.getDefaultDisplay().getSize(point);
        //包含虚拟按键
        windowManager.getDefaultDisplay().getRealSize(point);
        //屏幕宽度
        int height = point.y;
        //屏幕高度
        int width = point.x;
        return width + "," + height;
    }

    /**
     * 获取屏幕尺寸
     *
     * @param activity
     * @return
     */
    public static double getScreenInch(Activity activity) {
        if (mInch != 0.0d) {
            return mInch;
        }

        try {
            int realWidth = 0, realHeight = 0;
            Display display = activity.getWindowManager().getDefaultDisplay();
            DisplayMetrics metrics = new DisplayMetrics();
            display.getMetrics(metrics);
            if (Build.VERSION.SDK_INT >= 17) {
                Point size = new Point();
                display.getRealSize(size);
                realWidth = size.x;
                realHeight = size.y;
            } else if (Build.VERSION.SDK_INT < 17 && Build.VERSION.SDK_INT >= 14) {
                Method mGetRawH = Display.class.getMethod("getRawHeight");
                Method mGetRawW = Display.class.getMethod("getRawWidth");
                realWidth = (Integer) mGetRawW.invoke(display);
                realHeight = (Integer) mGetRawH.invoke(display);
            } else {
                realWidth = metrics.widthPixels;
                realHeight = metrics.heightPixels;
            }

            mInch = formatDouble(Math.sqrt((realWidth / metrics.xdpi) * (realWidth / metrics.xdpi) + (realHeight / metrics.ydpi) * (realHeight / metrics.ydpi)), 1);

        } catch (Exception e) {
            e.printStackTrace();
        }
        activity = null;
        return mInch;
    }

    /**
     * Double类型保留指定位数的小数，返回double类型（四舍五入）
     * newScale 为指定的位数
     */
    private static double formatDouble(double d, int newScale) {
        BigDecimal bd = new BigDecimal(d);
        return bd.setScale(newScale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 获取屏幕宽度
     *
     * @return
     */
    public static int getScreenWidth() {
        int width;
        WindowManager wm = (WindowManager) BaseApplication.getInstance().getSystemService(Context.WINDOW_SERVICE);
        width = wm.getDefaultDisplay().getWidth();
        return width;
    }

    /**
     * 获取屏幕高度
     *
     * @return
     */
    public static int getScreenHeight() {
        int height;
        WindowManager wm = (WindowManager) BaseApplication.getInstance().getSystemService(Context.WINDOW_SERVICE);
        height = wm.getDefaultDisplay().getHeight();

        return height;
    }

    /**
     * 获取版本号
     *
     * @return
     */
    public static int getVersion() {
        int versionCode = 0;
        try {
            versionCode = BaseApplication.getInstance().getPackageManager().getPackageInfo(BaseApplication.getInstance().getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionCode;
    }

    /**
     * 获取版本名称
     *
     * @return
     */
    public static String getVersionName() {
        String versionName = "1.0.0";
        try {
            versionName = BaseApplication.getInstance().getPackageManager().getPackageInfo(BaseApplication.getInstance().getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionName;
    }

    public static String getDeviceInfo() {
        if (TextUtils.isEmpty(mDeviceInfo)) {
            Activity activity = AppManager.getInstance().getCurrentActivity();
            if (activity != null) {
                DeviceInfoBean deviceInfoBean = new DeviceInfoBean();
                deviceInfoBean.setBrand(getDeviceBrand());
                deviceInfoBean.setModel(getSystemModel());
                deviceInfoBean.setOs_version(getSystemVersion());
                deviceInfoBean.setApp_version(getVersionName());
                deviceInfoBean.setApp_version_code(getVersion() + "");
                deviceInfoBean.setResolution(getScreenWH());
                deviceInfoBean.setScreen_size(getScreenInch(activity) + "");
                deviceInfoBean.setDevice_id(PhoneUtils.getUniqueId());//唯一标识
                deviceInfoBean.setPkg_name(getApplicationId());
                mDeviceInfo = new Gson().toJson(deviceInfoBean);
            }
        }

        return mDeviceInfo;
    }


    public static void openAppSetting() {
        String SETTINGS_ACTION =
                "android.settings.APPLICATION_DETAILS_SETTINGS";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.BASE) {
            Intent intent = new Intent()
                    .setAction(SETTINGS_ACTION)
                    .setData(Uri.fromParts("package",
                            BaseApplication.getInstance().getPackageName(), null));
            BaseApplication.getInstance().startActivity(intent);
            return;
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Intent intent = new Intent()
                    .setAction(SETTINGS_ACTION)
                    .setData(Uri.fromParts("package",
                            BaseApplication.getInstance().getPackageName(), null));
            BaseApplication.getInstance().startActivity(intent);
            return;
        }
    }

}