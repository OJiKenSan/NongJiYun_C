package com.example.lenovo.nongjiyun.Activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.nongjiyun.R;
import com.example.lenovo.nongjiyun.Util.SharedPreferencesHelper;
import com.example.lenovo.nongjiyun.Util.ToastMessage;
import com.makeramen.roundedimageview.RoundedImageView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EditProfileActivity extends AppCompatActivity {
private Button btn_editprofile_sex;
private TextView tv_editprofile_sex;
    private TextView tv_editprofile_eudcation;
    private TextView tv_editprofile_mail;
    private Button btn_editprofile_identity;
    private TextView tv_editprofile_identity;
    private TextView tv_editprofile_name;
private Button btn_editprofile_education;
    private Button btn_editprofile_mail;
    private TextView tv_editprofe_head;
    private Button btn_editprofile_name;
    private Button btn_editprofile_companyName;
    private TextView tv_editprofile_companyName;
    private View inflate;
    private TextView choosePhoto;
    private TextView takePhoto;
    private Dialog dialog;
    private RoundedImageView roundedImageView;
    private File appDir;
    private Uri uriForCamera;
    private Date date;
    private String str = "";
      public  static final int  TAKE_PHOTO_REQUEST=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        roundedImageView=(RoundedImageView)findViewById(R.id.img_editprofe_head);
         tv_editprofile_companyName=(TextView)findViewById(R.id.tv_editprofile_companyName);
        btn_editprofile_companyName=(Button)findViewById(R.id.btn_editprofile_companyName);
        btn_editprofile_sex=(Button)findViewById(R.id.btn_editprofile_sex);
        tv_editprofile_sex=(TextView)findViewById(R.id.tv_editprofile_sex);
        btn_editprofile_education=(Button)findViewById(R.id.btn_editprofile_education);
        btn_editprofile_mail=(Button)findViewById(R.id.btn_editprofile_email);
        tv_editprofile_name=(TextView)findViewById(R.id.tv_profile_name);
        btn_editprofile_name=(Button)findViewById(R.id.btn_profile_name);
        btn_editprofile_mail=(Button)findViewById(R.id.btn_editprofile_email);
        tv_editprofile_mail=(TextView)findViewById(R.id.tv_editprofile_email);
        tv_editprofile_eudcation=(TextView)findViewById(R.id.tv_editprofile_education);
        tv_editprofile_identity=(TextView)findViewById(R.id.tv_editprofile_identity);
        btn_editprofile_identity=(Button)findViewById(R.id.btn_editprofile_identity);
        tv_editprofe_head=(TextView)findViewById(R.id.tv_editprofe_head);

        Sex();
        education();
        name();
        mail();
        identity();
      companyName();
    }

    public  void head(View view) {

        Dialog dialog = new Dialog(this, R.style.ActionSheetDialogStyle);
        inflate = LayoutInflater.from(this).inflate(R.layout.bottom_dialog, null);
        takePhoto = (TextView) inflate.findViewById(R.id.tv_dialog_takephoto);
        takePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });
        dialog.setContentView(inflate);
        Window dialogWindow = dialog.getWindow();
        dialogWindow.setGravity( Gravity.BOTTOM);
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.y = 20;//设置Dialog距离底部的距离
//       将属性设置给窗体
        dialogWindow.setAttributes(lp);
        dialog.show();

    }




    private void companyName() {
        tv_editprofile_companyName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(EditProfileActivity.this,EditModelActivity.class);
                i.putExtra("tag","修改单位名称");
                startActivity(i);
            }
        });
        btn_editprofile_companyName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(EditProfileActivity.this,EditModelActivity.class);
                i.putExtra("tag","修改单位名称");
                startActivity(i);
            }
        });
    }

    private void identity() {
        btn_editprofile_identity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(EditProfileActivity.this,ChooseActivity.class);
                i.putExtra("titlename","选择类型");
                startActivity(i);
            }
        });
        tv_editprofile_identity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(EditProfileActivity.this,ChooseActivity.class);
                i.putExtra("titlename","选择类型");
                startActivity(i);
            }
        });
    }

    private void mail() {
        btn_editprofile_mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(EditProfileActivity.this,EditModelActivity.class);
                i.putExtra("tag","修改邮箱");
                startActivity(i);
            }
        });
        tv_editprofile_mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(EditProfileActivity.this,EditModelActivity.class);
                i.putExtra("tag","修改邮箱");
                startActivity(i);
            }
        });
    }

    private void name() {
        tv_editprofile_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(EditProfileActivity.this,EditModelActivity.class);
                i.putExtra("tag","修改用户名");
                startActivity(i);
            }
        });
        btn_editprofile_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(EditProfileActivity.this,EditModelActivity.class);
                i.putExtra("tag","修改用户名");
                startActivity(i);
            }
        });
    }

    private void education() {
        btn_editprofile_education.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(EditProfileActivity.this,EditModelActivity.class);
                i.putExtra("tag","修改学历");
                startActivity(i);
            }
        });
        tv_editprofile_eudcation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(EditProfileActivity.this,EditModelActivity.class);
                i.putExtra("tag","修改学历");
                startActivity(i);
            }
        });
    }

    private void Sex() {
        btn_editprofile_sex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               //这里修改
            }
        });
        tv_editprofile_sex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //这里修改
            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
      switch (requestCode){
          case TAKE_PHOTO_REQUEST:
              if (resultCode == RESULT_CANCELED) {
                  Toast.makeText(EditProfileActivity.this, "取消了拍照", Toast.LENGTH_LONG).show();
                  return;
              }
              Bitmap  photo = data.getParcelableExtra("data");
              roundedImageView.setImageBitmap(photo);

              break;
      }



    }

}
