// Generated code from Butter Knife. Do not modify!
package com.tdr.registration.ui.fragment.register;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.tdr.registration.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class RegisterInsuranceFragment_ViewBinding implements Unbinder {
  private RegisterInsuranceFragment target;

  private View view2131230950;

  private View view2131230949;

  private View view2131230951;

  private View view2131230793;

  @UiThread
  public RegisterInsuranceFragment_ViewBinding(final RegisterInsuranceFragment target,
      View source) {
    this.target = target;

    View view;
    target.comTitleBack = Utils.findRequiredViewAsType(source, R.id.com_title_back, "field 'comTitleBack'", RelativeLayout.class);
    target.textTitle = Utils.findRequiredViewAsType(source, R.id.text_title, "field 'textTitle'", TextView.class);
    target.comTitleSettingIv = Utils.findRequiredViewAsType(source, R.id.com_title_setting_iv, "field 'comTitleSettingIv'", ImageView.class);
    target.comTitleSettingTv = Utils.findRequiredViewAsType(source, R.id.com_title_setting_tv, "field 'comTitleSettingTv'", TextView.class);
    target.insuranceRv = Utils.findRequiredViewAsType(source, R.id.insurance_rv, "field 'insuranceRv'", RecyclerView.class);
    view = Utils.findRequiredView(source, R.id.insurance_p_no, "field 'insurancePNo' and method 'onViewClicked'");
    target.insurancePNo = Utils.castView(view, R.id.insurance_p_no, "field 'insurancePNo'", TextView.class);
    view2131230950 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.insurance_p_gr, "field 'insurancePGr' and method 'onViewClicked'");
    target.insurancePGr = Utils.castView(view, R.id.insurance_p_gr, "field 'insurancePGr'", TextView.class);
    view2131230949 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.insurance_p_qy, "field 'insurancePQy' and method 'onViewClicked'");
    target.insurancePQy = Utils.castView(view, R.id.insurance_p_qy, "field 'insurancePQy'", TextView.class);
    view2131230951 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.insuranceKpLl = Utils.findRequiredViewAsType(source, R.id.insurance_kp_ll, "field 'insuranceKpLl'", LinearLayout.class);
    view = Utils.findRequiredView(source, R.id.button_next, "field 'buttonNext' and method 'onViewClicked'");
    target.buttonNext = Utils.castView(view, R.id.button_next, "field 'buttonNext'", TextView.class);
    view2131230793 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.emptyIv = Utils.findRequiredViewAsType(source, R.id.empty_iv, "field 'emptyIv'", ImageView.class);
    target.emptyTv = Utils.findRequiredViewAsType(source, R.id.empty_tv, "field 'emptyTv'", TextView.class);
    target.emptyDataRl = Utils.findRequiredViewAsType(source, R.id.empty_data_rl, "field 'emptyDataRl'", RelativeLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    RegisterInsuranceFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.comTitleBack = null;
    target.textTitle = null;
    target.comTitleSettingIv = null;
    target.comTitleSettingTv = null;
    target.insuranceRv = null;
    target.insurancePNo = null;
    target.insurancePGr = null;
    target.insurancePQy = null;
    target.insuranceKpLl = null;
    target.buttonNext = null;
    target.emptyIv = null;
    target.emptyTv = null;
    target.emptyDataRl = null;

    view2131230950.setOnClickListener(null);
    view2131230950 = null;
    view2131230949.setOnClickListener(null);
    view2131230949 = null;
    view2131230951.setOnClickListener(null);
    view2131230951 = null;
    view2131230793.setOnClickListener(null);
    view2131230793 = null;
  }
}
