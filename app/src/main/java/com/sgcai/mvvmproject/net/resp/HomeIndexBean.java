package com.sgcai.mvvmproject.net.resp;

import cn.connie.mvvm.ex.BaseResponse;

/**
 * Describe:
 * Created by Dalvik on 2019-07-17.
 */
public class HomeIndexBean extends BaseResponse {


    private HomeIndexBean1 homeIndexBean1;
    private HomeIndexBean2 homeIndexBean2;
    private HomeIndexBean3 homeIndexBean3;

    public HomeIndexBean(HomeIndexBean1 homeIndexBean1, HomeIndexBean2 homeIndexBean2, HomeIndexBean3 homeIndexBean3) {
        this.homeIndexBean1 = homeIndexBean1;
        this.homeIndexBean2 = homeIndexBean2;
        this.homeIndexBean3 = homeIndexBean3;
    }

    public HomeIndexBean1 getHomeIndexBean1() {
        return homeIndexBean1;
    }

    public void setHomeIndexBean1(HomeIndexBean1 homeIndexBean1) {
        this.homeIndexBean1 = homeIndexBean1;
    }

    public HomeIndexBean2 getHomeIndexBean2() {
        return homeIndexBean2;
    }

    public void setHomeIndexBean2(HomeIndexBean2 homeIndexBean2) {
        this.homeIndexBean2 = homeIndexBean2;
    }

    public HomeIndexBean3 getHomeIndexBean3() {
        return homeIndexBean3;
    }

    public void setHomeIndexBean3(HomeIndexBean3 homeIndexBean3) {
        this.homeIndexBean3 = homeIndexBean3;
    }
}
