// Generated code from Butter Knife. Do not modify!
package com.tdr.registrationv3.ui.activity.image;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.RelativeLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.tdr.registrationv3.R;
import com.tdr.registrationv3.photoview.PhotoView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ImageActivity_ViewBinding implements Unbinder {
  private ImageActivity target;

  @UiThread
  public ImageActivity_ViewBinding(ImageActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ImageActivity_ViewBinding(ImageActivity target, View source) {
    this.target = target;

    target.comTitleBack = Utils.findRequiredViewAsType(source, R.id.com_title_back, "field 'comTitleBack'", RelativeLayout.class);
    target.ivPhoto = Utils.findRequiredViewAsType(source, R.id.iv_photo, "field 'ivPhoto'", PhotoView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ImageActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.comTitleBack = null;
    target.ivPhoto = null;
  }
}
