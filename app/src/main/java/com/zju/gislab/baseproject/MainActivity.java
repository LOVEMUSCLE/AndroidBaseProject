package com.zju.gislab.baseproject;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zju.gislab.baseproject.base.BaseFragmentActivity;
import com.zju.gislab.baseproject.homepage.view.HomePageFragment;
import com.zju.gislab.baseproject.industryapp.view.HangYeFragment;
import com.zju.gislab.baseproject.lab.view.LabFragment;
import com.zju.gislab.baseproject.personneltrain.view.HrFragment;

import butterknife.BindView;

public class MainActivity extends BaseFragmentActivity {
//jsjsk

    @BindView(R.id.ib_shouye)
    ImageView ibShouye;
    @BindView(R.id.tv_shouye)
    TextView tvShouye;
    @BindView(R.id.re_shouye)
    RelativeLayout reShouye;
    @BindView(R.id.ib_lab)
    ImageView ibLab;
    @BindView(R.id.tv_lab)
    TextView tvLab;
    @BindView(R.id.re_lab)
    RelativeLayout reLab;
    @BindView(R.id.ib_hangye)
    ImageView ibHangye;
    @BindView(R.id.tv_hangye)
    TextView tvHangye;
    @BindView(R.id.re_hangye)
    RelativeLayout reHangye;
    @BindView(R.id.ib_hr)
    ImageView ibHr;
    @BindView(R.id.tv_hr)
    TextView tvHr;
    @BindView(R.id.re_hr)
    RelativeLayout reHr;
    @BindView(R.id.main_bottom)
    LinearLayout mainBottom;
    @BindView(R.id.view_temp)
    View viewTemp;
    @BindView(R.id.fragment_container)
    RelativeLayout fragmentContainer;


    // 当前fragment的index
    private int currentTabIndex;
    private int index;
    private static final String KEY_INDEX = "TAB_INDEX";

    private Fragment[] fragments;
    private HangYeFragment hangYeFragment;
    private HomePageFragment homePageFragment;
    private LabFragment labFragment;
    private HrFragment hrFragment;



    @Override
    public int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initAllMembersView(Bundle savedInstanceState) {
        //如果add了几个Fragment,使用show,hide方法进行控制，如果什么多不做的话，在内存重启之后回到前台，app的几个界面
        //会重叠。原因是FragmentManager帮我们管理Fragment,每当我们离开该Activity，FragmentManager都会保存它的Fragments，
        // 当发生“内存重启”，他会从栈底向栈顶的顺序一次性恢复Fragments，并且全都都是以show()的方式，所以我们看到了界面重叠。


        //使用的Acitivity是同级式的，恢复的时候恢复最后一个
        //可以在onSavedInstanceState中保存当前所在的Fragment的tag或者下标
        if (savedInstanceState != null) {// “内存重启”时调用
            //获取Fragment
            currentTabIndex = savedInstanceState.getInt(KEY_INDEX);
            homePageFragment = (HomePageFragment) getBaseFragmentManager().findFragmentByTag(homePageFragment.getTag());
            labFragment = (LabFragment) getBaseFragmentManager().findFragmentByTag(labFragment.getTag());
            hangYeFragment = (HangYeFragment) getBaseFragmentManager().findFragmentByTag(hangYeFragment.getTag());
            hrFragment = (HrFragment) getBaseFragmentManager().findFragmentByTag(hrFragment.getTag());

            hideFragment(homePageFragment);
            hideFragment(labFragment);
            hideFragment(hangYeFragment);
            hideFragment(hrFragment);
            showFragment(fragments[currentTabIndex]);

        }else {
            homePageFragment = new HomePageFragment();
            labFragment = new LabFragment();
            hangYeFragment = new HangYeFragment();
            hrFragment = new HrFragment();
            fragments = new Fragment[]{homePageFragment,labFragment,hangYeFragment,hrFragment};

            addFragment(R.id.fragment_container,homePageFragment,homePageFragment.getTag());
            addFragment(R.id.fragment_container,labFragment,labFragment.getTag());
            addFragment(R.id.fragment_container,hangYeFragment,hangYeFragment.getTag());
            addFragment(R.id.fragment_container,hrFragment,hrFragment.getTag());
            hideFragment(labFragment);
            hideFragment(hangYeFragment);
            hideFragment(hrFragment);
            showFragment(homePageFragment);
        }



    }

    @Override
    protected int getFragmentContentId() {
        return R.id.fragment_container;
    }


    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        // 保存当前Fragment的下标
        outState.putInt(KEY_INDEX, currentTabIndex);
    }



    public void onTabClicked(View view) {
        switch (view.getId()) {
            case R.id.re_shouye:
                index = 0;
                break;
            case R.id.re_lab:
                index = 1;
                break;
            case R.id.re_hangye:
                index = 2;
                break;
            case R.id.re_hr:
                index = 3;
                break;

        }
        if (currentTabIndex != index) {
            hideFragment(fragments[currentTabIndex]);
            if (!fragments[index].isAdded()){
                addFragment(R.id.fragment_container,fragments[index],fragments[index].getTag());
            }
            showFragment(fragments[index]);
        }
        currentTabIndex = index;
    }

}
