package com.example.lenovo.nongjiyun.Adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.lenovo.nongjiyun.Model.Question;
import com.example.lenovo.nongjiyun.R;

import java.util.List;

public class QuestionAdapter extends BaseAdapter {
    private List<Question> mList;
private LayoutInflater mLayoutInflater;
    public QuestionAdapter(Context context, List<Question> list){
        mList=list;
        mLayoutInflater=LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        return mList;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View views, ViewGroup viewGroup) {
        View view =mLayoutInflater.inflate(R.layout.item_fragment_questions,null);
        ImageView pics1=(ImageView) view.findViewById(R.id.pics1);
        ImageView pics2=(ImageView) view.findViewById(R.id.pics2);
        TextView tv1=(TextView) view.findViewById(R.id.tv1);
        TextView tv2=(TextView) view.findViewById(R.id.tv2);
        TextView tv3=(TextView) view.findViewById(R.id.tv3);
        TextView tv4=(TextView) view.findViewById(R.id.tv4);
        TextView tv5=(TextView) view.findViewById(R.id.tv5);
        TextView tv6=(TextView) view.findViewById(R.id.tv6);
        TextView tv7=(TextView) view.findViewById(R.id.tv7);
        TextView tv8=(TextView) view.findViewById(R.id.tv8);

        tv1.setText(mList.get(i).getXm());
        tv2.setText(mList.get(i).getQt1());
        tv3.setText(mList.get(i).getQt2());
        tv4.setText(mList.get(i).getDz1());
        tv5.setText(mList.get(i).getCg());
        tv6.setText(mList.get(i).getDz2());
        tv7.setText(mList.get(i).getRq());
        tv8.setText(mList.get(i).getHd());
        pics1.setBackgroundResource(mList.get(i).getPic());
        pics2.setBackgroundResource(mList.get(i).getPic1());


        return view;
    }
}
