package com.zju.gislab.baseproject.event;

/**
 * 当前注释类：
 * 项目名称：BaseProject
 * 作者：hejing on 16/6/12 13:54
 * 邮箱：18768117560@163.com
 */
public class ToastEvent {
    String msg;

    public ToastEvent(String msg) {
        this.msg = msg;
    }

    public String getMessage() {
        return msg;
    }
}
