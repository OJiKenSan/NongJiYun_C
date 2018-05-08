package com.example.lenovo.nongjiyun.Activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.lenovo.nongjiyun.Fragment.TabTwo1Fragment;
import com.example.lenovo.nongjiyun.Fragment.TabTwo2Fragment;
import com.example.lenovo.nongjiyun.R;

public class Tab_Concentrate_Demand_AskActivity extends AppCompatActivity {
private Button btn_c_d_a_back;
private TextView tv_c_d_a_title;
private TabTwo1Fragment tabTwo1Fragment;
private Button btn_c_d_a_left;
private Button btn_c_d_a_right;
    private TabTwo2Fragment tabTwo2Fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab__concentrate__demand__ask);
        tv_c_d_a_title=(TextView)findViewById(R.id.tv_c_d_a_title);
        btn_c_d_a_back=(Button)findViewById(R.id.btn_c_d_a_back);
        btn_c_d_a_right=(Button)findViewById(R.id.btn_tab_right);
        btn_c_d_a_left=(Button)findViewById(R.id.btn_tab_left);
        android.support.v4.app.FragmentManager fm=getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction ft=fm.beginTransaction();
        ft.add(R.id.fl_tab_c_d_a,new TabTwo1Fragment());
        ft.commit();
        btnset();
        back();
        title();
        tableft();
        tabright();
    }

    private void btnset() {
        Intent i=getIntent();
        String left=i.getStringExtra("left");
        String right=i.getStringExtra("right");
        btn_c_d_a_left.setText(left);
        btn_c_d_a_right.setText(right);
    }

    private void tabright() {
        btn_c_d_a_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragment(new TabTwo2Fragment());
            }
        });
    }

    private void tableft() {
        btn_c_d_a_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragment(new TabTwo1Fragment());
            }
        });
    }


    private void changeFragment(Fragment fragment) {
        android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fl_tab_c_d_a, fragment);
        ft.commit();

    }

    private void title() {
        Intent i=getIntent();
        String title=i.getStringExtra("titlename");
        tv_c_d_a_title.setText(title);
    }

    private void back() {
        btn_c_d_a_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
