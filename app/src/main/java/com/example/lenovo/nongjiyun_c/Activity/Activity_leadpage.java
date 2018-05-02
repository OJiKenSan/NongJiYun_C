package com.example.lenovo.nongjiyun_c.Activity;

import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.example.lenovo.nongjiyun_c.R;

public class Activity_leadpage extends AppCompatActivity {
private ViewPager vp_welcome_guide;
private Button btn_welcome_visi;
private int imags[]={R.drawable.ic_guide_01,R.drawable.ic_guide_02,R.drawable.ic_guide_03};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      /*  getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);*/
        setContentView(R.layout.activity_leadpage);
        btn_welcome_visi=(Button)findViewById(R.id.btn_welcome_visi);
        vp_welcome_guide=(ViewPager)findViewById(R.id.vp_welcome_guide);
        initadapter();
        initClick();
    }

    private void initadapter() {
        vp_welcome_guide.setAdapter(new PagerAdapter());
        vp_welcome_guide.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                   if (position==2){
                       btn_welcome_visi.setVisibility(View.VISIBLE);

                   }else {
                       btn_welcome_visi.setVisibility(View.GONE);
                   }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initClick() {
        btn_welcome_visi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                   startActivity(new Intent(Activity_leadpage.this,Activity_Main.class));
                   finish();
            }
        });
    }
    private  class PagerAdapter extends android.support.v4.view.PagerAdapter{
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView mImageView=new ImageView(getBaseContext());
            mImageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT));
            mImageView.setBackgroundResource(imags[position]);
            container.addView(mImageView);

            return mImageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
        }

        @Override
        public int getCount() {
            return imags.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }
    }
}
