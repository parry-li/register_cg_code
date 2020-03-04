// Generated code from Butter Knife. Do not modify!
package com.tdr.registrationv3.ui.activity.insurance;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.tdr.registrationv3.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class InsuranceActivity_ViewBinding implements Unbinder {
  private InsuranceActivity target;

  private View view2131230798;

  @UiThread
  public InsuranceActivity_ViewBinding(InsuranceActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public InsuranceActivity_ViewBinding(final InsuranceActivity target, View source) {
    this.target = target;

    View view;
    target.insuranceRv = Utils.findRequiredViewAsType(source, R.id.insurance_rv, "field 'insuranceRv'", RecyclerView.class);
    target.comTitleBack = Utils.findRequiredViewAsType(source, R.id.com_title_back, "field 'comTitleBack'", RelativeLayout.class);
    target.textTitle = Utils.findRequiredViewAsType(source, R.id.text_title, "field 'textTitle'", TextView.class);
    target.comTitleSettingIv = Utils.findRequiredViewAsType(source, R.id.com_title_setting_iv, "field 'comTitleSettingIv'", ImageView.class);
    target.comTitleSettingTv = Utils.findRequiredViewAsType(source, R.id.com_title_setting_tv, "field 'comTitleSettingTv'", TextView.class);
    view = Utils.findRequiredView(source, R.id.button_next, "field 'buttonNext' and method 'onViewClicked'");
    target.buttonNext = Utils.castView(view, R.id.button_next, "field 'buttonNext'", TextView.class);
    view2131230798 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked();
      }
    });
    target.emptyIv = Utils.findRequiredViewAsType(source, R.id.empty_iv, "field 'emptyIv'", ImageView.class);
    target.emptyTv = Utils.findRequiredViewAsType(source, R.id.empty_tv, "field 'emptyTv'", TextView.class);
    target.emptyDataRl = Utils.findRequiredViewAsType(source, R.id.empty_data_rl, "field 'emptyDataRl'", RelativeLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    InsuranceActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.insuranceRv = null;
    target.comTitleBack = null;
    target.textTitle = null;
    target.comTitleSettingIv = null;
    target.comTitleSettingTv = null;
    target.buttonNext = null;
    target.emptyIv = null;
    target.emptyTv = null;
    target.emptyDataRl = null;

    view2131230798.setOnClickListener(null);
    view2131230798 = null;
  }
}
