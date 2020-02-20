// Generated code from Butter Knife. Do not modify!
package com.tdr.registration.ui.activity.home;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.tdr.registration.R;
import com.tdr.registration.view.SearchView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class StatisticsUnitActivity_ViewBinding implements Unbinder {
  private StatisticsUnitActivity target;

  @UiThread
  public StatisticsUnitActivity_ViewBinding(StatisticsUnitActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public StatisticsUnitActivity_ViewBinding(StatisticsUnitActivity target, View source) {
    this.target = target;

    target.comTitleBack = Utils.findRequiredViewAsType(source, R.id.com_title_back, "field 'comTitleBack'", RelativeLayout.class);
    target.textTitle = Utils.findRequiredViewAsType(source, R.id.text_title, "field 'textTitle'", TextView.class);
    target.comTitleSettingIv = Utils.findRequiredViewAsType(source, R.id.com_title_setting_iv, "field 'comTitleSettingIv'", ImageView.class);
    target.comTitleSettingTv = Utils.findRequiredViewAsType(source, R.id.com_title_setting_tv, "field 'comTitleSettingTv'", TextView.class);
    target.unitRv = Utils.findRequiredViewAsType(source, R.id.unit_rv, "field 'unitRv'", RecyclerView.class);
    target.emptyDataRl = Utils.findRequiredViewAsType(source, R.id.empty_data_rl, "field 'emptyDataRl'", RelativeLayout.class);
    target.searchView = Utils.findRequiredViewAsType(source, R.id.search_view, "field 'searchView'", SearchView.class);
    target.allTv = Utils.findRequiredViewAsType(source, R.id.all_tv, "field 'allTv'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    StatisticsUnitActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.comTitleBack = null;
    target.textTitle = null;
    target.comTitleSettingIv = null;
    target.comTitleSettingTv = null;
    target.unitRv = null;
    target.emptyDataRl = null;
    target.searchView = null;
    target.allTv = null;
  }
}
