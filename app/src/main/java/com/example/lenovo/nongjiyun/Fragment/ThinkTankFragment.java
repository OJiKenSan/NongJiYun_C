package com.example.lenovo.nongjiyun.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.nongjiyun.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ThinkTankFragment extends Fragment {


    public ThinkTankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_thinktank, container, false);
    }

}
