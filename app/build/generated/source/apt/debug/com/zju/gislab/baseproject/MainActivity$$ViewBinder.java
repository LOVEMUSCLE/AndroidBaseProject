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
    view = finder.findRequiredView(source, 2131558484, "field 'rlHomepageSwitch'");
    target.rlHomepageSwitch = finder.castView(view, 2131558484, "field 'rlHomepageSwitch'");
    view = finder.findRequiredView(source, 2131558487, "field 'rlLabSwitch'");
    target.rlLabSwitch = finder.castView(view, 2131558487, "field 'rlLabSwitch'");
    view = finder.findRequiredView(source, 2131558490, "field 'rlIndustrySwitch'");
    target.rlIndustrySwitch = finder.castView(view, 2131558490, "field 'rlIndustrySwitch'");
    view = finder.findRequiredView(source, 2131558493, "field 'rlPersonnelTrainSwitch'");
    target.rlPersonnelTrainSwitch = finder.castView(view, 2131558493, "field 'rlPersonnelTrainSwitch'");
    view = finder.findRequiredView(source, 2131558483, "field 'llMainBottom'");
    target.llMainBottom = finder.castView(view, 2131558483, "field 'llMainBottom'");
    view = finder.findRequiredView(source, 2131558497, "field 'rlFragmentContainer'");
    target.rlFragmentContainer = finder.castView(view, 2131558497, "field 'rlFragmentContainer'");
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
      target.rlHomepageSwitch = null;
      target.rlLabSwitch = null;
      target.rlIndustrySwitch = null;
      target.rlPersonnelTrainSwitch = null;
      target.llMainBottom = null;
      target.rlFragmentContainer = null;
    }
  }
}
