package com.sgcai.mvvmproject.ui.main.fragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Environment;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

import com.sgcai.mvvmproject.BR;
import com.sgcai.mvvmproject.R;
import com.sgcai.mvvmproject.databinding.FragmentBenbenRecommendBinding;
import com.sgcai.mvvmproject.net.resp.LabelListResult;
import com.sgcai.mvvmproject.ui.main.adapter.HomeRecommendAdapter;
import com.sgcai.mvvmproject.ui.main.viewmodel.HomeRecommendViewModel;
import com.sgcai.mvvmproject.view.MagicPagerTitleView;

import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.UIUtil;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

import androidx.lifecycle.Observer;
import cn.connie.mvvm.base.BaseFragment;
import cn.connie.mvvm.utils.GsonUtil;
import cn.connie.mvvm.utils.RxUtils;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class HomeBenBenRecommendFragment extends BaseFragment<FragmentBenbenRecommendBinding, HomeRecommendViewModel> {

    @Override
    public int getLayout() {
        return R.layout.fragment_benben_recommend;
    }

    @Override
    public void init() {
        viewModel.labelEvent.observe(this, (Observer<LabelListResult>) o -> {
            if (o == null) {
                return;
            }
            initTabBar(o.data);
        });
    }


    private void initTabBar(List<LabelListResult.DataBean> list) {
        HomeRecommendAdapter homeRecommendAdapter = new HomeRecommendAdapter(getChildFragmentManager(), list);
        CommonNavigator commonNavigator = new CommonNavigator(getContext());
        commonNavigator.setScrollPivotX(0.65f);
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount() {
                return homeRecommendAdapter.getCount();
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int index) {
                MagicPagerTitleView magicPagerTitleView = new MagicPagerTitleView(context);
                magicPagerTitleView.setText(homeRecommendAdapter.getPageTitle(index));
                magicPagerTitleView.setNormalColor(Color.parseColor("#afc1bc"));
                magicPagerTitleView.setSelectedColor(Color.parseColor("#ff3c53"));
                magicPagerTitleView.setOnClickListener(v -> binding.viewPager.setCurrentItem(index));
                return magicPagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                LinePagerIndicator indicator = new LinePagerIndicator(context);
                indicator.setMode(LinePagerIndicator.MODE_EXACTLY);
                indicator.setLineHeight(UIUtil.dip2px(context, 5));
                indicator.setLineWidth(UIUtil.dip2px(context, 16));
                indicator.setRoundRadius(UIUtil.dip2px(context, 3));
                indicator.setStartInterpolator(new AccelerateInterpolator());
                indicator.setEndInterpolator(new DecelerateInterpolator(2.0f));
                indicator.setColors(Color.parseColor("#afc1bc"));
                return indicator;
            }
        });
        binding.magicIndicator.setNavigator(commonNavigator);
        ViewPagerHelper.bind(binding.magicIndicator, binding.viewPager);
        binding.viewPager.setAdapter(homeRecommendAdapter);

        binding.btnTest.setOnClickListener(view -> testMeiYan());
    }


    private void testMeiYan() {


    }

    @Override
    public int getViewModelId() {
        return BR.viewModel;
    }
}
