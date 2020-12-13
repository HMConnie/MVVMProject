package cn.connie.mvvm.event;

/**
 * Created by hinge on 17/9/28.
 */

public class DefaultEvent {
    public int code;
    public Object[] objs;


    public DefaultEvent(int code) {
        this.code = code;
    }

    public DefaultEvent(int code, Object... objs) {
        this.code = code;
        this.objs = objs;
    }

}
