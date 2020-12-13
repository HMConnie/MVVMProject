package cn.connie.mvvm.retrofit;


import java.io.IOException;

import cn.connie.mvvm.utils.NetworkUtil;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * OkHttp网络缓存拦截器
 */

public class CacheInterceptor implements Interceptor {


    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        if (NetworkUtil.isNetworkAvailable()) {
            try {
                Response response = chain.proceed(request);
                // read from cache for 60 s
                int maxAge = 60;
                return response.newBuilder()
                        .removeHeader("Pragma")
                        .removeHeader("Cache-Control")
                        .header("Cache-Control", "public, max-age=" + maxAge)
                        .build();
            } catch (IOException e) {
                Response response = getCacheResponse(chain, request);
                if (response != null) {
                    return response;
                }
                throw e;
            }

        } else {
            return getCacheResponse(chain, request);
        }
    }


    /**
     * 获取缓存response
     */
    public Response getCacheResponse(Chain chain, Request request) throws IOException {
        //读取缓存信息
        request = request.newBuilder()
                .cacheControl(CacheControl.FORCE_CACHE)
                .build();
        Response response = chain.proceed(request);
        //set cache times is 3 days
        int maxStale = 60 * 60 * 24 * 3;
        return response.newBuilder()
                .removeHeader("Pragma")
                .removeHeader("Cache-Control")
                .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                .build();
    }
}
