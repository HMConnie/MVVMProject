package cn.connie.mvvm.cache;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import cn.connie.mvvm.base.BaseApplication;
import cn.connie.mvvm.utils.GsonUtil;
import cn.connie.mvvm.utils.MD5Util;
import cn.connie.mvvm.utils.MVVMConstants;


/**
 * Created by hinge on 17/10/17.
 */

public class NetCache {


    private NetCache() {

    }

    /**
     * 清除缓存数据
     */
    public synchronized static void clear() {
        SharedPreferences.Editor edit = getSharedPreferences().edit();
        edit.clear();
        edit.commit();
    }

    private static SharedPreferences getSharedPreferences() {
        return BaseApplication.getInstance().getSharedPreferences(MVVMConstants.CACHE_SP_FILE, Context.MODE_PRIVATE);
    }

    /**
     * 添加网络缓存数据
     */
    public synchronized static void addOrReplace(String key, String respResult) {
        if (TextUtils.isEmpty(key) || TextUtils.isEmpty(respResult)) {
            return;
        }
        SharedPreferences.Editor edit = getSharedPreferences().edit();
        edit.putString(MD5Util.md5(key), respResult);
        edit.commit();

    }

    /**
     * 获取网络缓存数据
     */
    public synchronized static String get(String key) {
        return getSharedPreferences().getString(MD5Util.md5(key), "");
    }

    /**
     * 获取网络缓存数据转化成bean
     */
    public synchronized static <T> T get(String key, Class<T> clazz) {
        return GsonUtil.fromJsontoBean(get(key), clazz);
    }

    public synchronized static void remove(String key) {
        SharedPreferences.Editor edit = getSharedPreferences().edit();
        edit.remove(key);
        edit.commit();
    }

    public synchronized static String getToken() {
        return getSharedPreferences().getString(MVVMConstants.TOKEN, "");
    }

    public synchronized static void saveToken(String token) {
        SharedPreferences.Editor edit = getSharedPreferences().edit();
        edit.putString(MVVMConstants.TOKEN, token);
        edit.commit();
    }

    public static void deleteToken() {
        SharedPreferences.Editor edit = getSharedPreferences().edit();
        edit.remove(MVVMConstants.TOKEN);
        edit.commit();
    }
}
