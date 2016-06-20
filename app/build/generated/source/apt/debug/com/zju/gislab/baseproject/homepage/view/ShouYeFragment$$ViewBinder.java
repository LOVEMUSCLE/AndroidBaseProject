// Generated code from Butter Knife. Do not modify!
package com.zju.gislab.baseproject.homepage.view;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class ShouYeFragment$$ViewBinder<T extends ShouYeFragment> implements ViewBinder<T> {
  @Override
  public Unbinder bind(final Finder finder, final T target, Object source) {
    InnerUnbinder unbinder = createUnbinder(target);
    View view;
    view = finder.findRequiredView(source, 2131558511, "field 'listHomepage'");
    target.listHomepage = finder.castView(view, 2131558511, "field 'listHomepage'");
    view = finder.findRequiredView(source, 2131558510, "field 'viewGroup'");
    target.viewGroup = finder.castView(view, 2131558510, "field 'viewGroup'");
    return unbinder;
  }

  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends ShouYeFragment> implements Unbinder {
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
      target.listHomepage = null;
      target.viewGroup = null;
    }
  }
}
