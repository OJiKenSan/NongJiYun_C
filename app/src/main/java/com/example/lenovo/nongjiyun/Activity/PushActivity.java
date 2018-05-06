package com.example.lenovo.nongjiyun.Activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.example.lenovo.nongjiyun.R;
import com.example.lenovo.nongjiyun.Util.SharedPreferencesHelper;
import com.example.lenovo.nongjiyun.Util.ToastMessage;

public class PushActivity extends AppCompatActivity  {
    private Button btn_push_commit;
    private EditText et_push_context;
    private Button btn_push_locate;



    // 用来设置发起定位的模式和相关参数。


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_push);
        btn_push_commit = (Button) findViewById(R.id.btn_push_commit);
        et_push_context = (EditText) findViewById(R.id.et_push_context);
        btn_push_locate = (Button) findViewById(R.id.btn_push_locate);


        commit();

    }




    private void commit() {
        btn_push_commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (et_push_context.getText().length()==0){
                    ToastMessage.initToastMessage("内容不能为空",PushActivity.this);

                }else{
                    //在这里上传信息
                    ToastMessage.initToastMessage("提交成功",PushActivity.this);
                    Intent i=new Intent(PushActivity.this,MainActivity.class);
                    i.putExtra("changetag","4");
                    startActivity(i);
                }
            }
        });
    }



}
