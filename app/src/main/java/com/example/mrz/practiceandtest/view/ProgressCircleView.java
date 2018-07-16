package com.example.mrz.practiceandtest.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by mrz on 18/7/15.
 */

public class ProgressCircleView extends View {

    private Paint paint;
    private Paint paintSolid,paintProgress;

    public ProgressCircleView(Context context) {
        super(context);
    }

    public ProgressCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();

        paint.setAntiAlias(true);
        // 设置颜色为红色
        paint.setColor(Color.RED);
        /**
         * 画笔样式分三种： 1.Paint.Style.STROKE：描边 2.Paint.Style.FILL_AND_STROKE：描边并填充
         * 3.Paint.Style.FILL：填充
         */
        paint.setStyle(Paint.Style.STROKE);
        /**
         * 设置描边的粗细，单位：像素px 注意：当setStrokeWidth(0)的时候描边宽度并不为0而是只占一个像素
         */
        paint.setStrokeWidth(dp2px(2));


        paintSolid = new Paint();
        paintSolid.setColor(Color.BLUE);
        paintSolid.setStyle(Paint.Style.FILL);

        paintProgress = new Paint();
        paintProgress.setColor(Color.BLACK);
        paintProgress.setStyle(Paint.Style.FILL);
    }

    public ProgressCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
       // canvas.drawCircle(100, 300, 150, paint);
        canvas.drawCircle(radius,radius,radius,paint);
        //canvas.drawCircle(radius,radius,radius,paintProgress);
        canvas.drawCircle(radius,radius,dp2px(27)+2,paintSolid);


       // canvas.drawArc(oval,360,140,false,paintProgress);//画圆弧，这个时候，绘制没有经过圆心

    }
    float radius = dp2px(28);

    public float dp2px(float dp) {
        final float scale = getResources().getDisplayMetrics().density;
        return dp * scale;
    }
}
