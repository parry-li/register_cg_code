// Generated code from Butter Knife. Do not modify!
package com.tdr.registrationV3.ui.activity.car;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.tdr.registrationV3.R;
import com.tdr.registrationV3.view.NoScrollViewPager;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ChangeRegisterMainActivity_ViewBinding implements Unbinder {
  private ChangeRegisterMainActivity target;

  @UiThread
  public ChangeRegisterMainActivity_ViewBinding(ChangeRegisterMainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ChangeRegisterMainActivity_ViewBinding(ChangeRegisterMainActivity target, View source) {
    this.target = target;

    target.registerVp = Utils.findRequiredViewAsType(source, R.id.register_vp, "field 'registerVp'", NoScrollViewPager.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ChangeRegisterMainActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.registerVp = null;
  }
}