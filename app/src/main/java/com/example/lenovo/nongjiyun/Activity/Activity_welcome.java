package com.example.lenovo.nongjiyun.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.lenovo.nongjiyun.R;

public class Activity_welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       /* getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);*/
        setContentView(R.layout.activity_welcome);

//1
     handler.sendEmptyMessageDelayed(0,3000);
    }
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            SharedPreferences sharedPreferences=getSharedPreferences("share",MODE_PRIVATE);
            boolean isFirstRun=sharedPreferences.getBoolean("isFirstRun",true);
            SharedPreferences.Editor editor =sharedPreferences.edit();
            if (isFirstRun){
                editor.putBoolean("isFirstRun",false);
                editor.commit();
                Intent i=new Intent(Activity_welcome.this,Activity_leadpage.class);
                startActivity(i);
                finish();
            }else{
                Intent intent = new Intent(Activity_welcome.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }
    };

/*
    public boolean isFirstStart(Context context){
        SharedPreferences preferences=context.getSharedPreferences("STag",0);
        Boolean isFirst=preferences.getBoolean("FIRSTStar",true);
        if (isFirst){
                 Intent i=new Intent(Activity_welcome.this,Activity_leadpage.class);
                 startActivity(i);
                 finish();
            return true;
        }else{
            Intent intent = new Intent(Activity_welcome.this, MainActivity.class);
            startActivity(intent);
            finish();
            return false;
        }
    }*/

}

