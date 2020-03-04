// Generated code from Butter Knife. Do not modify!
package com.tdr.registrationV3.ui.activity.home;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.tdr.registrationV3.R;
import com.tdr.registrationV3.view.NoScrollViewPager;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HomeActivity_ViewBinding implements Unbinder {
  private HomeActivity target;

  private View view2131231001;

  private View view2131231004;

  @UiThread
  public HomeActivity_ViewBinding(HomeActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public HomeActivity_ViewBinding(final HomeActivity target, View source) {
    this.target = target;

    View view;
    target.mainVp = Utils.findRequiredViewAsType(source, R.id.main_vp, "field 'mainVp'", NoScrollViewPager.class);
    target.mainBottomHomeTv = Utils.findRequiredViewAsType(source, R.id.main_bottom_home_tv, "field 'mainBottomHomeTv'", TextView.class);
    view = Utils.findRequiredView(source, R.id.main_bottom_home, "field 'mainBottomHome' and method 'onViewClicked'");
    target.mainBottomHome = Utils.castView(view, R.id.main_bottom_home, "field 'mainBottomHome'", LinearLayout.class);
    view2131231001 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.mainBottomMeTv = Utils.findRequiredViewAsType(source, R.id.main_bottom_me_tv, "field 'mainBottomMeTv'", TextView.class);
    view = Utils.findRequiredView(source, R.id.main_bottom_me, "field 'mainBottomMe' and method 'onViewClicked'");
    target.mainBottomMe = Utils.castView(view, R.id.main_bottom_me, "field 'mainBottomMe'", LinearLayout.class);
    view2131231004 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.mainBottom = Utils.findRequiredViewAsType(source, R.id.main_bottom, "field 'mainBottom'", LinearLayout.class);
    target.mainBottomHomeIv = Utils.findRequiredViewAsType(source, R.id.main_bottom_home_iv, "field 'mainBottomHomeIv'", ImageView.class);
    target.mainBottomMeIv = Utils.findRequiredViewAsType(source, R.id.main_bottom_me_iv, "field 'mainBottomMeIv'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    HomeActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mainVp = null;
    target.mainBottomHomeTv = null;
    target.mainBottomHome = null;
    target.mainBottomMeTv = null;
    target.mainBottomMe = null;
    target.mainBottom = null;
    target.mainBottomHomeIv = null;
    target.mainBottomMeIv = null;

    view2131231001.setOnClickListener(null);
    view2131231001 = null;
    view2131231004.setOnClickListener(null);
    view2131231004 = null;
  }
}
