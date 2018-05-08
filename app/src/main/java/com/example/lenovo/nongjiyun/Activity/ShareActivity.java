package com.example.lenovo.nongjiyun.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lenovo.nongjiyun.R;

public class ShareActivity extends AppCompatActivity {
private Button btn_share_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        btn_share_back=(Button)findViewById(R.id.btn_share_back);
        back();
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
