package com.example.lenovo.nongjiyun.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.lenovo.nongjiyun.Model.User;
import com.example.lenovo.nongjiyun.R;
import com.example.lenovo.nongjiyun.Util.ToastMessage;

import org.json.JSONException;
import org.json.JSONObject;

public class ReistActivity extends AppCompatActivity {
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

    private void initFilter()  {
        if (et_phone_userreiste_name.length()!=0){
           if (et_phone_userreiste_password.length()!=0){
               if (et_phone_userreiste_password_again.getText().toString().equals(et_phone_userreiste_password.getText().toString())){
                   if (btn_phone_userreister_type.getText().toString()!="选择类型"){
                       if (btn_phone_userreister_place.getText().toString()!="请选择地址"){
                           //在这里保存数据！！！！！！！！！！！！！！！！！！！！！！！！！！！
                           try {
                               sendJson();
                           } catch (JSONException e) {
                               e.printStackTrace();
                           }
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

    private void sendJson() throws JSONException {
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("nickName",et_phone_userreiste_name.getText().toString());
        jsonObject.put("phone",et_phone_userreister_phone.getText().toString());
        jsonObject.put("password",et_phone_userreiste_password.getText().toString());
        jsonObject.put("address",btn_phone_userreister_place.getText().toString());
        jsonObject.put("identity",btn_phone_userreister_type.getText().toString());



        Intent i=new Intent(ReistActivity.this,LoginActivity.class);
        startActivity(i);
        ToastMessage.initToastMessage("注册成功",ReistActivity.this);
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
                Intent i=new Intent(ReistActivity.this,ChooseActivity.class);
                i.putExtra("titlename","选择类型");
                startActivityForResult(i,2000);
            }
        });
    }

    private void initplace() {
        btn_phone_userreister_place.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(ReistActivity.this,ChooseActivity.class);
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
