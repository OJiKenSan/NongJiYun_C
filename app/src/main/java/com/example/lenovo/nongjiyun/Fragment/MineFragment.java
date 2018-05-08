package com.example.lenovo.nongjiyun.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.lenovo.nongjiyun.Activity.AboutActivity;
import com.example.lenovo.nongjiyun.Activity.InstallActivity;
import com.example.lenovo.nongjiyun.Activity.LoginActivity;
import com.example.lenovo.nongjiyun.Activity.QrCodeActivity;
import com.example.lenovo.nongjiyun.Activity.ResponseActivity;
import com.example.lenovo.nongjiyun.Activity.Response_exchange_TrainActivity;
import com.example.lenovo.nongjiyun.Activity.ShareActivity;
import com.example.lenovo.nongjiyun.Activity.Tab_Concentrate_Demand_AskActivity;
import com.example.lenovo.nongjiyun.R;
import com.example.lenovo.nongjiyun.Util.SharedPreferencesHelper;
import com.example.lenovo.nongjiyun.Util.ToastMessage;

/**
 * A simple {@link Fragment} subclass.
 */
public class MineFragment extends Fragment {
private TextView tv_mine_mall;
private Button btn_mine_login;
private RadioButton rb_mine_share;
private RadioButton rb_mine_response;
private RadioButton rb_mine_install;
private TextView tv_mine_sign;
    private TextView tv_mine_score;
private int TAG=1;
private RadioButton rb_mine_qrcode;
private RadioButton rb_mine_ask;
private RadioButton rb_mine_collect;
private RadioButton rb_mine_train;
private RadioButton rb_mine_exchange;
private RadioButton rb_mine_concentrate;
private RadioButton rb_mine_demand;
    private RadioButton rb_mine_answer;
    public MineFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mine, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btn_mine_login=(Button)view.findViewById(R.id.btn_mine_login);
         tv_mine_mall=(TextView)view.findViewById(R.id.tv_mine_mall);
         rb_mine_install=(RadioButton)view.findViewById(R.id.rb_mine_install);
        rb_mine_response=(RadioButton)view.findViewById(R.id.rb_mine_response);
        rb_mine_share=(RadioButton)view.findViewById(R.id.rb_mine_share);
        rb_mine_answer=(RadioButton)view.findViewById(R.id.rb_mine_answer);
        rb_mine_ask=(RadioButton)view.findViewById(R.id.rb_mine_ask);
        rb_mine_collect=(RadioButton)view.findViewById(R.id.rd_mine_collect);
        rb_mine_answer=(RadioButton)view.findViewById(R.id.rb_mine_answer);
        rb_mine_qrcode=(RadioButton)view.findViewById(R.id.rb_mine_qrcode);
        tv_mine_score=(TextView)view.findViewById(R.id.tv_mine_score);
        rb_mine_exchange=(RadioButton)view.findViewById(R.id.rb_mine_exchange);
        tv_mine_sign=(TextView)view.findViewById(R.id.tv_mine_sign);
        rb_mine_train=(RadioButton)view.findViewById(R.id.rb_mine_train);
        rb_mine_concentrate=(RadioButton)view.findViewById(R.id.rb_mine_concentrate);
        rb_mine_demand=(RadioButton)view.findViewById(R.id.rb_mine_demand);
train();
demand();
        exits();
        answer();
        qrcode();
        concentrate();
        initinstall();
        initlogin();
        initmall();
        initresponse();
        initshare();
        ask();
        collect();
         exchange();
    }

    private void demand() {
        rb_mine_demand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferencesHelper sharedPreferencesHelper=new SharedPreferencesHelper(getActivity());
                if (sharedPreferencesHelper.contain("userId")){
                    Intent i=new Intent(getActivity(),Tab_Concentrate_Demand_AskActivity.class);
                    i.putExtra("titlename","我的供求");
                    i.putExtra("left","供应");
                    i.putExtra("right","求购");
                    startActivity(i);


                }else {
                    Intent i=new Intent(getActivity(),LoginActivity.class);
                    startActivity(i);
                }
            }
        });
    }

    private void concentrate() {
rb_mine_concentrate.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        SharedPreferencesHelper sharedPreferencesHelper=new SharedPreferencesHelper(getActivity());
        if (sharedPreferencesHelper.contain("userId")){

            Intent i=new Intent(getActivity(),Tab_Concentrate_Demand_AskActivity.class);
            i.putExtra("titlename","我的关注");
            i.putExtra("left","快速提问");
            i.putExtra("right","专家提问");
            startActivity(i);


        }else {
            Intent i=new Intent(getActivity(),LoginActivity.class);
            startActivity(i);
        }
    }
});
    }

    private void exchange() {
        rb_mine_exchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferencesHelper sharedPreferencesHelper=new SharedPreferencesHelper(getActivity());
                if (sharedPreferencesHelper.contain("userId")){

                    Intent i=new Intent(getActivity(),Response_exchange_TrainActivity.class);
                    i.putExtra("titlename","我的交流");
                    startActivity(i);

                }else {
                    Intent i=new Intent(getActivity(),LoginActivity.class);
                    startActivity(i);
                }
            }
        });
    }

    private void train() {
        rb_mine_train.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferencesHelper sharedPreferencesHelper=new SharedPreferencesHelper(getActivity());
                if (sharedPreferencesHelper.contain("userId")){

                    Intent i=new Intent(getActivity(),Response_exchange_TrainActivity.class);
                    i.putExtra("titlename","我的培训班");
                    startActivity(i);

                }else {
                    Intent i=new Intent(getActivity(),LoginActivity.class);
                    startActivity(i);
                }
            }
        });
    }

    private void collect() {
           rb_mine_collect.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   if (TAG==1){
                       Intent i=new Intent(getActivity(),LoginActivity.class);
                       startActivity(i);
                   }
               }
           });
    }

    private void ask(){
        rb_mine_ask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferencesHelper sharedPreferencesHelper=new SharedPreferencesHelper(getActivity());
                if (sharedPreferencesHelper.contain("userId")){

                    Intent i=new Intent(getActivity(),Tab_Concentrate_Demand_AskActivity.class);
                    i.putExtra("titlename","我的提问");
                    i.putExtra("left","快速提问");
                    i.putExtra("right","专家提问");
                    startActivity(i);


                }else {
                    Intent i=new Intent(getActivity(),LoginActivity.class);
                    startActivity(i);
                }
            }
        });

    }

    private void answer() {

        rb_mine_answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferencesHelper sharedPreferencesHelper=new SharedPreferencesHelper(getActivity());
                if (sharedPreferencesHelper.contain("userId")){

                    Intent i=new Intent(getActivity(),Response_exchange_TrainActivity.class);
                    i.putExtra("titlename","我的回答");
                    startActivity(i);

                }else {
                    Intent i=new Intent(getActivity(),LoginActivity.class);
                    startActivity(i);
                }
            }
        });

    }

    private void qrcode() {
        rb_mine_qrcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferencesHelper sharedPreferencesHelper=new SharedPreferencesHelper(getActivity());
                if (sharedPreferencesHelper.contain("userId")){
                    String userId= (String) sharedPreferencesHelper.get("userId","1");
                    Intent i=new Intent(getActivity(),QrCodeActivity.class);
                    i.putExtra("userId",userId);
                    startActivity(i);
                }else {
                    Intent i=new Intent(getActivity(),LoginActivity.class);
                    startActivity(i);
                }
            }
        });

    }

    private void exits() {
        SharedPreferencesHelper sharedPreferencesHelper=new SharedPreferencesHelper(getActivity());
        if (sharedPreferencesHelper.contain("userId")){
            tv_mine_sign.setText("连续登录"+3+"天");
            tv_mine_score.setText(2+"积分");
        }
    }

    private void initshare() {
        rb_mine_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent i=new Intent(getActivity(), ShareActivity.class);
                    startActivity(i);


            }
        });

    }

    private void initinstall() {
        rb_mine_install.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getActivity(), InstallActivity.class);
                startActivity(i);
            }
        });
    }

    private void initresponse() {
        rb_mine_response.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getActivity(),ResponseActivity.class);
               startActivity(i);
            }
        });
    }

    private void initmall() {
        tv_mine_mall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToastMessage.initToastMessage("正在开发中.....",getActivity());
            }
        });
    }

    private void initlogin() {
        btn_mine_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }

}
