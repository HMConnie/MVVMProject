package cn.connie.mvvm.event;

import org.greenrobot.eventbus.EventBus;

public class RxBus {

    private static RxBus rxBus;

    private RxBus() {
    }

    public static RxBus getInstance() {
        if (rxBus == null) {
            synchronized (RxBus.class) {
                if (rxBus == null) {
                    rxBus = new RxBus();
                }
            }
        }
        return rxBus;
    }

    public void send(int code) {
        EventBus.getDefault().post(new DefaultEvent(code));
    }

    public void send(int code, Object... content) {
        EventBus.getDefault().post(new DefaultEvent(code, content));
    }
}