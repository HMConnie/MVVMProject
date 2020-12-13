package com.sgcai.mvvmproject.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Base64;

import com.sgcai.mvvmproject.AppContext;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import cn.connie.mvvm.base.BaseApplication;
import cn.connie.mvvm.utils.GsonUtil;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class BeautyUtils {

    private BeautyUtils() {

    }

    /**
     * 必须在子线程中执行
     *
     * @param beautyBean
     * @return
     * @throws IOException
     */
    public static File beautyFace(BeautyBean beautyBean) throws IOException {
        File srcFile = new File(beautyBean.imagePath);
        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("api_key", "pQi0-1aLIV5vJPxS-G3lvTFL-B3NfxoH")
                .addFormDataPart("api_secret", "dIvT_s-PxJoeBbw_yknAfHpzP0zHAgvy")
                .addFormDataPart("whitening", "" + beautyBean.whitening)//美白程度 取值范围 [0-100]
                .addFormDataPart("smoothing", "" + beautyBean.smoothing)//磨皮程度，取值范围 [0,100]
                .addFormDataPart("thinface", "" + beautyBean.thinface)//瘦脸程度，取值范围 [0,100]
                .addFormDataPart("enlarge_eye", "" + beautyBean.enlarge_eye)//大眼程度，取值范围 [0,100]
                .addFormDataPart("remove_eyebrow", "" + beautyBean.remove_eyebrow)//去眉毛程度，取值范围 [0,100]
                .addFormDataPart("image_file", srcFile.getName(), RequestBody.create(MediaType.parse("multipart/form-data"), srcFile))
                .build();
        Request request = new Request.Builder()
                .url("https://api-cn.faceplusplus.com/facepp/v2/beautify")
                .post(requestBody)
                .build();
        OkHttpClient client = new OkHttpClient();
        Response response = okHttpClient.newCall(request).execute();
        if (response.isSuccessful()) {
            String json = response.body().string();
            String image_base64 = GsonUtil.getString(json, "result");
            return saveImage(image_base64);
        } else {
            throw new IOException("美颜失败");
        }
    }


    public static File saveImage(String base64Image) {
        byte[] bitmapArray = Base64.decode(base64Image, Base64.DEFAULT);
        Bitmap bmp = BitmapFactory.decodeByteArray(bitmapArray, 0, bitmapArray.length);
        BaseApplication context = AppContext.getInstance();
        File appDir = new File(context.getFilesDir(), "beauty");
        if (!appDir.exists()) {
            appDir.mkdir();
        }
        String fileName = System.currentTimeMillis() + ".jpg";
        File file = new File(appDir, fileName);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }
}
