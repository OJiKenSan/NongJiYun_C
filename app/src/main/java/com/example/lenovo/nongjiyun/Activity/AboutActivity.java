package com.example.lenovo.nongjiyun.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lenovo.nongjiyun.R;

public class AboutActivity extends AppCompatActivity {
private Button btn_about_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
         btn_about_back=(Button)findViewById(R.id.btn_about_back);
         back();
    }

    private void back() {
    btn_about_back.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            finish();
        }
    });
    }
}
