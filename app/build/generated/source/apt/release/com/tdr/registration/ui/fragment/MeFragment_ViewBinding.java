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

  private View view2131230982;

  private View view2131230983;

  private View view2131230984;

  private View view2131230981;

  private View view2131230979;

  private View view2131230980;

  @UiThread
  public MeFragment_ViewBinding(final MeFragment target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.me_pwd, "field 'mePwd' and method 'onViewClicked'");
    target.mePwd = Utils.castView(view, R.id.me_pwd, "field 'mePwd'", LinearLayout.class);
    view2131230982 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.me_update, "field 'meUpdate' and method 'onViewClicked'");
    target.meUpdate = Utils.castView(view, R.id.me_update, "field 'meUpdate'", LinearLayout.class);
    view2131230983 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.me_version, "field 'meVersion' and method 'onViewClicked'");
    target.meVersion = Utils.castView(view, R.id.me_version, "field 'meVersion'", LinearLayout.class);
    view2131230984 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.me_problem, "field 'meProblem' and method 'onViewClicked'");
    target.meProblem = Utils.castView(view, R.id.me_problem, "field 'meProblem'", LinearLayout.class);
    view2131230981 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.me_insurance, "field 'meInsurance' and method 'onViewClicked'");
    target.meInsurance = Utils.castView(view, R.id.me_insurance, "field 'meInsurance'", LinearLayout.class);
    view2131230979 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.me_out, "field 'meOut' and method 'onViewClicked'");
    target.meOut = Utils.castView(view, R.id.me_out, "field 'meOut'", LinearLayout.class);
    view2131230980 = view;
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

    view2131230982.setOnClickListener(null);
    view2131230982 = null;
    view2131230983.setOnClickListener(null);
    view2131230983 = null;
    view2131230984.setOnClickListener(null);
    view2131230984 = null;
    view2131230981.setOnClickListener(null);
    view2131230981 = null;
    view2131230979.setOnClickListener(null);
    view2131230979 = null;
    view2131230980.setOnClickListener(null);
    view2131230980 = null;
  }
}
