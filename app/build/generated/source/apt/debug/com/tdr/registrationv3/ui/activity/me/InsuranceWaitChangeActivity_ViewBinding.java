// Generated code from Butter Knife. Do not modify!
package com.tdr.registrationv3.ui.activity.me;

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
import com.tdr.registrationv3.R;
import com.tdr.registrationv3.ui.activity.insurance.InsuranceWaitChangeActivity;

import java.lang.IllegalStateException;
import java.lang.Override;

public class InsuranceWaitChangeActivity_ViewBinding implements Unbinder {
  private InsuranceWaitChangeActivity target;

  private View view2131231220;

  private View view2131231221;

  private View view2131231226;

  private View view2131231227;

  private View view2131231228;

  private View view2131231229;

  private View view2131231222;

  private View view2131231223;

  private View view2131230798;

  @UiThread
  public InsuranceWaitChangeActivity_ViewBinding(InsuranceWaitChangeActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public InsuranceWaitChangeActivity_ViewBinding(final InsuranceWaitChangeActivity target,
      View source) {
    this.target = target;

    View view;
    target.comTitleBack = Utils.findRequiredViewAsType(source, R.id.com_title_back, "field 'comTitleBack'", RelativeLayout.class);
    target.textTitle = Utils.findRequiredViewAsType(source, R.id.text_title, "field 'textTitle'", TextView.class);
    target.comTitleSettingIv = Utils.findRequiredViewAsType(source, R.id.com_title_setting_iv, "field 'comTitleSettingIv'", ImageView.class);
    target.comTitleSettingTv = Utils.findRequiredViewAsType(source, R.id.com_title_setting_tv, "field 'comTitleSettingTv'", TextView.class);
    view = Utils.findRequiredView(source, R.id.wait_brand, "field 'waitBrand' and method 'onViewClicked'");
    target.waitBrand = Utils.castView(view, R.id.wait_brand, "field 'waitBrand'", TextView.class);
    view2131231220 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.wait_brand_arrow, "field 'waitBrandArrow' and method 'onViewClicked'");
    target.waitBrandArrow = Utils.castView(view, R.id.wait_brand_arrow, "field 'waitBrandArrow'", ImageView.class);
    view2131231221 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.waitPlate = Utils.findRequiredViewAsType(source, R.id.wait_plate, "field 'waitPlate'", EditText.class);
    target.waitShelves = Utils.findRequiredViewAsType(source, R.id.wait_shelves, "field 'waitShelves'", EditText.class);
    target.waitEngine = Utils.findRequiredViewAsType(source, R.id.wait_engine, "field 'waitEngine'", EditText.class);
    view = Utils.findRequiredView(source, R.id.wait_color1, "field 'waitColor1' and method 'onViewClicked'");
    target.waitColor1 = Utils.castView(view, R.id.wait_color1, "field 'waitColor1'", TextView.class);
    view2131231226 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.wait_color1_arrow, "field 'waitColor1Arrow' and method 'onViewClicked'");
    target.waitColor1Arrow = Utils.castView(view, R.id.wait_color1_arrow, "field 'waitColor1Arrow'", ImageView.class);
    view2131231227 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.wait_color2, "field 'waitColor2' and method 'onViewClicked'");
    target.waitColor2 = Utils.castView(view, R.id.wait_color2, "field 'waitColor2'", TextView.class);
    view2131231228 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.wait_color2_arrow, "field 'waitColor2Arrow' and method 'onViewClicked'");
    target.waitColor2Arrow = Utils.castView(view, R.id.wait_color2_arrow, "field 'waitColor2Arrow'", ImageView.class);
    view2131231229 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.waitOwername = Utils.findRequiredViewAsType(source, R.id.wait_owername, "field 'waitOwername'", EditText.class);
    view = Utils.findRequiredView(source, R.id.wait_cardType, "field 'waitCardType' and method 'onViewClicked'");
    target.waitCardType = Utils.castView(view, R.id.wait_cardType, "field 'waitCardType'", TextView.class);
    view2131231222 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.wait_cardType_arrow, "field 'waitCardTypeArrow' and method 'onViewClicked'");
    target.waitCardTypeArrow = Utils.castView(view, R.id.wait_cardType_arrow, "field 'waitCardTypeArrow'", ImageView.class);
    view2131231223 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.waitCardnum = Utils.findRequiredViewAsType(source, R.id.wait_cardnum, "field 'waitCardnum'", EditText.class);
    target.waitPhone = Utils.findRequiredViewAsType(source, R.id.wait_phone, "field 'waitPhone'", EditText.class);
    target.waitAdr = Utils.findRequiredViewAsType(source, R.id.wait_adr, "field 'waitAdr'", EditText.class);
    view = Utils.findRequiredView(source, R.id.button_next, "field 'buttonNext' and method 'onViewClicked'");
    target.buttonNext = Utils.castView(view, R.id.button_next, "field 'buttonNext'", TextView.class);
    view2131230798 = view;
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
    InsuranceWaitChangeActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.comTitleBack = null;
    target.textTitle = null;
    target.comTitleSettingIv = null;
    target.comTitleSettingTv = null;
    target.waitBrand = null;
    target.waitBrandArrow = null;
    target.waitPlate = null;
    target.waitShelves = null;
    target.waitEngine = null;
    target.waitColor1 = null;
    target.waitColor1Arrow = null;
    target.waitColor2 = null;
    target.waitColor2Arrow = null;
    target.waitOwername = null;
    target.waitCardType = null;
    target.waitCardTypeArrow = null;
    target.waitCardnum = null;
    target.waitPhone = null;
    target.waitAdr = null;
    target.buttonNext = null;

    view2131231220.setOnClickListener(null);
    view2131231220 = null;
    view2131231221.setOnClickListener(null);
    view2131231221 = null;
    view2131231226.setOnClickListener(null);
    view2131231226 = null;
    view2131231227.setOnClickListener(null);
    view2131231227 = null;
    view2131231228.setOnClickListener(null);
    view2131231228 = null;
    view2131231229.setOnClickListener(null);
    view2131231229 = null;
    view2131231222.setOnClickListener(null);
    view2131231222 = null;
    view2131231223.setOnClickListener(null);
    view2131231223 = null;
    view2131230798.setOnClickListener(null);
    view2131230798 = null;
  }
}
