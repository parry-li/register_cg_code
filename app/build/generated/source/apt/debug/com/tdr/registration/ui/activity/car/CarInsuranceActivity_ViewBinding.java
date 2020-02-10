// Generated code from Butter Knife. Do not modify!
package com.tdr.registration.ui.activity.car;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.tdr.registration.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CarInsuranceActivity_ViewBinding implements Unbinder {
  private CarInsuranceActivity target;

  private View view2131230779;

  @UiThread
  public CarInsuranceActivity_ViewBinding(CarInsuranceActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public CarInsuranceActivity_ViewBinding(final CarInsuranceActivity target, View source) {
    this.target = target;

    View view;
    target.IV = Utils.findRequiredViewAsType(source, R.id.IV, "field 'IV'", RecyclerView.class);
    view = Utils.findRequiredView(source, R.id.btn_submit, "field 'btnSubmit' and method 'onViewClicked'");
    target.btnSubmit = Utils.castView(view, R.id.btn_submit, "field 'btnSubmit'", TextView.class);
    view2131230779 = view;
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
    CarInsuranceActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.IV = null;
    target.btnSubmit = null;

    view2131230779.setOnClickListener(null);
    view2131230779 = null;
  }
}
