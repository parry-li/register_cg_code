// Generated code from Butter Knife. Do not modify!
package com.tdr.registration.ui.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.tdr.registration.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HomeFragment_ViewBinding implements Unbinder {
  private HomeFragment target;

  private View view2131230922;

  private View view2131230924;

  private View view2131230921;

  private View view2131230926;

  private View view2131230923;

  @UiThread
  public HomeFragment_ViewBinding(final HomeFragment target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.home_city_ll, "field 'homeCityLl' and method 'onViewClicked'");
    target.homeCityLl = Utils.castView(view, R.id.home_city_ll, "field 'homeCityLl'", LinearLayout.class);
    view2131230922 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.home_register_ll, "field 'homeRegisterLl' and method 'onViewClicked'");
    target.homeRegisterLl = Utils.castView(view, R.id.home_register_ll, "field 'homeRegisterLl'", LinearLayout.class);
    view2131230924 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.home_bxbg_ll, "field 'homeBxbgLl' and method 'onViewClicked'");
    target.homeBxbgLl = Utils.castView(view, R.id.home_bxbg_ll, "field 'homeBxbgLl'", LinearLayout.class);
    view2131230921 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.home_xxbg_ll, "field 'homeXxbgLl' and method 'onViewClicked'");
    target.homeXxbgLl = Utils.castView(view, R.id.home_xxbg_ll, "field 'homeXxbgLl'", LinearLayout.class);
    view2131230926 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.home_grtj_ll, "field 'homeGrtjLl' and method 'onViewClicked'");
    target.homeGrtjLl = Utils.castView(view, R.id.home_grtj_ll, "field 'homeGrtjLl'", LinearLayout.class);
    view2131230923 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.homeRv = Utils.findRequiredViewAsType(source, R.id.home_rv, "field 'homeRv'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    HomeFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.homeCityLl = null;
    target.homeRegisterLl = null;
    target.homeBxbgLl = null;
    target.homeXxbgLl = null;
    target.homeGrtjLl = null;
    target.homeRv = null;

    view2131230922.setOnClickListener(null);
    view2131230922 = null;
    view2131230924.setOnClickListener(null);
    view2131230924 = null;
    view2131230921.setOnClickListener(null);
    view2131230921 = null;
    view2131230926.setOnClickListener(null);
    view2131230926 = null;
    view2131230923.setOnClickListener(null);
    view2131230923 = null;
  }
}
