package cn.connie.mvvm.retrofit;

import java.io.IOException;

import cn.connie.mvvm.BuildConfig;
import cn.connie.mvvm.cache.NetCache;
import cn.connie.mvvm.utils.DeviceUtils;
import cn.connie.mvvm.utils.PhoneUtils;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class CommonInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Request newRequest = request.newBuilder()
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .addHeader("accessToken", NetCache.getToken())
                .addHeader("client", "Android")
                .addHeader("ver", BuildConfig.VERSION_NAME)
                .addHeader("deviceNumber", PhoneUtils.getUniqueId())
                .addHeader("remark", DeviceUtils.getDeviceInfo())
                .build();
        return chain.proceed(newRequest);
    }
}
