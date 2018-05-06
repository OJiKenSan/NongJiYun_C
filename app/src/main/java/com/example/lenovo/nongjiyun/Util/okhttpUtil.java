package com.example.lenovo.nongjiyun.Util;

import android.util.Log;
import android.view.View;

import com.example.lenovo.nongjiyun.Model.User;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class okhttpUtil {

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    OkHttpClient okHttpClient = new OkHttpClient();

    public void Get(String url, final Callback callback) throws IOException {
        //拿到对象

        //构造request
        Request.Builder builder = new Request.Builder();
        Request request = builder.get().url(url).build();
        //将request封装为call
        Call call = okHttpClient.newCall(request);
        //执行call
        //同步
        /* Response response= call.execute();*/
        //异步
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i("tag", e.getMessage());
                e.printStackTrace();

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.i("tag",response.body().string());
            }
        });
    }

    public void doPost(String url, Map<String, Object> map ) {
        FormBody.Builder formBody = new FormBody.Builder();
        if (null != map) {
            for (Map.Entry<String, Object> entity : map.entrySet()) {
                try {
                    String o = URLEncoder.encode(String.valueOf(entity.getValue()), "GBK");
                    formBody.add(entity.getKey(), o);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
            Request request = new Request.Builder()
                    .url(url)
                    .post(formBody.build())
                    .build();

          Call call=okHttpClient.newCall(request);
          call.enqueue(new Callback() {
              @Override
              public void onFailure(Call call, IOException e) {

              }

              @Override
              public void onResponse(Call call, Response response) throws IOException {

              }
          });
        }
    }

}


       /* Gson gson=new Gson();
        String json=gson.toJson(jsonObject);
        RequestBody body=FormBody.create(MediaType.parse("application/json; charset=utf-8"), json);

        Request request=new Request.Builder().url(url).post(body).build();*/
      /*  Call call=okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override okHttpClient.newCall(request).enqueue(callback);
            public void onFailure(Call call, IOException e) {
                System.out.println("连接失败");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

              */


