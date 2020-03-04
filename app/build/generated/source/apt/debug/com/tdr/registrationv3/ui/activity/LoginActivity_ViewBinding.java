// Generated code from Butter Knife. Do not modify!
package com.tdr.registrationv3.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.tdr.registrationv3.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class LoginActivity_ViewBinding implements Unbinder {
  private LoginActivity target;

  private View view2131230995;

  private View view2131230994;

  @UiThread
  public LoginActivity_ViewBinding(LoginActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public LoginActivity_ViewBinding(final LoginActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.login_city, "field 'loginCity' and method 'onViewClicked'");
    target.loginCity = Utils.castView(view, R.id.login_city, "field 'loginCity'", LinearLayout.class);
    view2131230995 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.loginName = Utils.findRequiredViewAsType(source, R.id.login_name, "field 'loginName'", EditText.class);
    target.loginNameLine = Utils.findRequiredView(source, R.id.login_name_line, "field 'loginNameLine'");
    target.loginPwd = Utils.findRequiredViewAsType(source, R.id.login_pwd, "field 'loginPwd'", EditText.class);
    target.loginPwdLine = Utils.findRequiredView(source, R.id.login_pwd_line, "field 'loginPwdLine'");
    view = Utils.findRequiredView(source, R.id.login_button, "field 'loginButton' and method 'onViewClicked'");
    target.loginButton = Utils.castView(view, R.id.login_button, "field 'loginButton'", Button.class);
    view2131230994 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.cityName = Utils.findRequiredViewAsType(source, R.id.city_name, "field 'cityName'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    LoginActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.loginCity = null;
    target.loginName = null;
    target.loginNameLine = null;
    target.loginPwd = null;
    target.loginPwdLine = null;
    target.loginButton = null;
    target.cityName = null;

    view2131230995.setOnClickListener(null);
    view2131230995 = null;
    view2131230994.setOnClickListener(null);
    view2131230994 = null;
  }
}
