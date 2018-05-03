package com.example.lenovo.nongjiyun.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.lenovo.nongjiyun.R;
import com.example.lenovo.nongjiyun.Util.ToastMessage;

public class Activity_resetpassword extends AppCompatActivity {
    private Button btn_phone_reset_password_next;
    private EditText et_phone_reset_input_password;
    private EditText et_phone_reset_commit_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resetpassword);
        btn_phone_reset_password_next=(Button)findViewById(R.id.btn_phone_reset_password_next);
        et_phone_reset_input_password=(EditText)findViewById(R.id.et_phone_reset_input_passsword);
        et_phone_reset_commit_password=(EditText)findViewById(R.id.et_phone_reset_commit_passsword);
        nextStep();
    }
    private void nextStep(){
        btn_phone_reset_password_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean tag= initFileter(et_phone_reset_input_password.getText().toString(),et_phone_reset_commit_password.getText().toString());
                if (tag=true){
                    ToastMessage.initToastMessage("重设密码成功",Activity_resetpassword.this);
                    Intent i=new Intent(Activity_resetpassword.this,Activity_login.class);
                    i.putExtra("tagnext",true);
                    startActivity(i);
                }
            }
        });
    }

    private Boolean initFileter(String password,String commitpassword) {
        if (password.length()==0){
            ToastMessage.initToastMessage("请输入密码",Activity_resetpassword.this);
        }else {
            if (password.equals(commitpassword)){
                return true;
            }else {
                ToastMessage.initToastMessage("密码不一致，请重新输入",Activity_resetpassword.this);
            }
        }


        return false;
    }
}
