// Generated code from Butter Knife. Do not modify!
package com.tdr.registration.ui.activity.me;

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

public class PasswordActivity_ViewBinding implements Unbinder {
  private PasswordActivity target;

  private View view2131230785;

  @UiThread
  public PasswordActivity_ViewBinding(PasswordActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public PasswordActivity_ViewBinding(final PasswordActivity target, View source) {
    this.target = target;

    View view;
    target.comTitleBack = Utils.findRequiredViewAsType(source, R.id.com_title_back, "field 'comTitleBack'", RelativeLayout.class);
    target.textTitle = Utils.findRequiredViewAsType(source, R.id.text_title, "field 'textTitle'", TextView.class);
    target.comTitleSettingIv = Utils.findRequiredViewAsType(source, R.id.com_title_setting_iv, "field 'comTitleSettingIv'", ImageView.class);
    target.comTitleSettingTv = Utils.findRequiredViewAsType(source, R.id.com_title_setting_tv, "field 'comTitleSettingTv'", TextView.class);
    target.passwordOld = Utils.findRequiredViewAsType(source, R.id.password_old, "field 'passwordOld'", EditText.class);
    target.passwordOldV = Utils.findRequiredView(source, R.id.password_old_v, "field 'passwordOldV'");
    target.passwordNew = Utils.findRequiredViewAsType(source, R.id.password_new, "field 'passwordNew'", EditText.class);
    target.passwordNewV = Utils.findRequiredView(source, R.id.password_new_v, "field 'passwordNewV'");
    target.passwordConfirm = Utils.findRequiredViewAsType(source, R.id.password_confirm, "field 'passwordConfirm'", EditText.class);
    target.passwordConfirmV = Utils.findRequiredView(source, R.id.password_confirm_v, "field 'passwordConfirmV'");
    view = Utils.findRequiredView(source, R.id.button_next, "field 'buttonNext' and method 'onViewClicked'");
    target.buttonNext = Utils.castView(view, R.id.button_next, "field 'buttonNext'", TextView.class);
    view2131230785 = view;
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
    PasswordActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.comTitleBack = null;
    target.textTitle = null;
    target.comTitleSettingIv = null;
    target.comTitleSettingTv = null;
    target.passwordOld = null;
    target.passwordOldV = null;
    target.passwordNew = null;
    target.passwordNewV = null;
    target.passwordConfirm = null;
    target.passwordConfirmV = null;
    target.buttonNext = null;

    view2131230785.setOnClickListener(null);
    view2131230785 = null;
  }
}
