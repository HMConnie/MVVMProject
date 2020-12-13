package com.sgcai.mvvmproject.ui.main.viewmodel;

import android.app.Application;
import android.text.TextUtils;

import com.sgcai.mvvmproject.net.NetModel;
import com.sgcai.mvvmproject.ui.main.fragment.BenBenHomeFragment;
import com.sgcai.mvvmproject.ui.main.fragment.MineFragment;

import androidx.annotation.NonNull;
import cn.connie.mvvm.base.BaseFragment;
import cn.connie.mvvm.base.BaseViewModel;
import cn.connie.mvvm.binding.command.BindingCommand;
import cn.connie.mvvm.event.SingleLiveEvent;

public class MainViewModel extends BaseViewModel<NetModel> {


    public SingleLiveEvent<Class<? extends BaseFragment>> replaceFragmentEvent = new SingleLiveEvent<>();

    public BindingCommand<String> radioChange = new BindingCommand<>(s ->
            replaceFragmentEvent.setValue(TextUtils.equals("首页", s) ? BenBenHomeFragment.class : MineFragment.class)
    );

    public MainViewModel(@NonNull Application application) {
        super(application);
    }


}
