// Generated code from Butter Knife. Do not modify!
package com.tdr.registrationV3.ui.activity.scan;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.tdr.registrationV3.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class QRCodeScanActivity_ViewBinding implements Unbinder {
  private QRCodeScanActivity target;

  @UiThread
  public QRCodeScanActivity_ViewBinding(QRCodeScanActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public QRCodeScanActivity_ViewBinding(QRCodeScanActivity target, View source) {
    this.target = target;

    target.flMyContainer = Utils.findRequiredViewAsType(source, R.id.fl_my_container, "field 'flMyContainer'", FrameLayout.class);
    target.TVPrompt = Utils.findRequiredViewAsType(source, R.id.TV_Prompt, "field 'TVPrompt'", TextView.class);
    target.IVBack = Utils.findRequiredViewAsType(source, R.id.IV_Back, "field 'IVBack'", ImageView.class);
    target.scanInput = Utils.findRequiredViewAsType(source, R.id.scan_input, "field 'scanInput'", LinearLayout.class);
    target.scanLight = Utils.findRequiredViewAsType(source, R.id.scan_light, "field 'scanLight'", LinearLayout.class);
    target.scanLightIv = Utils.findRequiredViewAsType(source, R.id.scan_light_iv, "field 'scanLightIv'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    QRCodeScanActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.flMyContainer = null;
    target.TVPrompt = null;
    target.IVBack = null;
    target.scanInput = null;
    target.scanLight = null;
    target.scanLightIv = null;
  }
}
