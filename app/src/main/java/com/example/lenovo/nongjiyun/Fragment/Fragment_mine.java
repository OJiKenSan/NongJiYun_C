package com.example.lenovo.nongjiyun.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.lenovo.nongjiyun.Activity.LoginActivity;
import com.example.lenovo.nongjiyun.Activity.ResponseActivity;
import com.example.lenovo.nongjiyun.R;
import com.example.lenovo.nongjiyun.Util.ToastMessage;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_mine extends Fragment {
private TextView tv_mine_mall;
private Button btn_mine_login;
private RadioButton rb_mine_share;
private RadioButton rb_mine_response;
    public Fragment_mine() {
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
        rb_mine_response=(RadioButton)view.findViewById(R.id.rb_mine_response);
        initlogin();
        initmall();
        initresponse();
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
