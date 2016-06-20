package com.zju.gislab.baseproject;

import android.app.Application;

import com.zju.gislab.baseproject.crash.ProjectCrash;

/**
 * 当前注释类：
 * 项目名称：BaseProject
 * 作者：hejing on 16/6/6 16:10
 * 邮箱：18768117560@163.com
 */
public class ProjectApplication extends Application {
    private static ProjectApplication instance;
    public  static ProjectApplication getInstance(){
        return instance;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        this.instance=this;
        //初始化崩溃日志收集器
        ProjectCrash projectCrash = ProjectCrash.getInstance();
        projectCrash.setCustomCrashInfo(this);
    }
}
