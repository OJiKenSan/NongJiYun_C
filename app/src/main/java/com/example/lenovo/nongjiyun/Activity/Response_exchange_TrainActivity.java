package com.example.lenovo.nongjiyun.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.lenovo.nongjiyun.R;

public class Response_exchange_TrainActivity extends AppCompatActivity {
private Button btn_r_e_t_back;
private TextView tv_r_e_t_title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_response_exchange__train);
             btn_r_e_t_back=(Button)findViewById(R.id.btn_r_e_t_back);
             tv_r_e_t_title=(TextView)findViewById(R.id.tv_r_e_t_title);
           title();
           back();
    }

    private void back() {
        btn_r_e_t_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void title() {
        Intent i=getIntent();
        String titlename=i.getStringExtra("titlename");
        tv_r_e_t_title.setText(titlename);
    }
}
