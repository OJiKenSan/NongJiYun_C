package com.example.lenovo.nongjiyun_c.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.lenovo.nongjiyun_c.R;

public class Activity_reist extends AppCompatActivity {
    private Button btn_phone_reist_back;
    private Button btn_phone_userreister_place;
    private Button btn_phone_userreister_type;
    private EditText et_phone_userreister_phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reist);
        btn_phone_reist_back=(Button)findViewById(R.id.btn_phone_reist_back);
        btn_phone_userreister_place=(Button)findViewById(R.id.btn_phone_userreister_place);
        btn_phone_userreister_type=(Button)findViewById(R.id.btn_phone_userreister_type);
        et_phone_userreister_phone=(EditText)findViewById(R.id.et_phone_userreister_phone);
        /*initgetIntent();*/
        initplace();
        back();
        inittype();
        initgetIntent();
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
