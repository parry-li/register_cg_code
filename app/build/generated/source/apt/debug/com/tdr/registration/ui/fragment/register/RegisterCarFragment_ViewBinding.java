// Generated code from Butter Knife. Do not modify!
package com.tdr.registration.ui.fragment.register;

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
import com.tdr.registration.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class RegisterCarFragment_ViewBinding implements Unbinder {
  private RegisterCarFragment target;

  private View view2131230788;

  private View view2131230789;

  private View view2131230794;

  private View view2131230792;

  private View view2131230795;

  private View view2131230793;

  private View view2131230796;

  private View view2131230810;

  private View view2131230785;

  private View view2131230808;

  private View view2131230807;

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
    view2131230788 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.car_brand_allow, "field 'carBrandAllow' and method 'onViewClicked'");
    target.carBrandAllow = Utils.castView(view, R.id.car_brand_allow, "field 'carBrandAllow'", ImageView.class);
    view2131230789 = view;
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
    view2131230794 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.car_color1_allow, "field 'carColor1Allow' and method 'onViewClicked'");
    target.carColor1Allow = Utils.castView(view, R.id.car_color1_allow, "field 'carColor1Allow'", ImageView.class);
    view2131230792 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.car_color_minor, "field 'carColorMinor' and method 'onViewClicked'");
    target.carColorMinor = Utils.castView(view, R.id.car_color_minor, "field 'carColorMinor'", TextView.class);
    view2131230795 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.car_color2_allow, "field 'carColor2Allow' and method 'onViewClicked'");
    target.carColor2Allow = Utils.castView(view, R.id.car_color2_allow, "field 'carColor2Allow'", ImageView.class);
    view2131230793 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.car_color_time, "field 'carColorTime' and method 'onViewClicked'");
    target.carColorTime = Utils.castView(view, R.id.car_color_time, "field 'carColorTime'", TextView.class);
    view2131230796 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.car_time_allow, "field 'carTimeAllow' and method 'onViewClicked'");
    target.carTimeAllow = Utils.castView(view, R.id.car_time_allow, "field 'carTimeAllow'", ImageView.class);
    view2131230810 = view;
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
    view2131230785 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.car_plate_tv, "field 'carPlateTv' and method 'onViewClicked'");
    target.carPlateTv = Utils.castView(view, R.id.car_plate_tv, "field 'carPlateTv'", TextView.class);
    view2131230808 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.car_plate_scan, "field 'carPlateScan' and method 'onViewClicked'");
    target.carPlateScan = Utils.castView(view, R.id.car_plate_scan, "field 'carPlateScan'", ImageView.class);
    view2131230807 = view;
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

    view2131230788.setOnClickListener(null);
    view2131230788 = null;
    view2131230789.setOnClickListener(null);
    view2131230789 = null;
    view2131230794.setOnClickListener(null);
    view2131230794 = null;
    view2131230792.setOnClickListener(null);
    view2131230792 = null;
    view2131230795.setOnClickListener(null);
    view2131230795 = null;
    view2131230793.setOnClickListener(null);
    view2131230793 = null;
    view2131230796.setOnClickListener(null);
    view2131230796 = null;
    view2131230810.setOnClickListener(null);
    view2131230810 = null;
    view2131230785.setOnClickListener(null);
    view2131230785 = null;
    view2131230808.setOnClickListener(null);
    view2131230808 = null;
    view2131230807.setOnClickListener(null);
    view2131230807 = null;
  }
}