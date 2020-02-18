// Generated code from Butter Knife. Do not modify!
package com.tdr.registration.ui.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.tdr.registration.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MeFragment_ViewBinding implements Unbinder {
  private MeFragment target;

  private View view2131230995;

  private View view2131230996;

  private View view2131230997;

  private View view2131230994;

  private View view2131230992;

  private View view2131230993;

  @UiThread
  public MeFragment_ViewBinding(final MeFragment target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.me_pwd, "field 'mePwd' and method 'onViewClicked'");
    target.mePwd = Utils.castView(view, R.id.me_pwd, "field 'mePwd'", LinearLayout.class);
    view2131230995 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.me_update, "field 'meUpdate' and method 'onViewClicked'");
    target.meUpdate = Utils.castView(view, R.id.me_update, "field 'meUpdate'", LinearLayout.class);
    view2131230996 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.me_version, "field 'meVersion' and method 'onViewClicked'");
    target.meVersion = Utils.castView(view, R.id.me_version, "field 'meVersion'", LinearLayout.class);
    view2131230997 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.me_problem, "field 'meProblem' and method 'onViewClicked'");
    target.meProblem = Utils.castView(view, R.id.me_problem, "field 'meProblem'", LinearLayout.class);
    view2131230994 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.me_insurance, "field 'meInsurance' and method 'onViewClicked'");
    target.meInsurance = Utils.castView(view, R.id.me_insurance, "field 'meInsurance'", LinearLayout.class);
    view2131230992 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.me_out, "field 'meOut' and method 'onViewClicked'");
    target.meOut = Utils.castView(view, R.id.me_out, "field 'meOut'", LinearLayout.class);
    view2131230993 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.meVersionNum = Utils.findRequiredViewAsType(source, R.id.me_version_num, "field 'meVersionNum'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MeFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mePwd = null;
    target.meUpdate = null;
    target.meVersion = null;
    target.meProblem = null;
    target.meInsurance = null;
    target.meOut = null;
    target.meVersionNum = null;

    view2131230995.setOnClickListener(null);
    view2131230995 = null;
    view2131230996.setOnClickListener(null);
    view2131230996 = null;
    view2131230997.setOnClickListener(null);
    view2131230997 = null;
    view2131230994.setOnClickListener(null);
    view2131230994 = null;
    view2131230992.setOnClickListener(null);
    view2131230992 = null;
    view2131230993.setOnClickListener(null);
    view2131230993 = null;
  }
}
