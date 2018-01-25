package com.example.mrz.practiceandtest.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.view.Gravity;

import com.example.mrz.practiceandtest.R;


/**
 * Created by Administrator on 2017/5/9.
 * 带倾斜度的文字
 */
public class RotateTextView extends AppCompatTextView {

    private static final int DEFAULT_DEGREES = 45;

    private int mDegrees;

    public RotateTextView(Context context) {
        super(context, null);
    }

    public RotateTextView(Context context, AttributeSet attrs) {
        super(context, attrs, android.R.attr.textViewStyle);

        this.setGravity(Gravity.CENTER);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.RotateTextView);

        mDegrees = a.getInt(R.styleable.RotateTextView_degree, DEFAULT_DEGREES);

        a.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(getMeasuredWidth(), getMeasuredWidth());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //canvas.save();

        //
         canvas.translate(getCompoundPaddingLeft()-getCompoundPaddingRight(), getCompoundPaddingTop()-getCompoundPaddingBottom());

        canvas.rotate(mDegrees, this.getWidth() / 2f, this.getHeight() / 2f);
        super.onDraw(canvas);
        //canvas.restore();
    }

    public void setDegrees(int degrees) {
        mDegrees = degrees;
    }

}
