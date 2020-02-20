// Generated code from Butter Knife. Do not modify!
package com.tdr.registration.ui.activity.home;

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

public class PersonageStatisticsActivity_ViewBinding implements Unbinder {
  private PersonageStatisticsActivity target;

  private View view2131231129;

  private View view2131230898;

  private View view2131231058;

  private View view2131230778;

  private View view2131230779;

  @UiThread
  public PersonageStatisticsActivity_ViewBinding(PersonageStatisticsActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public PersonageStatisticsActivity_ViewBinding(final PersonageStatisticsActivity target,
      View source) {
    this.target = target;

    View view;
    target.comTitleBack = Utils.findRequiredViewAsType(source, R.id.com_title_back, "field 'comTitleBack'", RelativeLayout.class);
    target.textTitle = Utils.findRequiredViewAsType(source, R.id.text_title, "field 'textTitle'", TextView.class);
    view = Utils.findRequiredView(source, R.id.start_time, "field 'startTimeTV' and method 'onViewClicked'");
    target.startTimeTV = Utils.castView(view, R.id.start_time, "field 'startTimeTV'", TextView.class);
    view2131231129 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.end_time, "field 'endTimeTV' and method 'onViewClicked'");
    target.endTimeTV = Utils.castView(view, R.id.end_time, "field 'endTimeTV'", TextView.class);
    view2131230898 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.query, "field 'query' and method 'onViewClicked'");
    target.query = Utils.castView(view, R.id.query, "field 'query'", TextView.class);
    view2131231058 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.baseName = Utils.findRequiredViewAsType(source, R.id.base_name, "field 'baseName'", TextView.class);
    target.baseNo = Utils.findRequiredViewAsType(source, R.id.base_no, "field 'baseNo'", TextView.class);
    view = Utils.findRequiredView(source, R.id.base_unit, "field 'baseUnit' and method 'onViewClicked'");
    target.baseUnit = Utils.castView(view, R.id.base_unit, "field 'baseUnit'", TextView.class);
    view2131230778 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.baseCarNum = Utils.findRequiredViewAsType(source, R.id.base_car_num, "field 'baseCarNum'", TextView.class);
    target.noStolenUnm = Utils.findRequiredViewAsType(source, R.id.no_stolen_unm, "field 'noStolenUnm'", TextView.class);
    target.stolenUnm = Utils.findRequiredViewAsType(source, R.id.stolen_unm, "field 'stolenUnm'", TextView.class);
    target.plateChange = Utils.findRequiredViewAsType(source, R.id.plate_change, "field 'plateChange'", TextView.class);
    target.pfNum = Utils.findRequiredViewAsType(source, R.id.pf_num, "field 'pfNum'", TextView.class);
    target.allMoney = Utils.findRequiredViewAsType(source, R.id.all_money, "field 'allMoney'", TextView.class);
    target.baseLl = Utils.findRequiredViewAsType(source, R.id.base_ll, "field 'baseLl'", LinearLayout.class);
    target.statisticsRv = Utils.findRequiredViewAsType(source, R.id.statistics_rv, "field 'statisticsRv'", RecyclerView.class);
    target.emptyDataRl = Utils.findRequiredViewAsType(source, R.id.empty_data_rl, "field 'emptyDataRl'", RelativeLayout.class);
    view = Utils.findRequiredView(source, R.id.base_unit_arrow, "field 'baseUnitArrow' and method 'onViewClicked'");
    target.baseUnitArrow = Utils.castView(view, R.id.base_unit_arrow, "field 'baseUnitArrow'", ImageView.class);
    view2131230779 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.newSales = Utils.findRequiredViewAsType(source, R.id.new_sales, "field 'newSales'", TextView.class);
    target.newRoad = Utils.findRequiredViewAsType(source, R.id.new_Road, "field 'newRoad'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    PersonageStatisticsActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.comTitleBack = null;
    target.textTitle = null;
    target.startTimeTV = null;
    target.endTimeTV = null;
    target.query = null;
    target.baseName = null;
    target.baseNo = null;
    target.baseUnit = null;
    target.baseCarNum = null;
    target.noStolenUnm = null;
    target.stolenUnm = null;
    target.plateChange = null;
    target.pfNum = null;
    target.allMoney = null;
    target.baseLl = null;
    target.statisticsRv = null;
    target.emptyDataRl = null;
    target.baseUnitArrow = null;
    target.newSales = null;
    target.newRoad = null;

    view2131231129.setOnClickListener(null);
    view2131231129 = null;
    view2131230898.setOnClickListener(null);
    view2131230898 = null;
    view2131231058.setOnClickListener(null);
    view2131231058 = null;
    view2131230778.setOnClickListener(null);
    view2131230778 = null;
    view2131230779.setOnClickListener(null);
    view2131230779 = null;
  }
}
