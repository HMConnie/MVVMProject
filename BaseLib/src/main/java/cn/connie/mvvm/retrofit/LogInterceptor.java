package cn.connie.mvvm.retrofit;


import java.io.IOException;
import java.nio.charset.Charset;

import cn.connie.mvvm.BuildConfig;
import cn.connie.mvvm.utils.LogUtil;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;

/**
 * Created by hinge on 17/4/6.
 */

public class LogInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Response response = chain.proceed(request);
        if (BuildConfig.DEBUG) {
            ResponseBody responseBody = response.body();
            BufferedSource source = responseBody.source();
            source.request(Long.MAX_VALUE);
            Buffer buffer = source.buffer();
            if (responseBody.contentLength() != 0) {
                String respResult = buffer.clone().readString(Charset.forName("UTF-8"));
                LogUtil.e("url = " + request.url().toString() + "\nresponse_result = " + respResult);
            }
        }
        return response;
    }

}
