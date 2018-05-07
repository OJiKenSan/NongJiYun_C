package com.example.lenovo.nongjiyun.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.lenovo.nongjiyun.R;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class WeahterActivity extends AppCompatActivity {
private ListView lv_main_weather;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weahter);
        lv_main_weather=(ListView)findViewById(R.id.lv_main_weather);
        OkHttpClient okHttpClient=new OkHttpClient();
        Request request=new Request.Builder().get().url("https://www.sojson.com/open/api/weather/json.shtml?city=北京").build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String responseStr = response.body().string();
                
            }
        });
    }
}
