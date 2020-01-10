// Generated code from Butter Knife. Do not modify!
package com.tdr.registration;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class LoginActivity_ViewBinding implements Unbinder {
  private LoginActivity target;

  @UiThread
  public LoginActivity_ViewBinding(LoginActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public LoginActivity_ViewBinding(LoginActivity target, View source) {
    this.target = target;

    target.loginName = Utils.findRequiredViewAsType(source, R.id.login_name, "field 'loginName'", EditText.class);
    target.loginBt = Utils.findRequiredViewAsType(source, R.id.login_bt, "field 'loginBt'", Button.class);
    target.loginPwd = Utils.findRequiredViewAsType(source, R.id.login_pwd, "field 'loginPwd'", EditText.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    LoginActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.loginName = null;
    target.loginBt = null;
    target.loginPwd = null;
  }
}
