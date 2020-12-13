package com.sgcai.mvvmproject.ui.main.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.sgcai.mvvmproject.R;
import com.sgcai.mvvmproject.ui.main.viewmodel.HomeRecommendViewModel;
import com.sgcai.mvvmproject.ui.main.viewmodel.RecommendTabViewModel;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;
import me.tatarka.bindingcollectionadapter2.BindingRecyclerViewAdapter;

public class HomeRecommendTabAdapter extends BindingRecyclerViewAdapter<RecommendTabViewModel> {

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position, List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);

        LinearLayout ll_image = holder.itemView.findViewById(R.id.ll_image);
        ImageView iv_one_image = holder.itemView.findViewById(R.id.iv_one_image);
        LinearLayout ll_two_image = holder.itemView.findViewById(R.id.ll_two_image);
        ImageView iv_two_image_1 = holder.itemView.findViewById(R.id.iv_two_image_1);
        ImageView iv_two_image_2 = holder.itemView.findViewById(R.id.iv_two_image_2);
        LinearLayout ll_three_image = holder.itemView.findViewById(R.id.ll_three_image);
        ImageView iv_three_image_1 = holder.itemView.findViewById(R.id.iv_three_image_1);
        ImageView iv_three_image_2 = holder.itemView.findViewById(R.id.iv_three_image_2);
        ImageView iv_three_image_3 = holder.itemView.findViewById(R.id.iv_three_image_3);
        RecommendTabViewModel viewModel = getAdapterItem(position);
        int itemType = (int) viewModel.getItemType();
        switch (itemType) {
            case HomeRecommendViewModel.SQUARE:
                ll_image.setVisibility(View.GONE);
                ll_two_image.setVisibility(View.GONE);
                ll_three_image.setVisibility(View.GONE);
                if (viewModel.item.dynamicImage == null || viewModel.item.dynamicImage.isEmpty()) {
                    return;
                }
                if (viewModel.item.dynamicImage.size() == 1) {
                    ll_image.setVisibility(View.VISIBLE);
                    Glide.with(iv_one_image.getContext())
                            .load(viewModel.item.dynamicImage.get(0))
                            .apply(new RequestOptions().placeholder(R.drawable.default_banner))
                            .into(iv_one_image);

                } else if (viewModel.item.dynamicImage.size() == 2) {
                    ll_two_image.setVisibility(View.VISIBLE);
                    Glide.with(iv_one_image.getContext())
                            .load(viewModel.item.dynamicImage.get(0))
                            .apply(new RequestOptions().placeholder(R.drawable.default_banner))
                            .into(iv_two_image_1);
                    Glide.with(iv_one_image.getContext())
                            .load(viewModel.item.dynamicImage.get(1))
                            .apply(new RequestOptions().placeholder(R.drawable.default_banner))
                            .into(iv_two_image_2);
                } else {
                    ll_three_image.setVisibility(View.VISIBLE);
                    Glide.with(iv_one_image.getContext())
                            .load(viewModel.item.dynamicImage.get(0))
                            .apply(new RequestOptions().placeholder(R.drawable.default_banner))
                            .into(iv_three_image_1);
                    Glide.with(iv_one_image.getContext())
                            .load(viewModel.item.dynamicImage.get(1))
                            .apply(new RequestOptions().placeholder(R.drawable.default_banner))
                            .into(iv_three_image_2);
                    Glide.with(iv_one_image.getContext())
                            .load(viewModel.item.dynamicImage.get(2))
                            .apply(new RequestOptions().placeholder(R.drawable.default_banner))
                            .into(iv_three_image_3);
                }
                break;
        }
    }

}
