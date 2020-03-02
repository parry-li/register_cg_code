// Generated code from Butter Knife. Do not modify!
package com.tdr.registrationV3.ui.activity.car;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.tdr.registrationV3.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CarScrapActivity_ViewBinding implements Unbinder {
  private CarScrapActivity target;

  private View view2131231099;

  private View view2131231096;

  @UiThread
  public CarScrapActivity_ViewBinding(CarScrapActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public CarScrapActivity_ViewBinding(final CarScrapActivity target, View source) {
    this.target = target;

    View view;
    target.comTitleBack = Utils.findRequiredViewAsType(source, R.id.com_title_back, "field 'comTitleBack'", RelativeLayout.class);
    target.textTitle = Utils.findRequiredViewAsType(source, R.id.text_title, "field 'textTitle'", TextView.class);
    target.comTitleSettingIv = Utils.findRequiredViewAsType(source, R.id.com_title_setting_iv, "field 'comTitleSettingIv'", ImageView.class);
    target.comTitleSettingTv = Utils.findRequiredViewAsType(source, R.id.com_title_setting_tv, "field 'comTitleSettingTv'", TextView.class);
    target.changePlate = Utils.findRequiredViewAsType(source, R.id.change_plate, "field 'changePlate'", TextView.class);
    target.changeBrand = Utils.findRequiredViewAsType(source, R.id.change_brand, "field 'changeBrand'", TextView.class);
    target.changeColor = Utils.findRequiredViewAsType(source, R.id.change_color, "field 'changeColor'", TextView.class);
    target.changePhone = Utils.findRequiredViewAsType(source, R.id.change_phone, "field 'changePhone'", TextView.class);
    target.changeOwer = Utils.findRequiredViewAsType(source, R.id.change_ower, "field 'changeOwer'", TextView.class);
    target.changeCard = Utils.findRequiredViewAsType(source, R.id.change_card, "field 'changeCard'", TextView.class);
    target.scrapName = Utils.findRequiredViewAsType(source, R.id.scrap_name, "field 'scrapName'", EditText.class);
    view = Utils.findRequiredView(source, R.id.scrap_time, "field 'scrapTime' and method 'onViewClicked'");
    target.scrapTime = Utils.castView(view, R.id.scrap_time, "field 'scrapTime'", TextView.class);
    view2131231099 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.scrapReason = Utils.findRequiredViewAsType(source, R.id.scrap_reason, "field 'scrapReason'", EditText.class);
    view = Utils.findRequiredView(source, R.id.scrap_button, "field 'scrapButton' and method 'onViewClicked'");
    target.scrapButton = Utils.castView(view, R.id.scrap_button, "field 'scrapButton'", TextView.class);
    view2131231096 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    CarScrapActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.comTitleBack = null;
    target.textTitle = null;
    target.comTitleSettingIv = null;
    target.comTitleSettingTv = null;
    target.changePlate = null;
    target.changeBrand = null;
    target.changeColor = null;
    target.changePhone = null;
    target.changeOwer = null;
    target.changeCard = null;
    target.scrapName = null;
    target.scrapTime = null;
    target.scrapReason = null;
    target.scrapButton = null;

    view2131231099.setOnClickListener(null);
    view2131231099 = null;
    view2131231096.setOnClickListener(null);
    view2131231096 = null;
  }
}
