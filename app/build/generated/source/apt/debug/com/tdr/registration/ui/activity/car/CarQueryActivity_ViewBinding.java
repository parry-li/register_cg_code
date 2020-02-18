// Generated code from Butter Knife. Do not modify!
package com.tdr.registration.ui.activity.car;

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
import com.tdr.registration.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CarQueryActivity_ViewBinding implements Unbinder {
  private CarQueryActivity target;

  private View view2131230790;

  @UiThread
  public CarQueryActivity_ViewBinding(CarQueryActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public CarQueryActivity_ViewBinding(final CarQueryActivity target, View source) {
    this.target = target;

    View view;
    target.comTitleBack = Utils.findRequiredViewAsType(source, R.id.com_title_back, "field 'comTitleBack'", RelativeLayout.class);
    target.textTitle = Utils.findRequiredViewAsType(source, R.id.text_title, "field 'textTitle'", TextView.class);
    target.comTitleSettingIv = Utils.findRequiredViewAsType(source, R.id.com_title_setting_iv, "field 'comTitleSettingIv'", ImageView.class);
    target.comTitleSettingTv = Utils.findRequiredViewAsType(source, R.id.com_title_setting_tv, "field 'comTitleSettingTv'", TextView.class);
    target.plateNumber = Utils.findRequiredViewAsType(source, R.id.plate_number, "field 'plateNumber'", EditText.class);
    target.carId = Utils.findRequiredViewAsType(source, R.id.car_id, "field 'carId'", EditText.class);
    view = Utils.findRequiredView(source, R.id.button_confirm, "field 'buttonConfirm' and method 'onViewClicked'");
    target.buttonConfirm = Utils.castView(view, R.id.button_confirm, "field 'buttonConfirm'", TextView.class);
    view2131230790 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked();
      }
    });
    target.lineView = Utils.findRequiredView(source, R.id.line_view, "field 'lineView'");
  }

  @Override
  @CallSuper
  public void unbind() {
    CarQueryActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.comTitleBack = null;
    target.textTitle = null;
    target.comTitleSettingIv = null;
    target.comTitleSettingTv = null;
    target.plateNumber = null;
    target.carId = null;
    target.buttonConfirm = null;
    target.lineView = null;

    view2131230790.setOnClickListener(null);
    view2131230790 = null;
  }
}
