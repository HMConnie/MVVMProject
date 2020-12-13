package com.sgcai.mvvmproject.view.binding;

import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;

import androidx.databinding.BindingAdapter;
import cn.connie.mvvm.binding.command.BindingCommand;

public class TwinklingRefreshAdapter {

    @BindingAdapter(value = {"onRefreshCommand", "onLoadMoreCommand"}, requireAll = false)
    public static void onRefreshCommand(TwinklingRefreshLayout refreshLayout, BindingCommand refreshCommand, BindingCommand loadMoreCommand) {
        refreshLayout.setOnRefreshListener(new RefreshListenerAdapter() {
            @Override
            public void onRefresh(TwinklingRefreshLayout refreshLayout) {
                super.onRefresh(refreshLayout);
                if (refreshCommand != null) {
                    refreshCommand.execute(refreshLayout);
                }
            }

            @Override
            public void onLoadMore(TwinklingRefreshLayout refreshLayout) {
                super.onLoadMore(refreshLayout);
                if (loadMoreCommand != null) {
                    loadMoreCommand.execute(refreshLayout);
                }
            }
        });
    }

}
