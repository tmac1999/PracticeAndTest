package com.example.mrz.practiceandtest.paintcode;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by mrz on 2018/12/6.
 */

public class Shadow extends View {
    public Shadow(Context context) {
        super(context);
    }

    public Shadow(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Shadow(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        StyleKitName.drawCanvas1(canvas);
    }
}
