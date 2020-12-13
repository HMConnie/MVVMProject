package com.sgcai.mvvmproject.view;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.Gravity;

import net.lucode.hackware.magicindicator.buildins.UIUtil;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IMeasurablePagerTitleView;

public class MagicPagerTitleView extends androidx.appcompat.widget.AppCompatTextView implements IMeasurablePagerTitleView {
    protected int mSelectedColor;
    protected int mNormalColor;
    private boolean keepBold;

    public MagicPagerTitleView(Context context) {
        super(context, null);
        init(context);
    }

    public MagicPagerTitleView(Context context, int padding) {
        super(context, null);
        init(context, padding);
    }

    public MagicPagerTitleView(Context context, int padding, boolean keepBold) {
        super(context, null);
        this.keepBold = keepBold;
        init(context, padding);
    }

    private void init(Context context) {
        setGravity(Gravity.CENTER);
        int padding = UIUtil.dip2px(context, 10);
        setPadding(padding, 0, padding, 0);
        setSingleLine();
        setEllipsize(TextUtils.TruncateAt.END);

    }

    private void init(Context context, int padding) {
        setGravity(Gravity.CENTER);
        int mPadding = UIUtil.dip2px(context, padding);
        setPadding(mPadding, 0, mPadding, 0);
        setSingleLine();
        setEllipsize(TextUtils.TruncateAt.END);
        if (keepBold) {
            getPaint().setFakeBoldText(true);
        }

    }

    @Override
    public void onSelected(int index, int totalCount) {
        setTextColor(mSelectedColor);
        if (!keepBold) {
            setTextSize(15);
            getPaint().setFakeBoldText(true);
        }

    }

    @Override
    public void onDeselected(int index, int totalCount) {
        setTextColor(mNormalColor);
        if (!keepBold) {
            setTextSize(14);
            getPaint().setFakeBoldText(false);
        }
    }

    @Override
    public void onLeave(int index, int totalCount, float leavePercent, boolean leftToRight) {
    }

    @Override
    public void onEnter(int index, int totalCount, float enterPercent, boolean leftToRight) {
    }

    @Override
    public int getContentLeft() {
        Rect bound = new Rect();
        getPaint().getTextBounds(getText().toString(), 0, getText().length(), bound);
        int contentWidth = bound.width();
        return getLeft() + getWidth() / 2 - contentWidth / 2;
    }

    @Override
    public int getContentTop() {
        Paint.FontMetrics metrics = getPaint().getFontMetrics();
        float contentHeight = metrics.bottom - metrics.top;
        return (int) (getHeight() / 2 - contentHeight / 2);
    }

    @Override
    public int getContentRight() {
        Rect bound = new Rect();
        getPaint().getTextBounds(getText().toString(), 0, getText().length(), bound);
        int contentWidth = bound.width();
        return getLeft() + getWidth() / 2 + contentWidth / 2;
    }

    @Override
    public int getContentBottom() {
        Paint.FontMetrics metrics = getPaint().getFontMetrics();
        float contentHeight = metrics.bottom - metrics.top;
        return (int) (getHeight() / 2 + contentHeight / 2);
    }

    public int getSelectedColor() {
        return mSelectedColor;
    }

    public void setSelectedColor(int selectedColor) {
        mSelectedColor = selectedColor;
    }

    public int getNormalColor() {
        return mNormalColor;
    }

    public void setNormalColor(int normalColor) {
        mNormalColor = normalColor;
    }
}
