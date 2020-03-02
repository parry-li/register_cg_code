// Generated code from Butter Knife. Do not modify!
package com.tdr.registrationV3.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.tdr.registrationV3.R;
import com.tdr.registrationV3.view.SearchView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CodeTableActivity_ViewBinding implements Unbinder {
  private CodeTableActivity target;

  @UiThread
  public CodeTableActivity_ViewBinding(CodeTableActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public CodeTableActivity_ViewBinding(CodeTableActivity target, View source) {
    this.target = target;

    target.comTitleBack = Utils.findRequiredViewAsType(source, R.id.com_title_back, "field 'comTitleBack'", RelativeLayout.class);
    target.textTitle = Utils.findRequiredViewAsType(source, R.id.text_title, "field 'textTitle'", TextView.class);
    target.comTitleSettingIv = Utils.findRequiredViewAsType(source, R.id.com_title_setting_iv, "field 'comTitleSettingIv'", ImageView.class);
    target.comTitleSettingTv = Utils.findRequiredViewAsType(source, R.id.com_title_setting_tv, "field 'comTitleSettingTv'", TextView.class);
    target.searchView = Utils.findRequiredViewAsType(source, R.id.search_view, "field 'searchView'", SearchView.class);
    target.allRv = Utils.findRequiredViewAsType(source, R.id.all_rv, "field 'allRv'", ListView.class);
    target.resultRv = Utils.findRequiredViewAsType(source, R.id.result_rv, "field 'resultRv'", RecyclerView.class);
    target.emptyIv = Utils.findRequiredViewAsType(source, R.id.empty_iv, "field 'emptyIv'", ImageView.class);
    target.emptyTv = Utils.findRequiredViewAsType(source, R.id.empty_tv, "field 'emptyTv'", TextView.class);
    target.emptyDataRl = Utils.findRequiredViewAsType(source, R.id.empty_data_rl, "field 'emptyDataRl'", RelativeLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    CodeTableActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.comTitleBack = null;
    target.textTitle = null;
    target.comTitleSettingIv = null;
    target.comTitleSettingTv = null;
    target.searchView = null;
    target.allRv = null;
    target.resultRv = null;
    target.emptyIv = null;
    target.emptyTv = null;
    target.emptyDataRl = null;
  }
}
