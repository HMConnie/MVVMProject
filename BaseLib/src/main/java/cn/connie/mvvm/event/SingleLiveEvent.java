package cn.connie.mvvm.event;

import android.util.Log;

import java.util.concurrent.atomic.AtomicBoolean;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

public class SingleLiveEvent<T> extends MutableLiveData<T> {

    private final AtomicBoolean mPending = new AtomicBoolean(false);

    @MainThread
    @Override
    public void observe(@NonNull LifecycleOwner owner, @NonNull Observer observer) {
        if (hasActiveObservers()) {
            Log.e(SingleLiveEvent.class.getSimpleName(), "Multiple observers registered but only one will be notified of changes.");
        }
        super.observe(owner, t -> {
            if (mPending.compareAndSet(true, false)) {
                observer.onChanged(t);
            }
        });
    }

    @MainThread
    @Override
    public void setValue(T value) {
        mPending.set(true);
        super.setValue(value);
    }

    /**
     * 调用监听回调数据为空的值
     * Used for cases where T is Void, to make calls cleaner.
     */
    @MainThread
    public void call(){
        setValue(null);
    }
}
