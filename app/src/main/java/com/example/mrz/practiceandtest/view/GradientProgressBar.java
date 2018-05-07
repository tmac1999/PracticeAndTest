package com.example.mrz.practiceandtest.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by mrz on 18/4/18.
 */

public class GradientProgressBar extends View {
    public GradientProgressBar(Context context) {
        super(context);
    }

    public GradientProgressBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {

    }

    public GradientProgressBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
