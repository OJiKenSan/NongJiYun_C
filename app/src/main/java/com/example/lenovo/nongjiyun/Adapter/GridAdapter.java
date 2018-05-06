package com.example.lenovo.nongjiyun.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;


import com.example.lenovo.nongjiyun.Model.HomeMenu;

import java.util.List;

/**
 * Created by CAI on 2018/4/27.
 */

public class GridAdapter extends BaseAdapter {
    // 获取数据
    private Context context;
    private List<HomeMenu> menus;

    public GridAdapter(Context context, List<HomeMenu> menus) {
        this.context = context;
        this.menus = menus;
    }

    @Override
    public int getCount() {
        return 9;
    }

    @Override
    public Object getItem(int position) {
        return menus.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        RadioButton rb = new RadioButton(context);
        HomeMenu homeMenu = menus.get(position);
        if (position == 8) {
            rb.setText(homeMenu.getName());
            rb.setButtonDrawable(null);
            rb.setBackgroundColor(Color.WHITE);
            rb.setCompoundDrawablesWithIntrinsicBounds(0, menus.get(position).getImage(), 0, 0);
            rb.setGravity(Gravity.CENTER);
            rb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        } else {
            rb.setText(homeMenu.getName());
            rb.setButtonDrawable(null);
            rb.setBackgroundColor(Color.WHITE);
            rb.setCompoundDrawablesWithIntrinsicBounds(0, menus.get(position).getImage(), 0, 0);
            rb.setGravity(Gravity.CENTER);
            rb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
        return rb;
    }
}
