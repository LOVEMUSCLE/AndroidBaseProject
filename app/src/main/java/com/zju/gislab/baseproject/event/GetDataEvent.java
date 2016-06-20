package com.zju.gislab.baseproject.event;

import java.util.List;

/**
 * 当前注释类：
 * 项目名称：BaseProject
 * 作者：hejing on 16/6/12 13:55
 * 邮箱：18768117560@163.com
 */
public class GetDataEvent {
    List<String> datas;

    public GetDataEvent(List<String> datas) {
        this.datas = datas;
    }

    public List<String> getDatas() {
        return datas;
    }
}
