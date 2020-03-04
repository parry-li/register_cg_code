package com.tdr.registrationv3.webview;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/**
 * Created by parry
 */

public class FullscreenHolder extends FrameLayout {

    public FullscreenHolder(Context ctx) {
        super(ctx);
        setBackgroundColor(ctx.getResources().getColor(android.R.color.black));
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return true;
    }
}
