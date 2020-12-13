package com.sgcai.mvvmproject.net;

import com.sgcai.mvvmproject.net.resp.CommunityHomePageRecommendResult;
import com.sgcai.mvvmproject.net.resp.HomeIndexBean1;
import com.sgcai.mvvmproject.net.resp.HomeIndexBean2;
import com.sgcai.mvvmproject.net.resp.HomeIndexBean3;
import com.sgcai.mvvmproject.net.resp.LabelListResult;
import com.sgcai.mvvmproject.net.resp.UserResult;

import java.util.Map;

import cn.connie.mvvm.utils.MVVMConstants;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface NetServices {


    @POST("/user/login")
    Observable<UserResult> login(@Body Object bodyParams);

    //获取首页数据
    @GET("/newindex/data1")
    Observable<HomeIndexBean1> getHomeIndex1(@Query("novelType") int novelType, @Query("tagId") Integer tagId);

    //获取首页数据
    @GET("/newindex/data2")
    Observable<HomeIndexBean2> getHomeIndex2(@Query("novelType") int novelType);

    //获取首页数据
    @GET("/newindex/data3")
    Observable<HomeIndexBean3> getHomeIndex3(@Query("novelType") int novelType);


    /**
     * 类型tab列表
     */
    @GET("/communityHomePage/labelList")
    Observable<LabelListResult> labelList(@HeaderMap Map<String, String> headers, @QueryMap Map<String, String> params);

    @GET("/communityHomePage/newRecommend")
    Observable<CommunityHomePageRecommendResult> newRecommend(@HeaderMap Map<String, String> headMap, @QueryMap(encoded = true) Map<String, String> map);
}
