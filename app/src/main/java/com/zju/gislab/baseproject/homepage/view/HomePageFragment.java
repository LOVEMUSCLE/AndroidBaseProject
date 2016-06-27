package com.zju.gislab.baseproject.homepage.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.zju.gislab.baseproject.R;
import com.zju.gislab.baseproject.base.BaseFragment;
import com.zju.gislab.baseproject.event.GetDataEvent;
import com.zju.gislab.baseproject.event.ToastEvent;
import com.zju.gislab.baseproject.homepage.presenter.HomePagePresenterImpl;
import com.zju.gislab.baseproject.homepage.presenter.IHomePagePresenter;
import com.zju.gislab.baseproject.utils.ToastUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 当前注释类：
 * 项目名称：BaseProject
 * 作者：hejing on 16/6/7 15:54
 * 邮箱：18768117560@163.com
 */
public class HomePageFragment extends BaseFragment implements IHomePageView, AdapterView.OnItemClickListener {


    @BindView(R.id.lv_homepage_country_data)
    ListView lvShowCountryData;
    @BindView(R.id.rl_homepage_globe)
    RelativeLayout rlGlobeView;

    private IHomePagePresenter homePagePresenter;
    List<String> datas = new ArrayList<>();
    private BaseAdapter adapter;


    @Override
    public int getContentViewId() {
        return R.layout.fragment_homepage;
    }

    @Override
    protected void initAllMembersView(Bundle savedInstanceState) {
        lvShowCountryData.setOnItemClickListener(this);
        //init
        View loadingView = LayoutInflater.from(getActivity()).inflate(R.layout.item_empty_view, null);

        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        rlGlobeView.addView(loadingView, layoutParams);
        lvShowCountryData.setEmptyView(loadingView);

        adapter = new ArrayAdapter<>(this.getContext(), android.R.layout.simple_list_item_1, datas);
        lvShowCountryData.setAdapter(adapter);
        homePagePresenter = new HomePagePresenterImpl(this);
    }


    @Override
    public void onStart() {
        super.onStart();
        //注册EventBus
        EventBus.getDefault().register(this);

    }

    @Override
    public void onStop() {
        //解除注册
        EventBus.getDefault().unregister(this);
        super.onStop();

    }

    @Override
    public void onResume() {
        super.onResume();
        homePagePresenter.loadDatas();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        homePagePresenter.onItemClick(position);
    }

    //注册EventBus事件
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(ToastEvent toastEvent) {
        if (toastEvent != null && toastEvent.getMessage() != null) {
            ToastUtils.showShort(getActivity(), toastEvent.getMessage());
        }
    }

    //注册EventBus事件
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(GetDataEvent getDatasEvent) {
        if (getDatasEvent != null && getDatasEvent.getDatas() != null && getDatasEvent.getDatas().size() > 0) {
            this.datas.clear();
            this.datas.addAll(getDatasEvent.getDatas());
            adapter.notifyDataSetChanged();
        }
    }
}
