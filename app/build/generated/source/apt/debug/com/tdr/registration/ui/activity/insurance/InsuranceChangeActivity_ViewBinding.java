// Generated code from Butter Knife. Do not modify!
package com.tdr.registration.ui.activity.insurance;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.tdr.registration.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class InsuranceChangeActivity_ViewBinding implements Unbinder {
  private InsuranceActivity target;

  private View view2131230784;

  @UiThread
  public InsuranceChangeActivity_ViewBinding(InsuranceActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public InsuranceChangeActivity_ViewBinding(final InsuranceActivity target, View source) {
    this.target = target;

    View view;
    target.insuranceRv = Utils.findRequiredViewAsType(source, R.id.insurance_rv, "field 'insuranceRv'", RecyclerView.class);
    view = Utils.findRequiredView(source, R.id.button_next, "method 'onViewClicked'");
    view2131230784 = view;
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
    InsuranceActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.insuranceRv = null;

    view2131230784.setOnClickListener(null);
    view2131230784 = null;
  }
}
