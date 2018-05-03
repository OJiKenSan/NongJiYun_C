package com.example.lenovo.nongjiyun.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.lenovo.nongjiyun.Util.ToastMessage;
import com.example.lenovo.nongjiyun.R;


public class ResponseActivity extends AppCompatActivity {
private Button btn_share_back;
private Button btn_share_commit;
private EditText et_share_input;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_response);
        btn_share_back=(Button)findViewById(R.id.btn_share_back);
        btn_share_commit=(Button)findViewById(R.id.btn_share_commit);
        et_share_input=(EditText)findViewById(R.id.et_share_input);
        back();
        commit();
    }

    private void commit() {
        btn_share_commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (et_share_input.getText().toString().equals("")){
                    ToastMessage.initToastMessage("请填写内容",ResponseActivity.this);
                }else {
                    //成功后执行的东西

                    ToastMessage.initToastMessage("提交成功",ResponseActivity.this);
                    finish();
                }
            }
        });
    }

    private void back() {
        btn_share_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
