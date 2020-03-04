// Generated code from Butter Knife. Do not modify!
package com.tdr.registrationv3.ui.activity.car;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.tdr.registrationv3.R;
import com.tdr.registrationv3.view.NoScrollViewPager;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ChangeRegisterActivity_ViewBinding implements Unbinder {
  private ChangeRegisterMainActivity target;

  @UiThread
  public ChangeRegisterActivity_ViewBinding(ChangeRegisterMainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ChangeRegisterActivity_ViewBinding(ChangeRegisterMainActivity target, View source) {
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
