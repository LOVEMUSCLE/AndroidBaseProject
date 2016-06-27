package com.zju.gislab.baseproject.lab.presenter;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;

import com.zju.gislab.baseproject.R;
import com.zju.gislab.baseproject.lab.view.ILabView;
import com.zju.gislab.baseproject.utils.MessageUtils;
import com.zju.gislab.baseproject.utils.OkHttpUtils;
import com.zju.gislab.baseproject.utils.ToastUtils;

import java.io.IOException;

import okhttp3.Request;

/**
 * Created by hornkyin on 16/6/22.
 */
public class LabPresenterImpl implements ILabPresenter {
    private ILabView labView;
    private final String GET_URL = "http://baike.bdimg.com/static/wiki-common/widget/lib/jsmart/PHPJS_3347e0a";
    private final String POST_URL = "http://baike.bdimg.com/static/wiki-common/widget/lib/jsmart/PHPJS_3347e0a";
    private final int MSG_0 = 0x000000;

    public LabPresenterImpl(ILabView iLabView) {
        this.labView = iLabView;
    }

    Handler handler = new Handler() {
        @Override
        public void dispatchMessage(Message msg) {
            switch (msg.what) {
                case MSG_0:
                    ToastUtils.showShort(labView.getActivity(), msg.getData().getString("MSG"));
                    break;
                default:
                    ToastUtils.showShort(labView.getActivity(), "ERROR - Default switch results!");
                    break;
            }
        }
    };

    @Override
    public void onWidgetClicked(View v) {
        switch (v.getId()) {
            case R.id.btn_lab_sync_get:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            String responseStr = OkHttpUtils.getSyncString(GET_URL);
                            Bundle bundle = new Bundle();
                            bundle.putString("MSG", responseStr);
                            handler.sendMessage(MessageUtils.createMsg(MSG_0, bundle));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
                break;
            case R.id.btn_lab_asyn_get:
                //<String>Object可以是自定义的Model类，会自行的将服务器请求到的JSON字符串解析成Model类对象
                OkHttpUtils.getAsyn(GET_URL, new OkHttpUtils.ResultCallback<String>() {
                    @Override
                    public void onError(Request request, Exception e) {
                        //回调在主线程中执行
                        ToastUtils.showShort(labView.getActivity(), "ERROR - " + e.getMessage());
                    }

                    @Override
                    public void onResponse(String response) {
                        //回调在主线程中执行
                        ToastUtils.showShort(labView.getActivity(), response);
                    }
                });
                break;
            case R.id.btn_lab_sync_post:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        OkHttpUtils.Param[] params = new OkHttpUtils.Param[0];
                        try {
                            String responseStr = OkHttpUtils.postSyncString(POST_URL, params);
                            Bundle bundle = new Bundle();
                            bundle.putString("MSG", responseStr);
                            handler.sendMessage(MessageUtils.createMsg(MSG_0, bundle));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        ;
                    }
                }).start();
                break;
            case R.id.btn_lab_asyn_post:
                OkHttpUtils.Param[] params = new OkHttpUtils.Param[0];
                //Object可以是自定义的Model类，会自行的将服务器请求到的JSON字符串解析成Model类对象
                OkHttpUtils.postAsyn(POST_URL, params, new OkHttpUtils.ResultCallback<Object>() {
                    @Override
                    public void onError(Request request, Exception e) {
                        ToastUtils.showShort(labView.getActivity(), "ERROR - " + e.getMessage());
                    }

                    @Override
                    public void onResponse(Object response) {
                        ToastUtils.showShort(labView.getActivity(), response.toString());
                    }
                });
                break;
        }
    }
}
