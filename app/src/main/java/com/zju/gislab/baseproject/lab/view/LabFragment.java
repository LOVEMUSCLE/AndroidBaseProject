package com.zju.gislab.baseproject.lab.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zju.gislab.baseproject.R;
import com.zju.gislab.baseproject.base.BaseFragment;
import com.zju.gislab.baseproject.lab.presenter.ILabPresenter;
import com.zju.gislab.baseproject.lab.presenter.LabPresenterImpl;

import butterknife.BindView;

/**
 * 当前注释类：
 * 项目名称：BaseProject
 * 作者：hejing on 16/6/7 15:55
 * 邮箱：18768117560@163.com
 */
public class LabFragment extends BaseFragment implements ILabView, View.OnClickListener {

    @BindView(R.id.btn_lab_sync_get)
    Button syncGetButton;
    @BindView(R.id.btn_lab_asyn_get)
    Button asynGetButton;
    @BindView(R.id.btn_lab_sync_post)
    Button syncPostButton;
    @BindView(R.id.btn_lab_asyn_post)
    Button asynPostButton;

    private ILabPresenter labPresenter;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_lab;
    }

    @Override
    protected void initAllMembersView(Bundle savedInstanceState) {
        labPresenter = new LabPresenterImpl(this);
        syncGetButton.setOnClickListener(this);
        asynGetButton.setOnClickListener(this);
        syncPostButton.setOnClickListener(this);
        asynPostButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        labPresenter.onWidgetClicked(view);
    }
}
