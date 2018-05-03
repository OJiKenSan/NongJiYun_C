package com.example.lenovo.nongjiyun.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lenovo.nongjiyun.R;
import com.example.lenovo.nongjiyun.Util.SharedPreferencesHelper;
import com.example.lenovo.nongjiyun.Util.ToastMessage;

public class LoginActivity extends AppCompatActivity {
    private TextView mTv_statement;
    private Button btn_login_enter;
    private TextView tv_login_fp;
    private TextView tv_login_np;
    private Button btn_login_reister;
    private EditText et_login_phone;
    private EditText et_login_password;
    private Button btn_me_login_backarrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btn_login_enter = (Button) findViewById(R.id.btn_login_enter);
        et_login_password = (EditText) findViewById(R.id.et_login_password);
        et_login_phone = (EditText) findViewById(R.id.et_login_phone);
        btn_me_login_backarrow = (Button) findViewById(R.id.btn_me_login_backarrow);
        btn_login_reister=(Button)findViewById(R.id.btn_login_reister);
        tv_login_fp=(TextView)findViewById(R.id.tv_login_fp);

        enterClick();
        backClick();
        forgetPassword();
        reister();

    }



    private void reister() {
        btn_login_reister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(LoginActivity.this,ValidateActivity.class);
                i.putExtra("tag","注册");
                startActivity(i);
            }
        });
    }

    private void forgetPassword(){
        tv_login_fp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(LoginActivity.this,ValidateActivity.class);
                i.putExtra("tag","忘记密码");
                startActivity(i);
            }
        });
    }

    private void backClick(){
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
                            ToastMessage.initToastMessage("请输入6~20位密码",LoginActivity.this);
                        } else {
                            SharedPreferencesHelper sharedPreferencesHelper=new SharedPreferencesHelper(LoginActivity.this);
                            sharedPreferencesHelper.put("phonenum",et_login_phone);
                            ToastMessage.initToastMessage("模拟登录成功",LoginActivity.this);
                        }
                    } else {
                        ToastMessage.initToastMessage("请填写密码",LoginActivity.this);
                    }
                } else {
                    ToastMessage.initToastMessage("请填写手机号",LoginActivity.this);
                }
                       /*else if (et_login_password==null){
                       initToastMessage("请填写密码");
                   }*/


            }
        });
    }
}
