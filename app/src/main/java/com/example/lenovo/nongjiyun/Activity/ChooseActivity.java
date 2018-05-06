package com.example.lenovo.nongjiyun.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

import com.example.lenovo.nongjiyun.Adapter.ChoosePlaceAdapter;
import com.example.lenovo.nongjiyun.Adapter.ChooseTypeAdapter;
import com.example.lenovo.nongjiyun.Model.PlaceItem;
import com.example.lenovo.nongjiyun.Model.TypeItem;
import com.example.lenovo.nongjiyun.R;
import com.example.lenovo.nongjiyun.view.FlexibleListView;

import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

public class ChooseActivity extends AppCompatActivity {
    private TextView tv_choose_type_place_title;
    private FlexibleListView mFlexibleListView;
    private Button btn_choose_type_place_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        Bmob.initialize(this, "3c1ca83ea1478120736f22b2ac49cbd0");

        tv_choose_type_place_title = (TextView) findViewById(R.id.tv_chose_type_place_title);
        mFlexibleListView = (FlexibleListView) findViewById(R.id.lv_chose_type_place);
        btn_choose_type_place_back = (Button) findViewById(R.id.btn_chose_type_place_back);

        Back();
        Intent i = getIntent();
        String titlename = i.getExtras().getString("titlename");
        tv_choose_type_place_title.setText(titlename);

        if (titlename.equals("选择类型")) {

          /*  BmobQuery query = new BmobQuery();
            query.findObjects(new FindListener<TypeItem>() {
                @Override
                public void done(final List<TypeItem> list, BmobException e) {
                    if (e != null) {
                        Log.i("tag", e.getMessage());
                    } else {
//                        ArrayList<Map<String, Object>> arrayList = new ArrayList<>();
//                        Map<String, Object> map = new HashMap<String, Object>();
//                        for (int i = 0; i < list.size(); i++) {
//                            map=new HashMap<>();
//                            map.put("name", list.get(i).getTypename().toString());
//                            arrayList.add(map);
//                        }
//                        arrayList.add(map);
//                        SimpleAdapter simpleAdapter=new SimpleAdapter(Activity_chose_type_place.this,arrayList,R.layout.item_choose_type_place,new String[]{"name"},new int[]{R.id.tv_choose_type_place_item});
                        mFlexibleListView.setAdapter(new ChooseTypeAdapter(ChooseActivity.this,list));
                        mFlexibleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                Intent intent=new Intent();
                                intent.putExtra("typename", list.get(i).getTypename());
                                setResult(2001,intent);
                                finish();
                            }
                        });
                   *//* mFlexibleListView.setAdapter(new ChooseTypeAdapter(Activity_chose_type_place.this,list));
                    SimpleAdapter simpleAdapter=new SimpleAdapter(this,list,new String[]{""})*//*

                    }

                }


            });*/

        } else {
            BmobQuery query = new BmobQuery();
            query.findObjects(new FindListener<PlaceItem>() {
                @Override
                public void done(final List<PlaceItem> mlist, BmobException e) {
                    if (e != null) {
                        Log.i("tag", e.getMessage());
                    } else {
                        mFlexibleListView.setAdapter(new ChoosePlaceAdapter(ChooseActivity.this,mlist));
                        mFlexibleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                Intent intent=new Intent();
                                intent.putExtra("placename",mlist.get(i).getPlacename());
                                setResult(1001,intent);
                                finish();
                            }
                        });
                    }
                }


            });
        }
    }

    private void Back() {

        btn_choose_type_place_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
