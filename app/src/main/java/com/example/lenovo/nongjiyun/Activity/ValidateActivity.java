package com.example.lenovo.nongjiyun.Activity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lenovo.nongjiyun.R;
import com.example.lenovo.nongjiyun.Util.ToastMessage;

import cn.bmob.sms.BmobSMS;
import cn.bmob.sms.exception.BmobException;
import cn.bmob.sms.listener.RequestSMSCodeListener;
import cn.bmob.sms.listener.VerifySMSCodeListener;

public class ValidateActivity extends AppCompatActivity implements ActivityCompat.OnRequestPermissionsResultCallback {

    private TextView tv_phone_validate_title;
    private Button btn_phone_validate_back;
    private Button btn_phone_validate_getCode;
    private Button btn_phone_validate_next;
    private EditText et_phone_validate_phonenum;
    private EditText et_phone_validate_code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validate);


        BmobSMS.initialize(this, "3c1ca83ea1478120736f22b2ac49cbd0");
        tv_phone_validate_title = (TextView) findViewById(R.id.tv_phne_validate_title);
        btn_phone_validate_back = (Button) findViewById(R.id.btn_phone_validate_back);
        btn_phone_validate_getCode = (Button) findViewById(R.id.btn_phone_validate_getCode);
        et_phone_validate_phonenum = (EditText) findViewById(R.id.et_phone_validate_phonenum);
        et_phone_validate_code = (EditText) findViewById(R.id.et_phone_validate_code);
        initTextSelector();
        back();
        requestReadPhonePermission();
        validateMessage();
    }

    private void validateMessage() {
        btn_phone_validate_next = (Button) findViewById(R.id.btn_phone_validate_next);
        btn_phone_validate_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (et_phone_validate_code.length() == 6) {
                    validateCode(et_phone_validate_phonenum.getText().toString(),
                            et_phone_validate_code.getText().toString(), ValidateActivity.this);

                } else {
                    ToastMessage.initToastMessage("请输入正确的验证码", ValidateActivity.this);
                }
            }
        });
    }

    private void validateCode(final String phonenum, String code, final Context context) {
        BmobSMS.verifySmsCode(context, phonenum, code, new VerifySMSCodeListener() {


            @Override
            public void done(BmobException e) {
                if (e == null) {
                    Intent i = getIntent();
                    String str = i.getStringExtra("tag");
                    if (str.equals("注册")) {
                        i = new Intent(ValidateActivity.this, ReistActivity.class);
                        i.putExtra("phonenum", phonenum);
                        startActivity(i);
                    } else {
                        i = new Intent(ValidateActivity.this, ResetPasswordActivity.class);
                        i.putExtra("phonenum", phonenum);
                        startActivity(i);
                    }


                } else {
                    Log.e("TAG", e.toString());
                    ToastMessage.initToastMessage("验证失败", context);
                }
            }
        });
    }


    private void requestReadPhonePermission() {
        if (ContextCompat.checkSelfPermission(ValidateActivity.this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(ValidateActivity.this, new String[]{Manifest.permission.SEND_SMS}, 1);
        } else {
            getMessage();
        }
    }


    private void getMessage() {
        btn_phone_validate_getCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (et_phone_validate_phonenum.length() == 0) {
                    ToastMessage.initToastMessage("请输入手机号", ValidateActivity.this);
                } else if (et_phone_validate_phonenum.length() < 11 && et_phone_validate_phonenum.length() > 0) {
                    ToastMessage.initToastMessage("请输入正确手机格式", ValidateActivity.this);
                } else {
                    sendMessage(et_phone_validate_phonenum.getText().toString());
                }
            }
        });
    }


    private void sendMessage(String phonenum) {
        BmobSMS.requestSMSCode(this, phonenum, "农技耘", new RequestSMSCodeListener() {
            @Override
            public void done(Integer integer, BmobException e) {
                if (e == null) {//验证码发送成功
                    Log.i("bmob", "短信id：" + integer);//用于查询本次短信发送详情
                    ToastMessage.initToastMessage("信息已发送，请注意查收", ValidateActivity.this);
                    btn_phone_validate_getCode.setClickable(false);
                    btn_phone_validate_getCode.setBackgroundColor(Color.GRAY);
                    new CountDownTimer(60000, 1000) {

                        @Override
                        public void onTick(long l) {
                            btn_phone_validate_getCode.setText(l / 1000 + "秒");
                        }

                        @Override
                        public void onFinish() {
                            btn_phone_validate_getCode.setClickable(true);
                            btn_phone_validate_getCode.setBackgroundResource(R.drawable.btn_enter_rectangle);
                            btn_phone_validate_getCode.setText("重新发送");
                        }
                    }.start();

                }
            }
        });
    }

    private void back() {
        btn_phone_validate_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    private void initTextSelector() {
        Intent i = getIntent();
        String str = i.getStringExtra("tag");
        if (str.isEmpty()) {
            tv_phone_validate_title.setText("注册");
        } else {
            tv_phone_validate_title.setText(str);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 1:
                if ((grantResults.length > 0) && (grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    getMessage();
                    //TODO
                } else {
                    ToastMessage
                            .initToastMessage("你没启动权限", ValidateActivity.this);
                }
                break;

            default:
                break;
        }
    }
}
