package cn.connie.mvvm.utils;

public interface MVVMConstants {
    String TOKEN = "TOKEN";
    int HTTP_RESPONSE_DISK_CACHE_MAX_SIZE = 50 * 1024 * 1024;//最大缓存50M

    String CLASS = "CLASS";
    String BUNDLE = "BUNDLE";
    String CANONICAL_NAME = "CANONICAL_NAME";
    String CACHE_SP_FILE = "CACHE_SP_FILE";
    String BASE_URL_KEY = "BASE_URL_KEY";
    int LOADING_DIALOG = 100;

    interface EventCode {
        int TOKEN_EXPIRE = 401;
    }
}
