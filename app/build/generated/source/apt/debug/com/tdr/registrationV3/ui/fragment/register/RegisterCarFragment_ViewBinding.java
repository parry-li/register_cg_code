// Generated code from Butter Knife. Do not modify!
package com.tdr.registrationV3.ui.fragment.register;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
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

public class RegisterCarFragment_ViewBinding implements Unbinder {
  private RegisterCarFragment target;

  private View view2131230801;

  private View view2131230802;

  private View view2131230807;

  private View view2131230805;

  private View view2131230808;

  private View view2131230806;

  private View view2131230828;

  private View view2131230829;

  private View view2131230798;

  private View view2131230826;

  private View view2131230825;

  @UiThread
  public RegisterCarFragment_ViewBinding(final RegisterCarFragment target, View source) {
    this.target = target;

    View view;
    target.comTitleBack = Utils.findRequiredViewAsType(source, R.id.com_title_back, "field 'comTitleBack'", RelativeLayout.class);
    target.textTitle = Utils.findRequiredViewAsType(source, R.id.text_title, "field 'textTitle'", TextView.class);
    target.comTitleSettingIv = Utils.findRequiredViewAsType(source, R.id.com_title_setting_iv, "field 'comTitleSettingIv'", ImageView.class);
    target.comTitleSettingTv = Utils.findRequiredViewAsType(source, R.id.com_title_setting_tv, "field 'comTitleSettingTv'", TextView.class);
    target.carPhotoRv = Utils.findRequiredViewAsType(source, R.id.car_photo_rv, "field 'carPhotoRv'", RecyclerView.class);
    view = Utils.findRequiredView(source, R.id.car_brand, "field 'carBrand' and method 'onViewClicked'");
    target.carBrand = Utils.castView(view, R.id.car_brand, "field 'carBrand'", TextView.class);
    view2131230801 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.car_brand_allow, "field 'carBrandAllow' and method 'onViewClicked'");
    target.carBrandAllow = Utils.castView(view, R.id.car_brand_allow, "field 'carBrandAllow'", ImageView.class);
    view2131230802 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.carPlate = Utils.findRequiredViewAsType(source, R.id.car_plate, "field 'carPlate'", EditText.class);
    target.carLabelRv = Utils.findRequiredViewAsType(source, R.id.car_label_rv, "field 'carLabelRv'", RecyclerView.class);
    target.carFrame = Utils.findRequiredViewAsType(source, R.id.car_frame, "field 'carFrame'", EditText.class);
    target.carElectrical = Utils.findRequiredViewAsType(source, R.id.car_electrical, "field 'carElectrical'", EditText.class);
    view = Utils.findRequiredView(source, R.id.car_color_main, "field 'carColorMain' and method 'onViewClicked'");
    target.carColorMain = Utils.castView(view, R.id.car_color_main, "field 'carColorMain'", TextView.class);
    view2131230807 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.car_color1_allow, "field 'carColor1Allow' and method 'onViewClicked'");
    target.carColor1Allow = Utils.castView(view, R.id.car_color1_allow, "field 'carColor1Allow'", ImageView.class);
    view2131230805 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.car_color_minor, "field 'carColorMinor' and method 'onViewClicked'");
    target.carColorMinor = Utils.castView(view, R.id.car_color_minor, "field 'carColorMinor'", TextView.class);
    view2131230808 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.car_color2_allow, "field 'carColor2Allow' and method 'onViewClicked'");
    target.carColor2Allow = Utils.castView(view, R.id.car_color2_allow, "field 'carColor2Allow'", ImageView.class);
    view2131230806 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.car_time, "field 'carColorTime' and method 'onViewClicked'");
    target.carColorTime = Utils.castView(view, R.id.car_time, "field 'carColorTime'", TextView.class);
    view2131230828 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.car_time_allow, "field 'carTimeAllow' and method 'onViewClicked'");
    target.carTimeAllow = Utils.castView(view, R.id.car_time_allow, "field 'carTimeAllow'", ImageView.class);
    view2131230829 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.carFrameX = Utils.findRequiredViewAsType(source, R.id.car_frame_x, "field 'carFrameX'", TextView.class);
    target.carElectricalX = Utils.findRequiredViewAsType(source, R.id.car_electrical_x, "field 'carElectricalX'", TextView.class);
    view = Utils.findRequiredView(source, R.id.button_next, "field 'buttonNext' and method 'onViewClicked'");
    target.buttonNext = Utils.castView(view, R.id.button_next, "field 'buttonNext'", TextView.class);
    view2131230798 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.car_plate_tv, "field 'carPlateTv' and method 'onViewClicked'");
    target.carPlateTv = Utils.castView(view, R.id.car_plate_tv, "field 'carPlateTv'", TextView.class);
    view2131230826 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.car_plate_scan, "field 'carPlateScan' and method 'onViewClicked'");
    target.carPlateScan = Utils.castView(view, R.id.car_plate_scan, "field 'carPlateScan'", ImageView.class);
    view2131230825 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.carPrice = Utils.findRequiredViewAsType(source, R.id.car_price, "field 'carPrice'", EditText.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    RegisterCarFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.comTitleBack = null;
    target.textTitle = null;
    target.comTitleSettingIv = null;
    target.comTitleSettingTv = null;
    target.carPhotoRv = null;
    target.carBrand = null;
    target.carBrandAllow = null;
    target.carPlate = null;
    target.carLabelRv = null;
    target.carFrame = null;
    target.carElectrical = null;
    target.carColorMain = null;
    target.carColor1Allow = null;
    target.carColorMinor = null;
    target.carColor2Allow = null;
    target.carColorTime = null;
    target.carTimeAllow = null;
    target.carFrameX = null;
    target.carElectricalX = null;
    target.buttonNext = null;
    target.carPlateTv = null;
    target.carPlateScan = null;
    target.carPrice = null;

    view2131230801.setOnClickListener(null);
    view2131230801 = null;
    view2131230802.setOnClickListener(null);
    view2131230802 = null;
    view2131230807.setOnClickListener(null);
    view2131230807 = null;
    view2131230805.setOnClickListener(null);
    view2131230805 = null;
    view2131230808.setOnClickListener(null);
    view2131230808 = null;
    view2131230806.setOnClickListener(null);
    view2131230806 = null;
    view2131230828.setOnClickListener(null);
    view2131230828 = null;
    view2131230829.setOnClickListener(null);
    view2131230829 = null;
    view2131230798.setOnClickListener(null);
    view2131230798 = null;
    view2131230826.setOnClickListener(null);
    view2131230826 = null;
    view2131230825.setOnClickListener(null);
    view2131230825 = null;
  }
}
