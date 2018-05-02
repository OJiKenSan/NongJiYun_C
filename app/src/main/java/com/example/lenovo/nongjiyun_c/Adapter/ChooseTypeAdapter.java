package com.example.lenovo.nongjiyun_c.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.lenovo.nongjiyun_c.Model.TypeItem;
import com.example.lenovo.nongjiyun_c.R;


import java.util.List;


public class   ChooseTypeAdapter extends BaseAdapter {

    private List<TypeItem> mList;
    private LayoutInflater mLayoutInflater;
     private  String typename="选择类型";
    public ChooseTypeAdapter(Context context, List<TypeItem> list){
  mList=list;
  mLayoutInflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View viesw, ViewGroup viewGroup) {
        View view=mLayoutInflater.inflate(R.layout.item_choose_type_place,null);
        final TextView tv_choose_type_place=(TextView)view.findViewById(R.id.tv_choose_type_place_item);

        tv_choose_type_place.setText(mList.get(i).getTypename());


        return view;
    }


}
