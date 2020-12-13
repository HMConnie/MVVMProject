package cn.connie.mvvm.base;

import android.app.Application;
import android.os.Bundle;

import com.trello.rxlifecycle2.LifecycleProvider;

import java.lang.ref.WeakReference;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import cn.connie.mvvm.binding.command.BindingCommand;
import cn.connie.mvvm.event.SingleLiveEvent;
import cn.connie.mvvm.utils.LogUtil;
import cn.connie.mvvm.utils.MVVMConstants;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public abstract class BaseViewModel<M extends BaseModel> extends AndroidViewModel implements IBaseViewModel, Consumer<Disposable> {

    protected M model;
    protected UIChangeLiveData liveData;
    protected WeakReference<LifecycleProvider> lifecycleProvider;
    //管理RxJava，主要针对RxJava异步操作造成的内存泄漏
    private CompositeDisposable mCompositeDisposable;

    // 返回键处理
    public BindingCommand backBtnClick = new BindingCommand(() -> onBackPress());

    //创建model
    private M createModel() {
        Class modelClass = BaseModel.class; //如果没有指定泛型参数，则默认使用BaseViewModel
        Type type = getClass().getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            modelClass = (Class) (((ParameterizedType) type).getActualTypeArguments())[0];
        }
        try {
            return (M) modelClass.newInstance();
        } catch (Exception e) {
            throw new RuntimeException("创建Model出错..");
        }
    }

    public BaseViewModel(@NonNull Application application) {
        super(application);
        this.model = createModel();
        mCompositeDisposable = new CompositeDisposable();
    }


    protected void addSubscribe(Disposable disposable) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(disposable);
    }

    @Override
    public void onAny(LifecycleOwner owner, Lifecycle.Event event) {
        LogUtil.e("BaseViewModel onAny");
    }

    @Override
    public void onCreate() {
        LogUtil.e("BaseViewModel onCreate");
    }

    @Override
    public void onDestroy() {
        LogUtil.e("BaseViewModel onDestroy");
    }

    @Override
    public void onStart() {
        LogUtil.e("BaseViewModel onStart");
    }

    @Override
    public void onStop() {
        LogUtil.e("BaseViewModel onStop");
    }

    @Override
    public void onResume() {
        LogUtil.e("BaseViewModel onResume");
    }

    @Override
    public void onPause() {
        LogUtil.e("BaseViewModel onPause");
    }

    /**
     * 跳转页面
     *
     * @param clz 所跳转的目的Activity类
     */
    public void startActivity(Class<?> clz) {
        startActivity(clz, null);
    }

    /**
     * 跳转页面
     *
     * @param clz    所跳转的目的Activity类
     * @param bundle 跳转所携带的信息
     */
    public void startActivity(Class<?> clz, Bundle bundle) {
        Map<String, Object> params = new HashMap<>();
        params.put(MVVMConstants.CLASS, clz);
        if (bundle != null) {
            params.put(MVVMConstants.BUNDLE, bundle);
        }
        getLiveData().getStartActivityEvent().postValue(params);
    }

    /**
     * 跳转容器页面
     *
     * @param canonicalName 规范名 : Fragment.class.getCanonicalName()
     */
    public void startContainerActivity(String canonicalName) {
        startContainerActivity(canonicalName, null);
    }

    /**
     * 跳转容器页面
     *
     * @param canonicalName 规范名 : Fragment.class.getCanonicalName()
     * @param bundle        跳转所携带的信息
     */
    public void startContainerActivity(String canonicalName, Bundle bundle) {
        Map<String, Object> params = new HashMap<>();
        params.put(MVVMConstants.CANONICAL_NAME, canonicalName);
        if (bundle != null) {
            params.put(MVVMConstants.BUNDLE, bundle);
        }
        getLiveData().getStartContainerActivityEvent().postValue(params);
    }

    /**
     * 显示对话框
     */
    public void showLoadingDialog() {
        getLiveData().getShowLoadingDialogEvent().call();
    }

    /**
     * 关闭对话框
     */
    public void dismissLoadingDialog() {
        getLiveData().getDismissLoadingDialogEvent().call();
    }

    /**
     * 关闭页面
     */
    public void finishActivity() {
        getLiveData().getFinishEvent().call();
    }

    /**
     * 执行onBackPress
     */
    public void onBackPress() {
        getLiveData().getOnBackPressedEvent().call();
    }

    public void inject(LifecycleProvider provider) {
        lifecycleProvider = new WeakReference<>(provider);
    }

    public LifecycleProvider getLifecycleProvider() {
        return lifecycleProvider.get();
    }

    public UIChangeLiveData getLiveData() {
        if (liveData == null) {
            liveData = new UIChangeLiveData();
        }
        return liveData;
    }

    public final class UIChangeLiveData extends SingleLiveEvent {
        private SingleLiveEvent<Map<String, Object>> startActivityEvent;
        private SingleLiveEvent<Map<String, Object>> startContainerActivityEvent;
        private SingleLiveEvent<Void> showLoadingDialogEvent;
        private SingleLiveEvent<Void> dismissLoadingDialogEvent;
        private SingleLiveEvent<Void> finishEvent;
        private SingleLiveEvent<Void> onBackPressedEvent;

        public SingleLiveEvent<Map<String, Object>> getStartActivityEvent() {
            return startActivityEvent = createLiveData(startActivityEvent);
        }

        public SingleLiveEvent<Map<String, Object>> getStartContainerActivityEvent() {
            return startContainerActivityEvent = createLiveData(startContainerActivityEvent);
        }

        public SingleLiveEvent<Void> getFinishEvent() {
            return finishEvent = createLiveData(finishEvent);
        }

        public SingleLiveEvent<Void> getOnBackPressedEvent() {
            return onBackPressedEvent = createLiveData(onBackPressedEvent);
        }

        public SingleLiveEvent<Void> getShowLoadingDialogEvent() {
            return showLoadingDialogEvent = createLiveData(showLoadingDialogEvent);
        }

        public SingleLiveEvent<Void> getDismissLoadingDialogEvent() {
            return dismissLoadingDialogEvent = createLiveData(dismissLoadingDialogEvent);
        }

        private SingleLiveEvent createLiveData(SingleLiveEvent event) {
            if (event == null) {
                event = new SingleLiveEvent<>();
            }
            return event;
        }


    }

    @Override
    public void accept(Disposable disposable) throws Exception {
        addSubscribe(disposable);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (model != null) {
            model.onCleared();
        }
        if (mCompositeDisposable != null) {
            mCompositeDisposable.clear();
        }
        if (lifecycleProvider != null) {
            lifecycleProvider.clear();
        }
    }

}
