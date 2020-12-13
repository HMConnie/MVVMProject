package com.sgcai.mvvmproject.net.param;

import android.text.TextUtils;

import com.sgcai.sign.Sign;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import cn.connie.mvvm.BuildConfig;
import cn.connie.mvvm.cache.NetCache;
import cn.connie.mvvm.utils.GsonUtil;

public class BaseBenBenParam {

    /**
     * 传入可以为空的属性值
     *
     * @return
     */
    public Map<String, String> getBodyParams() {
        Map<String, String> params = new HashMap<>();
        try {
            Field[] fields = this.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                String name = field.getName();
                if (!TextUtils.isEmpty(name)) {
                    Object obj = field.get(this);
                    params.put(name, obj != null ? obj.toString() : "");
                }


            }

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return params;
    }

    /**
     * .header("merchantNo", "" + merchantNo)
     * .header("timestamp", "" + timeStamp)
     * .header("sign", sign)
     */
    public Map<String, String> getHeaders() {
        final Map<String, String> signMap = new HashMap<>();//sign加密所需的参数
        final Map<String, String> headers = new HashMap<>();//http请求所需的请求头

        long timeStamp = System.currentTimeMillis();
        signMap.put("timestamp", timeStamp + ""); // 拼接参与sign时间戳
        signMap.put("channelId", "ali"); // 拼接参与sign下载渠道ID

        headers.put("timestamp", timeStamp + ""); // 拼接时间戳头信息
        headers.put("channelId", "ali"); // 分配给客户端的下载渠道ID
        headers.put("clientType", "CUSTOMER_ANDROID"); // 拼接客户端类型
        headers.put("appId", "59a2bcab4b6b11e7a4a5000b2f82eca7"); // 拼接APP_ID
        headers.put("ver", BuildConfig.VERSION_NAME); // app的版本名

        String token = NetCache.getToken();
        if (!TextUtils.isEmpty(token)) { // 拼接Token
            headers.put("Authorization", "common " + token);
        }

        Map<String, String> buildParams = getBodyParams();
        if (buildParams != null) {
            signMap.putAll(buildParams);//添加参数体，参与生成sign
        }

        String json = GsonUtil.toJsonFromMap(signMap);
        String sign = Sign.getSign(json);//生成sign
        headers.put("sign", sign);//将sign拼接到请求头中

        return headers;
    }
}
