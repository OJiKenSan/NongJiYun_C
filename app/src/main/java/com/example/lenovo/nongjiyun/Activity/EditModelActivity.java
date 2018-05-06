package com.example.lenovo.nongjiyun.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.lenovo.nongjiyun.R;

public class EditModelActivity extends AppCompatActivity {
private Button btn_edit_model_back;
private TextView tv_editmodel_titile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_model);
        btn_edit_model_back=(Button)findViewById(R.id.btn_edit_model_back);
        tv_editmodel_titile=(TextView)findViewById(R.id.tv_edit_model_title);
        Intent i=getIntent();
        String tag=i.getExtras().getString("tag");
        tv_editmodel_titile.setText(tag);
        back();

    }

    private void back() {
        btn_edit_model_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
