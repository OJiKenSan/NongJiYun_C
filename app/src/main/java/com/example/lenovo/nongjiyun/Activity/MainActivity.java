package com.example.lenovo.nongjiyun.Activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.RadioGroup;

import com.example.lenovo.nongjiyun.Fragment.Fragment_exchange;
import com.example.lenovo.nongjiyun.Fragment.Fragment_home;
import com.example.lenovo.nongjiyun.Fragment.Fragment_mine;
import com.example.lenovo.nongjiyun.Fragment.Fragment_questions;
import com.example.lenovo.nongjiyun.Fragment.Fragment_thinktank;
import com.example.lenovo.nongjiyun.R;

public class MainActivity extends AppCompatActivity {
    private RadioGroup mNavigation;
    private Fragment_home fragment_home;
    private Fragment_exchange fragment_exchange;
    private Fragment_mine fragment_mine;
    private Fragment_thinktank fragment_thinktank;
    private Fragment_questions fragment_questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      /*  getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);*/
        setContentView(R.layout.activity__main);
        android.support.v4.app.FragmentManager fm=getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction ft=fm.beginTransaction();
        ft.add(R.id.main_frame,new Fragment_home());
        ft.commit();
        mNavigation = (RadioGroup) findViewById(R.id.rg_btn_navigation);
        mNavigation.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rb_bottom_navigation_home:
                        if (fragment_home == null) {
                            fragment_home = new Fragment_home();
                        }
                        changeFragment(fragment_home);
                        break;
                    case R.id.rb_bottom_navigation_thinktank:
                        if (fragment_thinktank == null) {
                            fragment_thinktank = new Fragment_thinktank();
                        }
                        changeFragment(fragment_thinktank);

                        break;
                    case R.id.rb_bottom_navigation_questions:
                        if (fragment_questions == null) {
                            fragment_questions = new Fragment_questions();
                        }
                        changeFragment(fragment_questions);
                        break;
                    case R.id.rb_bottom_navigation_exchange:
                        if (fragment_exchange == null) {
                            fragment_exchange = new Fragment_exchange();
                        }
                        changeFragment(fragment_exchange);
                        break;
                    case R.id.rb_bottom_navigation_mine:
                        if (fragment_mine == null) {
                            fragment_mine = new Fragment_mine();
                        }
                        changeFragment(fragment_mine);
                        break;
                }
            }
        });
    }

    private void changeFragment(Fragment fragment) {
        android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.main_frame, fragment);
        ft.commit();
    }

}
