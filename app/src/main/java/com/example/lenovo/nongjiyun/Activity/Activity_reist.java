package com.example.lenovo.nongjiyun.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lenovo.nongjiyun.R;
import com.example.lenovo.nongjiyun.Util.ToastMessage;

public class Activity_reist extends AppCompatActivity {
    private Button btn_phone_reist_back;
    private Button btn_phone_userreister_place;
    private Button btn_phone_userreister_type;
    private EditText et_phone_userreister_phone;
    private EditText et_phone_userreiste_name;
    private EditText et_phone_userreiste_password;
    private EditText et_phone_userreiste_password_again;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reist);
        btn_phone_reist_back=(Button)findViewById(R.id.btn_phone_reist_back);
        btn_phone_userreister_place=(Button)findViewById(R.id.btn_phone_userreister_place);
        btn_phone_userreister_type=(Button)findViewById(R.id.btn_phone_userreister_type);
        et_phone_userreister_phone=(EditText)findViewById(R.id.et_phone_userreister_phone);
        et_phone_userreiste_name=(EditText)findViewById(R.id.et_phone_userreiste_name);
        et_phone_userreiste_password=(EditText)findViewById(R.id.et_phone_userreiste_password);
        et_phone_userreiste_password_again=(EditText)findViewById(R.id.et_phone_userreiste_password_again);
        /*initgetIntent();*/

        initplace();
        back();
        inittype();
        initgetIntent();
        initFilter();
    }

    private void initFilter() {
        if (et_phone_userreiste_name.length()!=0){
           if (et_phone_userreiste_password.length()!=0){
               if (et_phone_userreiste_password_again.getText().toString().equals(et_phone_userreiste_password.getText().toString())){
                   if (btn_phone_userreister_type.getText().toString()!="选择类型"){
                       if (btn_phone_userreister_place.getText().toString()!="请选择地址"){
                           //在这里保存数据！！！！！！！！！！！！！！！！！！！！！！！！！！！
                           Intent i=new Intent(Activity_reist.this,Activity_login.class);
                           startActivity(i);
                       }else {
                           ToastMessage.initToastMessage("请选择地址",this);
                       }
                   }else{
                       ToastMessage.initToastMessage("请选择人员类别",this);
                   }
               }else {
                   ToastMessage.initToastMessage("两次密码不一致",this);
               }
           }else {
               ToastMessage.initToastMessage("请输入密码",this);
           }
        }else{
            ToastMessage.initToastMessage("请填写姓名",this);
        }
    }

    private void initgetIntent() {
String phonenum="手机号码";
        if (getIntent().hasExtra("phonenum")){
            Intent i=getIntent();
            phonenum=i.getExtras().getString("phonenum");

        }
        et_phone_userreister_phone.setText(phonenum);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==2000&&resultCode==2001){
            btn_phone_userreister_type.setText(data.getStringExtra("typename"));
        }
        if(requestCode==1000&&resultCode==1001){
            btn_phone_userreister_place.setText(data.getStringExtra("placename"));
        }
    }

    private void inittype() {
        btn_phone_userreister_type.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Activity_reist.this,Activity_choose.class);
                i.putExtra("titlename","选择类型");
                startActivityForResult(i,2000);
            }
        });
    }

    private void initplace() {
        btn_phone_userreister_place.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Activity_reist.this,Activity_choose.class);
                i.putExtra("titlename","选择城市");
                startActivityForResult(i,1000);
            }
        });
    }

    private void back() {
        btn_phone_reist_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
