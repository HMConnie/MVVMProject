package cn.connie.mvvm.retrofit;


import java.util.concurrent.TimeUnit;

import cn.connie.mvvm.BuildConfig;
import cn.connie.mvvm.utils.MVVMConstants;
import cn.connie.mvvm.utils.SDCard;
import me.jessyan.retrofiturlmanager.RetrofitUrlManager;
import okhttp3.Cache;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 网络请求生成器
 */

public class ServiceGenerator {


    private static ServiceGenerator mInstance;
    private Retrofit retrofit;


    private ServiceGenerator() {
        /**创建okhttp，拼接log拦截器、cache拦截器、请求头拦截器**/
        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder()
                .addInterceptor(new CommonInterceptor())//添加公共的请求头信息
                .addInterceptor(new CacheInterceptor()) //设置缓存拦截器
                .addInterceptor(new LogInterceptor())//日志拦截器
                .cache(new Cache(SDCard.getDiskCachePath(), MVVMConstants.HTTP_RESPONSE_DISK_CACHE_MAX_SIZE))//设置缓存
                .connectTimeout(20, TimeUnit.SECONDS) // 设置连接超时时间
                .readTimeout(20, TimeUnit.SECONDS) // 设置读取超时时间
                .retryOnConnectionFailure(true) //失败重连
                .connectionPool(new ConnectionPool(5, 1, TimeUnit.MINUTES));//keepAliveDuration时间，让每次连接1分钟后就关闭。

        OkHttpClient client = RetrofitUrlManager.getInstance().with(clientBuilder).build();

        /** 添加多个域名供选择**/
        RetrofitUrlManager.getInstance().putDomain(MVVMConstants.BASE_URL_KEY, BuildConfig.BASE_URL);

        /**创建retrofit，加入gson转化器、rxjava适配器**/
        retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();


    }

    public static ServiceGenerator getInstance() {
        if (null == mInstance) {
            synchronized (ServiceGenerator.class) {
                if (null == mInstance) {
                    mInstance = new ServiceGenerator();
                }
            }
        }
        return mInstance;
    }


    /**
     * @param clazz 接口
     * @param <T>
     * @return
     */
    public <T> T createService(Class<T> clazz) {
        return retrofit.create(clazz);
    }

}
