package com.zju.gislab.baseproject.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.gc.materialdesign.widgets.ProgressDialog;

import butterknife.ButterKnife;

/**
 * Created by hejing on 16/6/5.
 */


public abstract class BaseActivity extends AppCompatActivity {
    private ProgressDialog mProgressDialog;
    public abstract int getContentViewId();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        ButterKnife.bind(this);
        initAllMembersView(savedInstanceState);
    }

    protected abstract void  initAllMembersView(Bundle savedInstanceState);


    @Override
    protected void onDestroy() {
        super.onDestroy();
       // ButterKnife.unbind(this);//解除绑定
    }




}
