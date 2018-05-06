package com.example.lenovo.nongjiyun.Activity;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.example.lenovo.nongjiyun.Fragment.ExchangeFragment;
import com.example.lenovo.nongjiyun.Fragment.HomeFragment;
import com.example.lenovo.nongjiyun.Fragment.MineFragment;
import com.example.lenovo.nongjiyun.Fragment.QuestionsFragment;
import com.example.lenovo.nongjiyun.Fragment.ThinkTankFragment;
import com.example.lenovo.nongjiyun.R;

public class MainActivity extends AppCompatActivity {
    private RadioGroup mNavigation;
    private HomeFragment homeFragment_;
    private ExchangeFragment exchangeFragment_;
    private MineFragment mineFragment_;
    private ThinkTankFragment thinkTankFragment_;
    private QuestionsFragment questionsFragment_;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      /*  getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);*/
        setContentView(R.layout.activity__main);
        android.support.v4.app.FragmentManager fm=getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction ft=fm.beginTransaction();
        ft.add(R.id.main_frame,new HomeFragment());
        ft.commit();
        //
        mNavigation = (RadioGroup) findViewById(R.id.rg_btn_navigation);
        mNavigation.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rb_bottom_navigation_home:
                        if (homeFragment_ == null) {
                            homeFragment_ = new HomeFragment();
                        }
                        changeFragment(homeFragment_);
                        break;
                    case R.id.rb_bottom_navigation_thinktank:
                        if (thinkTankFragment_ == null) {
                            thinkTankFragment_ = new ThinkTankFragment();
                        }
                        changeFragment(thinkTankFragment_);

                        break;
                    case R.id.rb_bottom_navigation_questions:
                        if (questionsFragment_ == null) {
                            questionsFragment_ = new QuestionsFragment();
                        }
                        changeFragment(questionsFragment_);
                        break;
                    case R.id.rb_bottom_navigation_exchange:
                        if (exchangeFragment_ == null) {
                            exchangeFragment_ = new ExchangeFragment();
                        }
                        changeFragment(exchangeFragment_);
                        break;
                    case R.id.rb_bottom_navigation_mine:
                        if (mineFragment_ == null) {
                            mineFragment_ = new MineFragment();
                        }
                        changeFragment(mineFragment_);
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
