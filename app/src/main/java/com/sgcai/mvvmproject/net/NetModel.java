package com.sgcai.mvvmproject.net;

import com.sgcai.mvvmproject.net.param.LabelListParam;
import com.sgcai.mvvmproject.net.param.LoginParam;
import com.sgcai.mvvmproject.net.param.NewRecommendParam;
import com.sgcai.mvvmproject.net.resp.CommunityHomePageRecommendResult;
import com.sgcai.mvvmproject.net.resp.HomeIndexBean;
import com.sgcai.mvvmproject.net.resp.HomeIndexBean1;
import com.sgcai.mvvmproject.net.resp.HomeIndexBean2;
import com.sgcai.mvvmproject.net.resp.HomeIndexBean3;
import com.sgcai.mvvmproject.net.resp.LabelListResult;
import com.sgcai.mvvmproject.net.resp.UserResult;

import cn.connie.mvvm.base.BaseModel;
import cn.connie.mvvm.base.BaseViewModel;
import cn.connie.mvvm.ex.ApiDisposableObserver;
import cn.connie.mvvm.retrofit.ServiceGenerator;
import cn.connie.mvvm.utils.RxUtils;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Function3;

/**
 * 接口方面的model
 */
public class NetModel extends BaseModel {

    public void login(LoginParam loginParam, BaseViewModel viewModel, ApiDisposableObserver<UserResult> observer) {
        ServiceGenerator.getInstance()
                .createService(NetServices.class)
                .login(loginParam)
                .compose(RxUtils.exceptionTransformer()) //错误处理
                .compose(RxUtils.schedulersTransformer()) //线程调度
                .doOnSubscribe(viewModel) //请求与ViewModel周期同步
                .subscribe(observer);
    }

    public void getLabelList(BaseViewModel viewModel, ApiDisposableObserver<LabelListResult> observer) {
        LabelListParam param = new LabelListParam(0);
        ServiceGenerator.getInstance()
                .createService(NetServices.class)
                .labelList(param.getHeaders(), param.getBodyParams())
                .compose(RxUtils.exceptionTransformer()) //错误处理
                .compose(RxUtils.schedulersTransformer()) //线程调度
                .doOnSubscribe(viewModel) //请求与ViewModel周期同步
                .map((Function<LabelListResult, LabelListResult>) o -> {
                    o.setStatus(200);
                    return o;
                })
                .subscribe(observer);
    }
    public void getCommand(NewRecommendParam param,BaseViewModel viewModel, ApiDisposableObserver<CommunityHomePageRecommendResult> observer) {
        ServiceGenerator.getInstance()
                .createService(NetServices.class)
                .newRecommend(param.getHeaders(), param.getBodyParams())
                .compose(RxUtils.exceptionTransformer()) //错误处理
                .compose(RxUtils.schedulersTransformer()) //线程调度
                .doOnSubscribe(viewModel) //请求与ViewModel周期同步
                .map((Function<CommunityHomePageRecommendResult, CommunityHomePageRecommendResult>) o -> {
                    o.setStatus(200);
                    return o;
                })
                .subscribe(observer);
    }

    public void getHomeData(int tagId, BaseViewModel viewModel, ApiDisposableObserver<HomeIndexBean> observer) {
        Observable<HomeIndexBean1> observable1 = ServiceGenerator.getInstance()
                .createService(NetServices.class)
                .getHomeIndex1(0, tagId);
        Observable<HomeIndexBean2> observable2 = ServiceGenerator.getInstance()
                .createService(NetServices.class)
                .getHomeIndex2(0);
        Observable<HomeIndexBean3> observable3 = ServiceGenerator.getInstance()
                .createService(NetServices.class)
                .getHomeIndex3(0);
        Observable.zip(observable1, observable2, observable3,
                (Function3<HomeIndexBean1, HomeIndexBean2, HomeIndexBean3, HomeIndexBean>)
                        (homeIndexBean1, homeIndexBean2, homeIndexBean3) -> {
                            HomeIndexBean object = new HomeIndexBean(homeIndexBean1, homeIndexBean2, homeIndexBean3);
                            object.setStatus(homeIndexBean1.getStatus());
                            object.setMessage(homeIndexBean1.getMessage());
                            return object;
                        })
                .compose(RxUtils.exceptionTransformer()) //错误处理
                .compose(RxUtils.schedulersTransformer()) //线程调度
                .doOnSubscribe(viewModel) //请求与ViewModel周期同步
                .subscribe(observer);

    }
}
