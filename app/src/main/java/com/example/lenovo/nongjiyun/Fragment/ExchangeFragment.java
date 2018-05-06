package com.example.lenovo.nongjiyun.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.lenovo.nongjiyun.Activity.PushActivity;
import com.example.lenovo.nongjiyun.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExchangeFragment extends Fragment {
private Button btn_exchange_push;

    public ExchangeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_exchange, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btn_exchange_push=(Button)view.findViewById(R.id.btn_exchange_push);
        push();
    }

    private void push() {
        btn_exchange_push.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getActivity(), PushActivity.class);

                startActivity(i);

            }
        });
    }


}
