// Generated code from Butter Knife. Do not modify!
package com.tdr.registration.ui.activity.car;

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

public class CarChangeActivity_ViewBinding implements Unbinder {
  private CarChangeActivity target;

  private View view2131230828;

  @UiThread
  public CarChangeActivity_ViewBinding(CarChangeActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public CarChangeActivity_ViewBinding(final CarChangeActivity target, View source) {
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
    target.changeTypeRv = Utils.findRequiredViewAsType(source, R.id.change_type_rv, "field 'changeTypeRv'", RecyclerView.class);
    target.changePhotoRv = Utils.findRequiredViewAsType(source, R.id.change_photo_rv, "field 'changePhotoRv'", RecyclerView.class);
    target.changeContentRv = Utils.findRequiredViewAsType(source, R.id.change_content_rv, "field 'changeContentRv'", RecyclerView.class);
    target.changeReason = Utils.findRequiredViewAsType(source, R.id.change_reason, "field 'changeReason'", EditText.class);
    view = Utils.findRequiredView(source, R.id.change_button, "field 'changeButton' and method 'onViewClicked'");
    target.changeButton = Utils.castView(view, R.id.change_button, "field 'changeButton'", TextView.class);
    view2131230828 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    CarChangeActivity target = this.target;
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
    target.changeTypeRv = null;
    target.changePhotoRv = null;
    target.changeContentRv = null;
    target.changeReason = null;
    target.changeButton = null;

    view2131230828.setOnClickListener(null);
    view2131230828 = null;
  }
}
