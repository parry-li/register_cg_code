// Generated code from Butter Knife. Do not modify!
package com.tdr.registration.ui.activity.car;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.tdr.registration.R;
import com.tdr.registration.view.NoScrollViewPager;
import java.lang.IllegalStateException;
import java.lang.Override;

public class RegisterMainActivity_ViewBinding implements Unbinder {
  private RegisterMainActivity target;

  @UiThread
  public RegisterMainActivity_ViewBinding(RegisterMainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public RegisterMainActivity_ViewBinding(RegisterMainActivity target, View source) {
    this.target = target;

    target.registerVp = Utils.findRequiredViewAsType(source, R.id.register_vp, "field 'registerVp'", NoScrollViewPager.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    RegisterMainActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.registerVp = null;
  }
}
