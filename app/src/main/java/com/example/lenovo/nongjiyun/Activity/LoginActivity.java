package com.example.lenovo.nongjiyun.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lenovo.nongjiyun.R;
import com.example.lenovo.nongjiyun.Util.Base64Utils;
import com.example.lenovo.nongjiyun.Util.SharedPreferencesHelper;
import com.example.lenovo.nongjiyun.Util.ToastMessage;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LoginActivity extends AppCompatActivity {
    private TextView mTv_statement;
    private Button btn_login_enter;
    private TextView tv_login_fp;
    private TextView tv_login_np;
    private Button btn_login_reister;
    private EditText et_login_phone;
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private EditText et_login_password;
    private Button btn_me_login_backarrow;
    private String URL = "http://47.106.155.38:8080/nongjiyun/user/login.action";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btn_login_enter = (Button) findViewById(R.id.btn_login_enter);
        et_login_password = (EditText) findViewById(R.id.et_login_password);
        et_login_phone = (EditText) findViewById(R.id.et_login_phone);
        btn_me_login_backarrow = (Button) findViewById(R.id.btn_me_login_backarrow);
        btn_login_reister = (Button) findViewById(R.id.btn_login_reister);
        tv_login_fp = (TextView) findViewById(R.id.tv_login_fp);

        enterClick();
        backClick();
        forgetPassword();
        reister();

    }


    private void reister() {
        btn_login_reister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this, ValidateActivity.class);
                i.putExtra("tag", "注册");
                startActivity(i);
            }
        });
    }

    private void forgetPassword() {
        tv_login_fp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this, ValidateActivity.class);
                i.putExtra("tag", "忘记密码");
                startActivity(i);
            }
        });
        //}
    }

    private void backClick() {
        btn_me_login_backarrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    private void enterClick() {
        btn_login_enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (et_login_phone.length() != 0) {
                    if (et_login_password.length() != 0) {
                        if (et_login_password.length() < 6 | et_login_password.length() > 20) {
                            ToastMessage.initToastMessage("请输入6~20位密码", LoginActivity.this);
                        } else {

                            JsonObject jsonObject = new JsonObject();
                            jsonObject.addProperty("phone", et_login_phone.getText().toString());
                            jsonObject.addProperty("password", et_login_password.getText().toString());

                            JsonObject jsonObject1 = new JsonObject();
                            jsonObject1.add("requestBody", jsonObject);
                            String jo = jsonObject1.toString();
                            System.out.print(jsonObject1);

                            OkHttpClient okHttpClient = new OkHttpClient();
                            RequestBody requestBody = RequestBody.create(JSON, jo);
                            Request request = new Request.Builder().url(URL).post(requestBody).build();
                            Call call = okHttpClient.newCall(request);
                            call.enqueue(new Callback() {
                                @Override
                                public void onFailure(Call call, IOException e) {

                                }

                                @Override
                                public void onResponse(Call call, Response response) throws IOException {
                                    String s = response.body().string();
                                    String d = Base64Utils.decode(s);
                                    Log.i("tag", d);
                                    try {
                                        JSONObject jsonObject2 = new JSONObject(d);
                                        String responseBody = jsonObject2.getString("responseBody");
                                        JSONObject jsonObject3 = new JSONObject(responseBody);
                                        String data = jsonObject3.getString("data");
                                        JSONObject jsonObject4 = new JSONObject(data);
                                        String address = jsonObject4.optString("address");
                                        String phone = jsonObject4.optString("phone");
                                        String townCode = jsonObject4.optString("townCode");
                                        String nickName = jsonObject4.optString("nickName");
                                        String cityCode = jsonObject4.optString("cityCode");
                                        int identity = jsonObject4.optInt("identity");
                                        int sex = jsonObject4.optInt("sex");
                                        String streetCode = jsonObject4.optString("streetCode");
                                        String avatar = jsonObject4.optString("avatar");
                                        String userId = jsonObject4.optString("userId");
                                        int isComplete = jsonObject4.optInt("isComplete");
                                        SharedPreferencesHelper sharedPreferencesHelper = new SharedPreferencesHelper(LoginActivity.this);
                                        sharedPreferencesHelper.put("address",address);
                                        sharedPreferencesHelper.put("phone",phone);
                                        sharedPreferencesHelper.put("townCode",townCode);
                                        sharedPreferencesHelper.put("nickName",nickName);
                                        sharedPreferencesHelper.put("cityCode",cityCode);
                                        sharedPreferencesHelper.put("identity",identity);
                                        sharedPreferencesHelper.put("sex",sex);
                                        sharedPreferencesHelper.put("streetCode",streetCode);
                                        sharedPreferencesHelper.put("avatar",avatar);
                                        sharedPreferencesHelper.put("userId",userId);
                                        sharedPreferencesHelper.put("isComplete",isComplete);

                                        Intent i=new Intent(LoginActivity.this,MainActivity.class);
                                        i.putExtra("minetag",1);
                                        startActivity(i);

                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }


                                }
                            });




                          /*  SharedPreferencesHelper sharedPreferencesHelper = new SharedPreferencesHelper(LoginActivity.this);
                            sharedPreferencesHelper.put("phonenum", et_login_phone);
                         */
                            ToastMessage.initToastMessage("模拟登录成功", LoginActivity.this);
                        /*    OkHttpClient okHttpClient = new OkHttpClient();
                            Request request = new Request.Builder().get().url(URL).build();
                            Call call = okHttpClient.newCall(request);
                                       call.enqueue(new Callback() {
                                           @Override
                                           public void onFailure(Call call, IOException e) {

                                           }

                                           @Override
                                           public void onResponse(Call call, Response response) throws IOException {

                                           }
                                       });*/
                        }
                    } else {
                        ToastMessage.initToastMessage("请填写密码", LoginActivity.this);
                    }
                } else {
                    ToastMessage.initToastMessage("请填写手机号", LoginActivity.this);
                }
                       /*else if (et_login_password==null){
                       initToastMessage("请填写密码");
                   }*/


            }
        });
    }
}
