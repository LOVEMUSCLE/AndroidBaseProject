// Generated code from Butter Knife. Do not modify!
package com.zju.gislab.baseproject;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class MainActivity$$ViewBinder<T extends MainActivity> implements ViewBinder<T> {
  @Override
  public Unbinder bind(final Finder finder, final T target, Object source) {
    InnerUnbinder unbinder = createUnbinder(target);
    View view;
    view = finder.findRequiredView(source, 2131558485, "field 'ibShouye'");
    target.ibShouye = finder.castView(view, 2131558485, "field 'ibShouye'");
    view = finder.findRequiredView(source, 2131558486, "field 'tvShouye'");
    target.tvShouye = finder.castView(view, 2131558486, "field 'tvShouye'");
    view = finder.findRequiredView(source, 2131558484, "field 'reShouye'");
    target.reShouye = finder.castView(view, 2131558484, "field 'reShouye'");
    view = finder.findRequiredView(source, 2131558488, "field 'ibLab'");
    target.ibLab = finder.castView(view, 2131558488, "field 'ibLab'");
    view = finder.findRequiredView(source, 2131558489, "field 'tvLab'");
    target.tvLab = finder.castView(view, 2131558489, "field 'tvLab'");
    view = finder.findRequiredView(source, 2131558487, "field 'reLab'");
    target.reLab = finder.castView(view, 2131558487, "field 'reLab'");
    view = finder.findRequiredView(source, 2131558491, "field 'ibHangye'");
    target.ibHangye = finder.castView(view, 2131558491, "field 'ibHangye'");
    view = finder.findRequiredView(source, 2131558492, "field 'tvHangye'");
    target.tvHangye = finder.castView(view, 2131558492, "field 'tvHangye'");
    view = finder.findRequiredView(source, 2131558490, "field 'reHangye'");
    target.reHangye = finder.castView(view, 2131558490, "field 'reHangye'");
    view = finder.findRequiredView(source, 2131558494, "field 'ibHr'");
    target.ibHr = finder.castView(view, 2131558494, "field 'ibHr'");
    view = finder.findRequiredView(source, 2131558495, "field 'tvHr'");
    target.tvHr = finder.castView(view, 2131558495, "field 'tvHr'");
    view = finder.findRequiredView(source, 2131558493, "field 'reHr'");
    target.reHr = finder.castView(view, 2131558493, "field 'reHr'");
    view = finder.findRequiredView(source, 2131558483, "field 'mainBottom'");
    target.mainBottom = finder.castView(view, 2131558483, "field 'mainBottom'");
    view = finder.findRequiredView(source, 2131558496, "field 'viewTemp'");
    target.viewTemp = view;
    view = finder.findRequiredView(source, 2131558497, "field 'fragmentContainer'");
    target.fragmentContainer = finder.castView(view, 2131558497, "field 'fragmentContainer'");
    return unbinder;
  }

  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends MainActivity> implements Unbinder {
    private T target;

    protected InnerUnbinder(T target) {
      this.target = target;
    }

    @Override
    public final void unbind() {
      if (target == null) throw new IllegalStateException("Bindings already cleared.");
      unbind(target);
      target = null;
    }

    protected void unbind(T target) {
      target.ibShouye = null;
      target.tvShouye = null;
      target.reShouye = null;
      target.ibLab = null;
      target.tvLab = null;
      target.reLab = null;
      target.ibHangye = null;
      target.tvHangye = null;
      target.reHangye = null;
      target.ibHr = null;
      target.tvHr = null;
      target.reHr = null;
      target.mainBottom = null;
      target.viewTemp = null;
      target.fragmentContainer = null;
    }
  }
}
