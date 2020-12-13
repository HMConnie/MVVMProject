package cn.connie.mvvm.base;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trello.rxlifecycle2.components.support.RxFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import cn.connie.mvvm.event.DefaultEvent;
import cn.connie.mvvm.utils.MVVMConstants;

public abstract class BaseFragment<VB extends ViewDataBinding, VM extends BaseViewModel> extends RxFragment {

    protected VB binding;
    protected VM viewModel;
    protected int viewModelId;

    //获取布局xml文件
    public abstract int getLayout();

    //初始化数据和UI
    public abstract void init();

    //获取viewModelId->BR.viewModel
    public abstract int getViewModelId();

    public VM getViewModel() {
        Class viewModelClass = BaseViewModel.class; //如果没有指定泛型参数，则默认使用BaseViewModel
        Type type = getClass().getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            viewModelClass = (Class) (((ParameterizedType) type).getActualTypeArguments())[1];
        }
        return (VM) ViewModelProviders.of(this).get(viewModelClass);
    }

    //刷新布局
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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //绑定xml
        binding = DataBindingUtil.inflate(inflater, getLayout(), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
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
        viewModel.getLiveData().getOnBackPressedEvent().observe(this, (Observer<Void>) o -> getActivity().onBackPressed());
        viewModel.getLiveData().getFinishEvent().observe(this, o -> getActivity().finish());
        viewModel.getLiveData().getShowLoadingDialogEvent().observe(this, o -> getActivity().showDialog(MVVMConstants.LOADING_DIALOG));
        viewModel.getLiveData().getDismissLoadingDialogEvent().observe(this, o -> getActivity().dismissDialog(MVVMConstants.LOADING_DIALOG));
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
     * 跳转页面
     *
     * @param clz 所跳转的目的Activity类
     */
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(getActivity(), clz));
    }

    /**
     * 跳转页面
     *
     * @param clz    所跳转的目的Activity类
     * @param bundle 跳转所携带的信息
     */
    public void startActivity(Class<?> clz, Bundle bundle) {
        Intent intent = new Intent(getActivity(), clz);
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
        Intent intent = new Intent(getActivity(), ContainerActivity.class);
        intent.putExtra(ContainerActivity.FRAGMENT, canonicalName);
        if (bundle != null) {
            intent.putExtra(ContainerActivity.BUNDLE, bundle);
        }
        startActivity(intent);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
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

    public boolean isBackPressed() {
        return false;
    }
}
