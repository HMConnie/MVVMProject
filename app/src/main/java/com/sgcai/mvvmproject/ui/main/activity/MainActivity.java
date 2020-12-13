package com.sgcai.mvvmproject.ui.main.activity;


import com.sgcai.mvvmproject.R;
import com.sgcai.mvvmproject.databinding.ActivityMainBinding;
import com.sgcai.mvvmproject.ui.main.fragment.BenBenHomeFragment;
import com.sgcai.mvvmproject.ui.main.fragment.MineFragment;
import com.sgcai.mvvmproject.ui.main.viewmodel.MainViewModel;

import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import cn.connie.mvvm.base.BaseActivity;
import cn.connie.mvvm.base.BaseFragment;
import cn.connie.mvvm.utils.StatusBarUtil;
import me.tatarka.bindingcollectionadapter2.BR;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> {

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }


    @Override
    public int getViewModelId() {
        return BR.viewModel;
    }

    @Override
    public void init() {
        StatusBarUtil.setLightMode(this);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        BenBenHomeFragment benBenHomeFragment = new BenBenHomeFragment();
        MineFragment mineFragment = new MineFragment();
        fragmentTransaction.add(R.id.container, benBenHomeFragment).show(benBenHomeFragment);
        fragmentTransaction.add(R.id.container, mineFragment).hide(mineFragment);
        fragmentTransaction.commitAllowingStateLoss();

        viewModel.replaceFragmentEvent.observe(this, (Observer<Class<? extends BaseFragment>>) clz -> {
            List<Fragment> fragments = getSupportFragmentManager().getFragments();
            FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
            for (int i = 0; i < fragments.size(); i++) {
                Fragment fragment = fragments.get(i);
                if (fragment.getClass() == clz) {
                    fragmentTransaction1.show(fragment);
                } else {
                    fragmentTransaction1.hide(fragment);
                }
            }
            fragmentTransaction1.commitAllowingStateLoss();
        });


    }


}