package com.example.lenovo.nongjiyun.Fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.lenovo.nongjiyun.Adapter.GridAdapter;
import com.example.lenovo.nongjiyun.Model.HomeMenu;
import com.example.lenovo.nongjiyun.R;
import com.example.lenovo.nongjiyun.view.myGridView;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;
import com.jude.rollviewpager.hintview.ColorPointHintView;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }
//    private ListViewNewsAdapter listViewNewsAdapter;
//    private List<ListViewNewsAdapter> list;
    private myGridView gv_home;
//    private myListView listmenu;
    private ArrayList<HomeMenu> menus;
    private RefreshLayout refreshLayout;
    private RollPagerView mRollViewPager;
    private GridAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        gv_home =  view.findViewById(R.id.gv_home);
        mRollViewPager =  view.findViewById(R.id.roll_view_pager);
        refreshLayout =  view.findViewById(R.id.refreshLayout);
//        listmenu=view.findViewById(R.id.lv_home_news);
        menus =new ArrayList<>();
        refsresh();
        initGridView();
        //设置播放时间间隔

        //启动适配器，加载到布局中
//        listViewNewsAdapter = new ListViewNewsAdapter(null, getActivity());
//        listmenu.setAdapter(listViewNewsAdapter);

        adapter=new GridAdapter(getActivity(), menus);
        gv_home.setAdapter(adapter);
        }

    private void initGridView() {
        menus.add(new HomeMenu(R.mipmap.ic_launcher_round,"科技专项",null));
        menus.add(new HomeMenu(R.mipmap.ic_launcher_round,"科技专项",null));
        menus.add(new HomeMenu(R.mipmap.ic_launcher_round,"科技专项",null));
        menus.add(new HomeMenu(R.mipmap.ic_launcher_round,"科技专项",null));
        menus.add(new HomeMenu(R.mipmap.ic_launcher_round,"科技专项",null));
        menus.add(new HomeMenu(R.mipmap.ic_launcher_round,"科技专项",null));
        menus.add(new HomeMenu(R.mipmap.ic_launcher_round,"科技专项",null));
        menus.add(new HomeMenu(R.mipmap.ic_launcher_round,"科技专项",null));
        menus.add(new HomeMenu(R.mipmap.ic_launcher_round,"更多",null));
    }

    private void refsresh() {
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refreshlayout.finishRefresh(2000/*,false*/);//传入false表示刷新失败
            }
        });
        refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                refreshlayout.finishLoadmore(2000/*,false*/);//传入false表示加载失败
            }
        });
        mRollViewPager.setPlayDelay(1000);
        //设置适配器
        mRollViewPager.setAdapter(new TestNormalAdapter());
        //设置圆点指示器颜色得变化
        mRollViewPager.setHintView(new ColorPointHintView(getActivity(), Color.YELLOW, Color.WHITE ));

    }

    private class TestNormalAdapter extends StaticPagerAdapter {
        private int[] imgs = {
                R.drawable.img_1,
                R.drawable.img_2,
                R.drawable.img_3,
                R.drawable.img_4,
                R.drawable.img_5,
                R.drawable.img_6,
        };
        @Override
        public View getView(ViewGroup container, int position) {
            ImageView view = new ImageView(container.getContext());
            view.setImageResource(imgs[position]);
            view.setScaleType(ImageView.ScaleType.CENTER_CROP);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            return view;
        }
        @Override
        public int getCount() {
            return imgs.length;
        }
    }
}






