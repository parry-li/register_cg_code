// Generated code from Butter Knife. Do not modify!
package com.tdr.registrationv3.ui.fragment.register;

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
import java.lang.IllegalStateException;
import java.lang.Override;

public class ChangeRegisterPeopleFragment_ViewBinding implements Unbinder {
  private ChangeRegisterPeopleFragment target;

  private View view2131231057;

  private View view2131231058;

  private View view2131230798;

  @UiThread
  public ChangeRegisterPeopleFragment_ViewBinding(final ChangeRegisterPeopleFragment target,
      View source) {
    this.target = target;

    View view;
    target.comTitleBack = Utils.findRequiredViewAsType(source, R.id.com_title_back, "field 'comTitleBack'", RelativeLayout.class);
    target.textTitle = Utils.findRequiredViewAsType(source, R.id.text_title, "field 'textTitle'", TextView.class);
    target.comTitleSettingIv = Utils.findRequiredViewAsType(source, R.id.com_title_setting_iv, "field 'comTitleSettingIv'", ImageView.class);
    target.comTitleSettingTv = Utils.findRequiredViewAsType(source, R.id.com_title_setting_tv, "field 'comTitleSettingTv'", TextView.class);
    target.peopleName = Utils.findRequiredViewAsType(source, R.id.people_name, "field 'peopleName'", EditText.class);
    view = Utils.findRequiredView(source, R.id.people_card, "field 'peopleCard' and method 'onViewClicked'");
    target.peopleCard = Utils.castView(view, R.id.people_card, "field 'peopleCard'", TextView.class);
    view2131231057 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.people_card_allow, "field 'peopleCardAllow' and method 'onViewClicked'");
    target.peopleCardAllow = Utils.castView(view, R.id.people_card_allow, "field 'peopleCardAllow'", ImageView.class);
    view2131231058 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.peopleCardNum = Utils.findRequiredViewAsType(source, R.id.people_card_num, "field 'peopleCardNum'", EditText.class);
    target.peoplePhone1 = Utils.findRequiredViewAsType(source, R.id.people_phone1, "field 'peoplePhone1'", EditText.class);
    target.peoplePhone2 = Utils.findRequiredViewAsType(source, R.id.people_phone2, "field 'peoplePhone2'", EditText.class);
    target.peopleAdr = Utils.findRequiredViewAsType(source, R.id.people_adr, "field 'peopleAdr'", EditText.class);
    target.peopleRemark = Utils.findRequiredViewAsType(source, R.id.people_remark, "field 'peopleRemark'", EditText.class);
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
    ChangeRegisterPeopleFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.comTitleBack = null;
    target.textTitle = null;
    target.comTitleSettingIv = null;
    target.comTitleSettingTv = null;
    target.peopleName = null;
    target.peopleCard = null;
    target.peopleCardAllow = null;
    target.peopleCardNum = null;
    target.peoplePhone1 = null;
    target.peoplePhone2 = null;
    target.peopleAdr = null;
    target.peopleRemark = null;
    target.buttonNext = null;

    view2131231057.setOnClickListener(null);
    view2131231057 = null;
    view2131231058.setOnClickListener(null);
    view2131231058 = null;
    view2131230798.setOnClickListener(null);
    view2131230798 = null;
  }
}
