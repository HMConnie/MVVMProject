package cn.connie.mvvm.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;

import com.wang.avi.AVLoadingIndicatorView;

import cn.connie.mvvm.R;


public class LoadingDialog extends Dialog {


    private AVLoadingIndicatorView mAVLoadingIndicatorView;

    public LoadingDialog(Context context) {
        super(context, R.style.LoadingViewDialog);
        View rootView = View.inflate(context, R.layout.dialog_loading, null);
        setContentView(rootView);
        mAVLoadingIndicatorView = rootView.findViewById(R.id.avIndicatorView);
        setCancelable(false);
    }

    @Override
    public void dismiss() {
        super.dismiss();
        mAVLoadingIndicatorView.hide();
    }

    @Override
    public void show() {
        super.show();
        mAVLoadingIndicatorView.show();
    }

}
