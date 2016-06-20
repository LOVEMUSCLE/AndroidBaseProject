package com.zju.gislab.baseproject.base;

import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;

/**
 * 当前注释类：
 * 项目名称：BaseProject
 * 作者：hejing on 16/6/7 09:42
 * 邮箱：18768117560@163.com
 */
public abstract class BaseFragmentActivity extends BaseActivity {
    FragmentManager fragmentManager;


    //布局中Fragment的ID
    protected abstract int getFragmentContentId();

    /**
     * 获得Fragment管理器
     *
     * @return
     */
    public FragmentManager getBaseFragmentManager() {
        if (fragmentManager == null) {
            fragmentManager = getSupportFragmentManager();
        }
        return fragmentManager;
    }


    /**
     * 获取Fragment事物管理
     *
     * @return
     */
    public FragmentTransaction getFragmentTransaction() {
        return getBaseFragmentManager().beginTransaction();
    }


    /**
     * 替换一个Fragment并设置是否加入回退栈
     *
     * @param res
     * @param fragment
     * @param isAddToBackStack
     */
    public void replaceFragment(int res, BaseFragment fragment, boolean isAddToBackStack) {
        FragmentTransaction fragmentTransaction = getFragmentTransaction();
        fragmentTransaction.replace(res, fragment);
        if (isAddToBackStack) {
            fragmentTransaction.addToBackStack(fragment.getClass().getSimpleName());
        }
        fragmentTransaction.commit();

    }


    /**
     * 添加一个Fragment，但是不添加至Fragment后退栈中
     *
     * @param res
     * @param fragment
     */
    public void addFragment(int res, Fragment fragment, String tag) {
        FragmentTransaction fragmentTransaction = null;
        fragmentTransaction = getFragmentTransaction();


        fragmentTransaction.add(res, fragment, tag);
        fragmentTransaction.commit();
    }

    /**
     * 添加一个Fragment，同时添加至后退栈中
     * @param res
     * @param fragment
     * @param tag
     */
    public void addFragmentWithBackStack(int res, Fragment fragment, String tag) {
        FragmentTransaction fragmentTransaction = null;

        fragmentTransaction = getFragmentTransaction();
        fragmentTransaction.add(res, fragment, tag);
        fragmentTransaction.addToBackStack(tag);
        fragmentTransaction.commit();
    }

    /**
     * 移除一个Fragment
     * 如果你没有将Fragment加入回退栈，remove方法可以正常出栈。
     * @param fragment
     */
    public void removeFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getFragmentTransaction();
        fragmentTransaction.remove(fragment);
        fragmentTransaction.commit();
    }

    /**
     * 从后退栈中移除Fragment
     * 如果你加入了回退栈，popBackStack()系列方法才能真正出栈
     * @param
     */
    public void popFragmentWithBackStack() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            getSupportFragmentManager().popBackStack();
        } else {
            finish();
        }
    }

    /**
     * 显示一个Fragment
     *
     * @param fragment
     */
    public void showFragment(Fragment fragment) {
        if (fragment.isHidden()) {
            FragmentTransaction fragmentTransaction = getFragmentTransaction();
            fragmentTransaction.show(fragment);
            fragmentTransaction.commit();
        }
    }

    /**
     * 隐藏一个Fragment
     *
     * @param fragment
     */
    public void hideFragment(Fragment fragment) {
        if (!fragment.isHidden()) {
            FragmentTransaction fragmentTransaction = getFragmentTransaction();
            fragmentTransaction.hide(fragment);
            fragmentTransaction.commit();
        }
    }

    //返回键返回事件
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (KeyEvent.KEYCODE_BACK == keyCode) {
            if (getSupportFragmentManager().getBackStackEntryCount() == 1) {
                finish();
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
