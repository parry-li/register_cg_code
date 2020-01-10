// Generated code from Butter Knife. Do not modify!
package com.tdr.registration.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.tdr.registration.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class BleListActivity_ViewBinding implements Unbinder {
  private BleListActivity target;

  @UiThread
  public BleListActivity_ViewBinding(BleListActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public BleListActivity_ViewBinding(BleListActivity target, View source) {
    this.target = target;

    target.image_back = Utils.findRequiredViewAsType(source, R.id.image_back, "field 'image_back'", ImageView.class);
    target.text_title = Utils.findRequiredViewAsType(source, R.id.text_title, "field 'text_title'", TextView.class);
    target.text_refresh = Utils.findRequiredViewAsType(source, R.id.text_deal, "field 'text_refresh'", TextView.class);
    target.relative_title = Utils.findRequiredViewAsType(source, R.id.relative_title, "field 'relative_title'", RelativeLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    BleListActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.image_back = null;
    target.text_title = null;
    target.text_refresh = null;
    target.relative_title = null;
  }
}
