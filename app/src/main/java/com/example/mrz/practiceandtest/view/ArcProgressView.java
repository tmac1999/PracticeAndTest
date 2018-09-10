package com.example.mrz.practiceandtest.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by mrz on 18/8/8.
 */

public class ArcProgressView extends View {

    private RectF rectF;
    private Context context;
    private Paint mArcPaint, mArcPaintBackground;
    private float sweepAngle;

    public ArcProgressView(Context context) {
        super(context);
    }

    public ArcProgressView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        rectF = new RectF(dp2px(2), dp2px(2), dp2px(52), dp2px(52));
        mArcPaint = new Paint();
        mArcPaint.setColor(Color.parseColor("#188DFF"));
        mArcPaint.setStyle(Paint.Style.STROKE);
        mArcPaint.setStrokeWidth(dp2px(4));//线宽
        mArcPaint.setAntiAlias(true);
        mArcPaintBackground = new Paint();
        mArcPaintBackground.setColor(Color.parseColor("#DFE6EE"));
        mArcPaintBackground.setStyle(Paint.Style.STROKE);
        mArcPaintBackground.setStrokeWidth(dp2px(4));//线宽
        mArcPaintBackground.setAntiAlias(true);
    }

    public ArcProgressView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setScore(int score) {
        sweepAngle = score * 3.6f;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(rectF, 0, 360, false, mArcPaintBackground);
        canvas.drawArc(rectF, 270, sweepAngle, false, mArcPaint);
    }

    protected float dp2px(float dp) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (dp * scale + 0.5f);
    }
}
