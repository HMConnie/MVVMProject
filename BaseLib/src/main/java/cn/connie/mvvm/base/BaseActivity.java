package cn.connie.mvvm.base;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import cn.connie.mvvm.dialog.LoadingDialog;
import cn.connie.mvvm.event.DefaultEvent;
import cn.connie.mvvm.utils.MVVMConstants;

public abstract class BaseActivity<VB extends ViewDataBinding, VM extends BaseViewModel> extends RxAppCompatActivity {

    protected VB binding;
    protected VM viewModel;
    protected int viewModelId;

    //获取布局xml文件
    public abstract int getLayout();

    //获取viewModelId->BR.viewModel
    public abstract int getViewModelId();

    //初始化数据和UI
    public abstract void init();

    public VM getViewModel() {
        Class viewModelClass = BaseViewModel.class; //如果没有指定泛型参数，则默认使用BaseViewModel
        Type type = getClass().getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            viewModelClass = (Class) (((ParameterizedType) type).getActualTypeArguments())[1];
        }
        return (VM) ViewModelProviders.of(this).get(viewModelClass);
    }


    /**
     * 刷新布局
     */
    public void refreshLayout() {
        if (viewModel != null) {
            binding.setVariable(viewModelId, viewModel);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(DefaultEvent defaultEvent) {
        if (defaultEvent.code == MVVMConstants.EventCode.TOKEN_EXPIRE) {
            AppManager.getInstance().finish2MainActivity();
            toLoginActivity();
        }
        onEventMainThread(defaultEvent);
    }

    /**
     * 监听回调
     */
    protected void onEventMainThread(DefaultEvent defaultEvent) {

    }

    /**
     * 跳转到登录页
     */
    protected void toLoginActivity() {

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //绑定xml
        binding = DataBindingUtil.setContentView(this, getLayout());
        //获取ViewModel
        viewModel = getViewModel();
        //获取viewModelId
        viewModelId = getViewModelId();
        //关联ViewModel
        binding.setVariable(viewModelId, viewModel);
        //支持LiveData绑定xml，数据改变，UI自动会更新
        binding.setLifecycleOwner(this);
        //让ViewModel拥有View的生命周期感应
        getLifecycle().addObserver(viewModel);
        //注入RxLifecycle生命周期
        viewModel.inject(this);
        //处理LiveData数据变化
        initLiveDataChange();
        //注册EventBus
        EventBus.getDefault().register(this);
        init();
    }

    private void initLiveDataChange() {
        viewModel.getLiveData().getOnBackPressedEvent().observe(this, (Observer<Void>) o -> onBackPressed());
        viewModel.getLiveData().getFinishEvent().observe(this, o -> finish());
        viewModel.getLiveData().getShowLoadingDialogEvent().observe(this, o -> showDialog(MVVMConstants.LOADING_DIALOG));
        viewModel.getLiveData().getDismissLoadingDialogEvent().observe(this, o -> dismissDialog(MVVMConstants.LOADING_DIALOG));
        viewModel.getLiveData().getStartActivityEvent().observe(this, (Observer<Map<String, Object>>) params -> {
            Class<?> clz = (Class<?>) params.get(MVVMConstants.CLASS);
            Bundle bundle = (Bundle) params.get(MVVMConstants.BUNDLE);
            startActivity(clz, bundle);
        });
        viewModel.getLiveData().getStartContainerActivityEvent().observe(this, (Observer<Map<String, Object>>) params -> {
            String canonicalName = (String) params.get(MVVMConstants.CANONICAL_NAME);
            Bundle bundle = (Bundle) params.get(MVVMConstants.BUNDLE);
            startContainerActivity(canonicalName, bundle);
        });
    }

    /**
     * 显示对话框
     */
    @Override
    protected Dialog onCreateDialog(int id) {
        if (id == MVVMConstants.LOADING_DIALOG) {
            return new LoadingDialog(this);
        }
        return super.onCreateDialog(id);
    }

    /**
     * 跳转页面
     *
     * @param clz 所跳转的目的Activity类
     */
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(this, clz));
    }

    /**
     * 跳转页面
     *
     * @param clz    所跳转的目的Activity类
     * @param bundle 跳转所携带的信息
     */
    public void startActivity(Class<?> clz, Bundle bundle) {
        Intent intent = new Intent(this, clz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
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
        Intent intent = new Intent(this, ContainerActivity.class);
        intent.putExtra(ContainerActivity.FRAGMENT, canonicalName);
        if (bundle != null) {
            intent.putExtra(ContainerActivity.BUNDLE, bundle);
        }
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (viewModel != null) {
            viewModel.onCleared();
            getLifecycle().removeObserver(viewModel);
        }
        if (binding != null) {
            binding.unbind();
        }
        EventBus.getDefault().unregister(this);
        BaseApplication.getInstance().getRefWatcher().watch(this);
    }
}
