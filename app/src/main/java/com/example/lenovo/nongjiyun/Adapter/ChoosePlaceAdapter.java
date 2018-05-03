package com.example.lenovo.nongjiyun.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.lenovo.nongjiyun.Model.PlaceItem;
import com.example.lenovo.nongjiyun.R;


import java.util.List;

public class ChoosePlaceAdapter extends BaseAdapter {
    private List<PlaceItem> mList;
    private LayoutInflater mLayoutInflater;
    public ChoosePlaceAdapter(Context context, List<PlaceItem> list){
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
    public View getView(int i, View sview, ViewGroup viewGroup) {
        View view=mLayoutInflater.inflate(R.layout.item_choose_type_place,null);
        final TextView tv_choose_type_place=(TextView)view.findViewById(R.id.tv_choose_type_place_item);
        tv_choose_type_place.setText(mList.get(i).getPlacename());
     /*   initRetun(mLayoutInflater.getContext(),tv_choose_type_place,i);*/

        return view;
    }
   /* private void initRetun(final Context context, TextView tv, final int in) {
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(mLayoutInflater.getContext(),Activity_me_phone_reist.class);
                i.putExtra("placename",mList.get(in).getPlacename());
                mLayoutInflater.getContext().startActivity(i);

            }
        });

    }*/
}
