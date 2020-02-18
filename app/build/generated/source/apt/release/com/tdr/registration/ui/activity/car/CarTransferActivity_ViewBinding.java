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

public class CarTransferActivity_ViewBinding implements Unbinder {
  private CarTransferActivity target;

  private View view2131231140;

  private View view2131231138;

  @UiThread
  public CarTransferActivity_ViewBinding(CarTransferActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public CarTransferActivity_ViewBinding(final CarTransferActivity target, View source) {
    this.target = target;

    View view;
    target.comTitleBack = Utils.findRequiredViewAsType(source, R.id.com_title_back, "field 'comTitleBack'", RelativeLayout.class);
    target.textTitle = Utils.findRequiredViewAsType(source, R.id.text_title, "field 'textTitle'", TextView.class);
    target.comTitleSettingIv = Utils.findRequiredViewAsType(source, R.id.com_title_setting_iv, "field 'comTitleSettingIv'", ImageView.class);
    target.comTitleSettingTv = Utils.findRequiredViewAsType(source, R.id.com_title_setting_tv, "field 'comTitleSettingTv'", TextView.class);
    target.changePlate = Utils.findRequiredViewAsType(source, R.id.change_plate, "field 'changePlate'", TextView.class);
    target.transferBrand = Utils.findRequiredViewAsType(source, R.id.transfer_brand, "field 'transferBrand'", TextView.class);
    target.transferColor = Utils.findRequiredViewAsType(source, R.id.transfer_color, "field 'transferColor'", TextView.class);
    target.transferPhone = Utils.findRequiredViewAsType(source, R.id.transfer_phone, "field 'transferPhone'", TextView.class);
    target.transferOwer = Utils.findRequiredViewAsType(source, R.id.transfer_ower, "field 'transferOwer'", TextView.class);
    target.transferCard = Utils.findRequiredViewAsType(source, R.id.transfer_card, "field 'transferCard'", TextView.class);
    target.transferName = Utils.findRequiredViewAsType(source, R.id.transfer_name, "field 'transferName'", EditText.class);
    view = Utils.findRequiredView(source, R.id.transfer_card_type, "field 'transferCardType' and method 'onViewClicked'");
    target.transferCardType = Utils.castView(view, R.id.transfer_card_type, "field 'transferCardType'", TextView.class);
    view2131231140 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.transferNewCardnum = Utils.findRequiredViewAsType(source, R.id.transfer_new_cardnum, "field 'transferNewCardnum'", EditText.class);
    target.transferRv = Utils.findRequiredViewAsType(source, R.id.transfer_rv, "field 'transferRv'", RecyclerView.class);
    target.transferNewPhone = Utils.findRequiredViewAsType(source, R.id.transfer_new_phone, "field 'transferNewPhone'", EditText.class);
    target.transferNewPhone2 = Utils.findRequiredViewAsType(source, R.id.transfer_new_phone2, "field 'transferNewPhone2'", EditText.class);
    target.transferAddr = Utils.findRequiredViewAsType(source, R.id.transfer_addr, "field 'transferAddr'", EditText.class);
    target.transferReason = Utils.findRequiredViewAsType(source, R.id.transfer_reason, "field 'transferReason'", EditText.class);
    view = Utils.findRequiredView(source, R.id.transfer_bt, "field 'transferBt' and method 'onViewClicked'");
    target.transferBt = Utils.castView(view, R.id.transfer_bt, "field 'transferBt'", TextView.class);
    view2131231138 = view;
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
    CarTransferActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.comTitleBack = null;
    target.textTitle = null;
    target.comTitleSettingIv = null;
    target.comTitleSettingTv = null;
    target.changePlate = null;
    target.transferBrand = null;
    target.transferColor = null;
    target.transferPhone = null;
    target.transferOwer = null;
    target.transferCard = null;
    target.transferName = null;
    target.transferCardType = null;
    target.transferNewCardnum = null;
    target.transferRv = null;
    target.transferNewPhone = null;
    target.transferNewPhone2 = null;
    target.transferAddr = null;
    target.transferReason = null;
    target.transferBt = null;

    view2131231140.setOnClickListener(null);
    view2131231140 = null;
    view2131231138.setOnClickListener(null);
    view2131231138 = null;
  }
}
