package com.zju.gislab.baseproject.homepage.presenter;

import android.os.Looper;

import com.zju.gislab.baseproject.R;
import com.zju.gislab.baseproject.event.GetDataEvent;
import com.zju.gislab.baseproject.event.ToastEvent;
import com.zju.gislab.baseproject.homepage.view.IHomePageView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

/**
 * 当前注释类：
 * 项目名称：BaseProject
 * 作者：hejing on 16/6/12 14:02
 * 邮箱：18768117560@163.com
 */
public class HomePagePresenterImpl implements IHomePagePresenter{
    List<String> datas;
    IHomePageView iHomePageView;

    public HomePagePresenterImpl(IHomePageView iHomePageView){
        this.iHomePageView = iHomePageView;
    }

    @Override
    public void loadDatas() {
        String[] countries = iHomePageView.getActivity().getResources().getStringArray(R.array.countries);
        datas = new ArrayList<>();
        for (String item : countries) {
            datas.add(item);
        }

        android.os.Handler handler = new android.os.Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                GetDataEvent getDataEvent = new GetDataEvent(datas);
                EventBus.getDefault().post(getDataEvent);
            }
        },2000);






    }

    @Override
    public void onItemClick(int position) {
        ToastEvent toastEvent = new ToastEvent(datas.get(position));
        EventBus.getDefault().post(toastEvent);

    }
}
