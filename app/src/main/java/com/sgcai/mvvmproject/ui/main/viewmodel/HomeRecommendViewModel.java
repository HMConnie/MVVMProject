package com.sgcai.mvvmproject.ui.main.viewmodel;

import android.app.Application;

import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.sgcai.mvvmproject.BR;
import com.sgcai.mvvmproject.R;
import com.sgcai.mvvmproject.net.NetModel;
import com.sgcai.mvvmproject.net.param.NewRecommendParam;
import com.sgcai.mvvmproject.net.param.Paging;
import com.sgcai.mvvmproject.net.resp.CommunityHomePageRecommendResult;
import com.sgcai.mvvmproject.net.resp.LabelListResult;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import cn.connie.mvvm.base.BaseViewModel;
import cn.connie.mvvm.binding.command.BindingCommand;
import cn.connie.mvvm.binding.command.BindingConsumer;
import cn.connie.mvvm.event.SingleLiveEvent;
import cn.connie.mvvm.ex.ApiDisposableObserver;
import cn.connie.mvvm.ex.ResponseThrowable;
import cn.connie.mvvm.utils.ToastUtils;
import me.tatarka.bindingcollectionadapter2.ItemBinding;

public class HomeRecommendViewModel extends BaseViewModel<NetModel> {

    public static final int ARTICLE = 1;
    public static final int SQUARE = 2;
    public static final int INFORMATION = 3;
    public static final int GROUP = 4;
    public static final int GRID = 5;
    public static final int VIDEO = 6;

    public SingleLiveEvent<LabelListResult> labelEvent = new SingleLiveEvent<>();
    public SingleLiveEvent<TwinklingRefreshLayout> refreshEvent = new SingleLiveEvent<>();
    public SingleLiveEvent<TwinklingRefreshLayout> loadMoreEvent = new SingleLiveEvent<>();

    public Paging mPaging = new Paging();

    public BindingCommand onLoadMoreCommand = new BindingCommand((BindingConsumer<TwinklingRefreshLayout>) refreshLayout -> {
        mPaging.reset();
        loadMoreEvent.setValue(refreshLayout);
    });
    public BindingCommand onRefreshCommand = new BindingCommand((BindingConsumer<TwinklingRefreshLayout>) refreshLayout -> {
        int nextPage = mPaging.curPage + 1;
        if (nextPage >= mPaging.pageCount) {
            refreshLayout.finishLoadmore();
            return;
        }
        mPaging.curPage = nextPage;
        refreshEvent.setValue(refreshLayout);
    });

    //给RecyclerView添加ObservableList
    public ObservableList<RecommendTabViewModel> observableList = new ObservableArrayList<>();
    //RecyclerView多布局添加ItemBinding
    public ItemBinding<RecommendTabViewModel> itemBinding = ItemBinding.of((itemBinding, position, item) -> {
        //通过item的类型, 动态设置Item加载的布局
        int itemType = (int) item.getItemType();
        switch (itemType) {
            case ARTICLE:
                itemBinding.set(BR.viewModel, R.layout.adapter_home_recommand_article);
                break;
            case SQUARE:
                itemBinding.set(BR.viewModel, R.layout.adapter_home_recommand_square);
                break;
            case INFORMATION:
                itemBinding.set(BR.viewModel, R.layout.adapter_home_recommand_information);
                break;
            case GROUP:
                itemBinding.set(BR.viewModel, R.layout.adapter_home_recommand_advertisement);
                break;
            case GRID:
                itemBinding.set(BR.viewModel, R.layout.adapter_home_recommand_grid);
                break;
            case VIDEO:
                itemBinding.set(BR.viewModel, R.layout.adapter_home_recommand_video);
                break;
        }

    });

    public HomeRecommendViewModel(@NonNull Application application) {
        super(application);
    }


    @Override
    public void onCreate() {
        super.onCreate();
        //获取分类数据
        showLoadingDialog();
        model.getLabelList(this, new ApiDisposableObserver<LabelListResult>() {
            @Override
            public void onResult(LabelListResult labelListResult) {
                dismissLoadingDialog();
                labelEvent.setValue(labelListResult);
            }

            @Override
            public void onError(ResponseThrowable e) {
                dismissLoadingDialog();
                ToastUtils.showLong(e.getMessage());
            }
        });
    }


    public void loadRecommendData(String labelId, TwinklingRefreshLayout refreshLayout) {
        NewRecommendParam param = new NewRecommendParam(mPaging.curPage, mPaging.pageSize, labelId, 1);
        model.getCommand(param, this, new ApiDisposableObserver<CommunityHomePageRecommendResult>() {
            @Override
            public void onResult(CommunityHomePageRecommendResult result) {
                refreshLayout.finishRefreshing();
                refreshLayout.finishLoadmore();
                mPaging.mData = result.data.list;
                mPaging.success(result.data.recordCnt);
                if (result.data.list != null) {
                    if (mPaging.curPage == 1) {
                        observableList.clear();
                    }
                    for (CommunityHomePageRecommendResult.DataBean.ListBean item : result.data.list) {
                        // 0圈内新鲜是 1:文章 2:广场
                        if (item.dynamicType == 0) {
                            observableList.add(new RecommendTabViewModel(INFORMATION, HomeRecommendViewModel.this, item));
                        } else if (item.dynamicType == 1) {
                            observableList.add(new RecommendTabViewModel(ARTICLE, HomeRecommendViewModel.this, item));
                        } else if (item.dynamicType == 2) {
                            observableList.add(new RecommendTabViewModel(SQUARE, HomeRecommendViewModel.this, item));
                        } else if (item.dynamicType == 3) {
                            observableList.add(new RecommendTabViewModel(GROUP, HomeRecommendViewModel.this, item));
                        } else if (item.dynamicType == 4) {
                            observableList.add(new RecommendTabViewModel(VIDEO, HomeRecommendViewModel.this, item));
                        }
                    }
                }
            }

            @Override
            public void onError(ResponseThrowable e) {
                refreshLayout.finishRefreshing();
                refreshLayout.finishLoadmore();
                ToastUtils.showLong(e.getMessage());
            }
        });
    }
}
