package cn.connie.mvvm.utils;


import cn.connie.mvvm.BuildConfig;

/**
 * the logger
 *
 * @author MaTianyu
 *         2014-1-1下午4:05:39
 */
public final class LogUtil {

    /**
     * isPrint: print switch, true will print. false not print
     */
    private final static boolean isPrint = BuildConfig.DEBUG;
    private final static String defaultTag = BuildConfig.LOG_TAG;

    private LogUtil() {
    }

    public static int i(Object o) {
        return isPrint && o != null ? android.util.Log.i(defaultTag, o.toString()) : -1;
    }


    /**
     * ******************** Log **************************
     */
    public static int v(String msg) {
        return isPrint && msg != null ? android.util.Log.v(defaultTag, msg) : -1;
    }

    public static int d(String msg) {
        return isPrint && msg != null ? android.util.Log.d(defaultTag, msg) : -1;
    }

    public static int i(String msg) {
        return isPrint && msg != null ? android.util.Log.i(defaultTag, msg) : -1;
    }

    public static int w(String msg) {
        return isPrint && msg != null ? android.util.Log.w(defaultTag, msg) : -1;
    }

    public static int e(String msg) {
        return isPrint && msg != null ? android.util.Log.e(defaultTag, msg) : -1;
    }

    /**
     * ******************** Log with object list **************************
     */
    public static int v(Object... msg) {
        return isPrint ? android.util.Log.v(defaultTag, getLogMessage(msg)) : -1;
    }

    public static int d(Object... msg) {
        return isPrint ? android.util.Log.d(defaultTag, getLogMessage(msg)) : -1;
    }

    public static int i(Object... msg) {
        return isPrint ? android.util.Log.i(defaultTag, getLogMessage(msg)) : -1;
    }

    public static int w(Object... msg) {
        return isPrint ? android.util.Log.w(defaultTag, getLogMessage(msg)) : -1;
    }

    public static int e( Object... msg) {
        return isPrint ? android.util.Log.e(defaultTag, getLogMessage(msg)) : -1;
    }

    private static String getLogMessage(Object... msg) {
        if (msg != null && msg.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (Object s : msg) {
                if (msg != null && s != null) {
                    sb.append(s.toString());
                }
            }
            return sb.toString();
        }
        return "";
    }

    /**
     * ******************** Log with Throwable **************************
     */
    public static int v(String msg, Throwable tr) {
        return isPrint && msg != null ? android.util.Log.v(defaultTag, msg, tr) : -1;
    }

    public static int d(String msg, Throwable tr) {
        return isPrint && msg != null ? android.util.Log.d(defaultTag, msg, tr) : -1;
    }

    public static int i(String msg, Throwable tr) {
        return isPrint && msg != null ? android.util.Log.i(defaultTag, msg, tr) : -1;
    }

    public static int w(String msg, Throwable tr) {
        return isPrint && msg != null ? android.util.Log.w(defaultTag, msg, tr) : -1;
    }

    public static int e(String msg, Throwable tr) {
        return isPrint && msg != null ? android.util.Log.e(defaultTag, msg, tr) : -1;
    }

    /**
     * ******************** defaultTag use Object TopicModel **************************
     */
    public static int v(Object defaultTag, String msg) {
        return isPrint ? android.util.Log.v(defaultTag.getClass().getSimpleName(), msg) : -1;
    }

    public static int d(Object defaultTag, String msg) {
        return isPrint ? android.util.Log.d(defaultTag.getClass().getSimpleName(), msg) : -1;
    }

    public static int i(Object defaultTag, String msg) {
        return isPrint ? android.util.Log.i(defaultTag.getClass().getSimpleName(), msg) : -1;
    }

    public static int w(Object defaultTag, String msg) {
        return isPrint ? android.util.Log.w(defaultTag.getClass().getSimpleName(), msg) : -1;
    }

    public static int e(Object defaultTag, String msg) {
        return isPrint ? android.util.Log.e(defaultTag.getClass().getSimpleName(), msg) : -1;
    }
}
