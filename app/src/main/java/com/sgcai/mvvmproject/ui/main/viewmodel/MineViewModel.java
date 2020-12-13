package com.sgcai.mvvmproject.ui.main.viewmodel;

import android.app.Application;

import com.sgcai.mvvmproject.net.NetModel;

import androidx.annotation.NonNull;
import cn.connie.mvvm.base.BaseViewModel;

public class MineViewModel extends BaseViewModel<NetModel> {

    public MineViewModel(@NonNull Application application) {
        super(application);
    }
}
