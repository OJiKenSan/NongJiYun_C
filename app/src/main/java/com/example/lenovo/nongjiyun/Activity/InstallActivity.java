package com.example.lenovo.nongjiyun.Activity;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.nongjiyun.R;
import com.example.lenovo.nongjiyun.Util.CacheDataManager;
import com.example.lenovo.nongjiyun.Util.ToastMessage;

public class InstallActivity extends AppCompatActivity {
    private TextView tv_install_phone;
    private String[] perms = {Manifest.permission.CALL_PHONE};
    private final int PERMS_REQUEST_CODE = 200;
    private TextView tv_install_phones;
    private TextView tv_install_clear;
    private TextView tv_install_clears;
    private TextView tv_install_about;
    private TextView tv_install_about_us;
    private Button btn_install_back;
    private TextView tv_install_versons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_install);
        tv_install_phone = (TextView) findViewById(R.id.tv_install_phone);
        tv_install_phones = (TextView) findViewById(R.id.tv_install_phones);
        tv_install_clears=(TextView)findViewById(R.id.tv_install_clears);
        tv_install_clear=(TextView)findViewById(R.id.tv_install_clear);
       tv_install_about=(TextView)findViewById(R.id.tv_install_about);
       tv_install_about_us=(TextView)findViewById(R.id.tv_install_about_us);
       btn_install_back=(Button)findViewById(R.id.btn_install_back);

        try {
            clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
        phone();
        about();
        back();
        verson();
    }

    private void verson() {
        tv_install_versons=(TextView)findViewById(R.id.tv_install_verson);
        String i=getVersion();
        tv_install_versons.setText(String.valueOf(i));

      /*  if (2>i){
            ToastMessage.initToastMessage("需要更新",InstallActivity.this);
        }else {
            ToastMessage.initToastMessage("已是最新版本，无需更新",InstallActivity.this);
        }*/
    }

    private void back() {
        btn_install_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void about() {
                 tv_install_about.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View view) {
                         Intent i=new Intent(InstallActivity.this,AboutActivity.class);
                         startActivity(i);
                     }
                 });
                 tv_install_about_us.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View view) {
                         Intent i=new Intent(InstallActivity.this,AboutActivity.class);
                         startActivity(i);
                     }
                 });
    }

    private void clear() throws Exception {
       tv_install_clears.setText(CacheDataManager.getTotalCacheSize(this));
        tv_install_clears.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
alert();
            }
        });
        tv_install_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alert();
            }
        });

    }
    private void alert(){
        final AlertDialog.Builder clear=new AlertDialog.Builder(InstallActivity.this);
        clear.setTitle("");
        clear.setMessage("是否清空缓存");
        clear.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                new Thread(new clearCache()).start();
            }
        });
        clear.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
finish();
            }
        });
        clear.create().show();
    }
    class clearCache implements  Runnable{
        private Handler handler = new Handler() {

            public void handleMessage(android.os.Message msg) {

                switch (msg.what) {

                    case 0:

                      ToastMessage.initToastMessage("清理完成",InstallActivity.this);

                        try {

                            tv_install_clears.setText(CacheDataManager.getTotalCacheSize(InstallActivity.this));

                        } catch (Exception e) {

                            e.printStackTrace();

                        }

                }

            };

        };
        @Override
        public void run() {
            CacheDataManager.clearAllCache(InstallActivity.this);

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }

            try {
                if (CacheDataManager.getTotalCacheSize(InstallActivity.this).startsWith("0")) {

                    handler.sendEmptyMessage(0);

                }
            } catch (Exception e1) {
                e1.printStackTrace();
            }

        }
    }

    private void phone() {
        tv_install_phone.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {

                if (ContextCompat.checkSelfPermission(InstallActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(InstallActivity.this, new String[]{Manifest.permission.CALL_PHONE}, 1);
                } else {
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    Uri data = Uri.parse("tel:" + "86261287");
                    intent.setData(data);
                    InstallActivity.this.startActivity(intent);
                }

            }
        });
        tv_install_phones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ContextCompat.checkSelfPermission(InstallActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(InstallActivity.this, new String[]{Manifest.permission.CALL_PHONE}, 1);
                } else {
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    Uri data = Uri.parse("tel:" + "86261287");
                    intent.setData(data);
                    InstallActivity.this.startActivity(intent);
                }
            }
        });
    }


public String getVersion(){
        try{
            PackageManager manager=this.getPackageManager();
            PackageInfo info=manager.getPackageInfo(this.getPackageName(),0);

            return info.versionName;


        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";

        }
}

}

