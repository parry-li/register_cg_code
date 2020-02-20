// Generated code from Butter Knife. Do not modify!
package com.tdr.registration.ui.activity.me;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.tdr.registration.R;
import com.tdr.registration.view.SearchView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class InsuranceWaitActivity_ViewBinding implements Unbinder {
  private InsuranceWaitActivity target;

  @UiThread
  public InsuranceWaitActivity_ViewBinding(InsuranceWaitActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public InsuranceWaitActivity_ViewBinding(InsuranceWaitActivity target, View source) {
    this.target = target;

    target.comTitleBack = Utils.findRequiredViewAsType(source, R.id.com_title_back, "field 'comTitleBack'", RelativeLayout.class);
    target.textTitle = Utils.findRequiredViewAsType(source, R.id.text_title, "field 'textTitle'", TextView.class);
    target.comTitleSettingIv = Utils.findRequiredViewAsType(source, R.id.com_title_setting_iv, "field 'comTitleSettingIv'", ImageView.class);
    target.comTitleSettingTv = Utils.findRequiredViewAsType(source, R.id.com_title_setting_tv, "field 'comTitleSettingTv'", TextView.class);
    target.searchView = Utils.findRequiredViewAsType(source, R.id.search_view, "field 'searchView'", SearchView.class);
    target.insuranceRv = Utils.findRequiredViewAsType(source, R.id.insurance_rv, "field 'insuranceRv'", RecyclerView.class);
    target.refresh = Utils.findRequiredViewAsType(source, R.id.refresh, "field 'refresh'", SmartRefreshLayout.class);
    target.emptyIv = Utils.findRequiredViewAsType(source, R.id.empty_iv, "field 'emptyIv'", ImageView.class);
    target.emptyTv = Utils.findRequiredViewAsType(source, R.id.empty_tv, "field 'emptyTv'", TextView.class);
    target.emptyDataRl = Utils.findRequiredViewAsType(source, R.id.empty_data_rl, "field 'emptyDataRl'", RelativeLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    InsuranceWaitActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.comTitleBack = null;
    target.textTitle = null;
    target.comTitleSettingIv = null;
    target.comTitleSettingTv = null;
    target.searchView = null;
    target.insuranceRv = null;
    target.refresh = null;
    target.emptyIv = null;
    target.emptyTv = null;
    target.emptyDataRl = null;
  }
}
