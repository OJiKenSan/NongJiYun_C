package com.example.lenovo.nongjiyun_c.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.lenovo.nongjiyun_c.Activity.Activity_login;
import com.example.lenovo.nongjiyun_c.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_mine extends Fragment {

private Button btn_mine_login;
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
        initlogin();
    }

    private void initlogin() {
        btn_mine_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), Activity_login.class);
                startActivity(intent);
            }
        });
    }

}
