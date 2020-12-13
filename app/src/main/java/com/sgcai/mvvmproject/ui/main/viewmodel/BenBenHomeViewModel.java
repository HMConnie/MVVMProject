package com.sgcai.mvvmproject.ui.main.viewmodel;

import android.app.Application;

import com.sgcai.mvvmproject.net.NetModel;

import androidx.annotation.NonNull;
import cn.connie.mvvm.base.BaseViewModel;
import cn.connie.mvvm.binding.command.BindingCommand;
import cn.connie.mvvm.event.SingleLiveEvent;
import cn.connie.mvvm.utils.ToastUtils;

public class BenBenHomeViewModel extends BaseViewModel<NetModel> {

    public SingleLiveEvent<Integer> checkTabEvent = new SingleLiveEvent<>();

    public BindingCommand searchClick = new BindingCommand(() -> ToastUtils.showLong("点击搜索了"));
    public BindingCommand guideClick = new BindingCommand(() -> ToastUtils.showLong("用户指导"));
    public BindingCommand signClick = new BindingCommand(() -> ToastUtils.showLong("点击签到了"));

    public BindingCommand tabRecommendClick = new BindingCommand(() -> checkTabEvent.setValue(0));
    public BindingCommand tabFollowClick = new BindingCommand(() -> checkTabEvent.setValue(1));

    public BenBenHomeViewModel(@NonNull Application application) {
        super(application);

    }

}
