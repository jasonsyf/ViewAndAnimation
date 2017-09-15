package com.jason.viewandanimation.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by Jason_Sunyf on 2017/9/14 0014.
 * Email： jason_sunyf@163.com
 */

public class PercentView extends View {
    private final static String TAG = PercentView.class.getSimpleName();
    private Paint mPaint;
    private RectF mRectF;

    // 当不需要使用xml声明或者不需要使用inflate动态加载时候，实现此构造函数即可
    public PercentView(Context context) {
        super(context, null);
    }

    //当需要在xml中声明此控件，则需要实现此构造函数。
    // 并且在构造函数中把自定义的属性与控件的数据成员连接起来。
    public PercentView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    // 接收一个style资源
    public PercentView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mRectF = new RectF();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        Log.e(TAG, "onMeasure--widthMode-->" + widthMode);
        switch (widthMode) {
            case MeasureSpec.EXACTLY:

                break;
            case MeasureSpec.AT_MOST:

                break;
            case MeasureSpec.UNSPECIFIED:

                break;
        }
        Log.e(TAG, "onMeasure--widthSize-->" + widthSize);
        Log.e(TAG, "onMeasure--heightMode-->" + heightMode);
        Log.e(TAG, "onMeasure--heightSize-->" + heightSize);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Log.e(TAG, "onLayout");
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        int width = getWidth();
        int height = getHeight();
        Log.e(TAG, "onDraw---->" + width + "*" + height);
        float radius = width / 4;
        canvas.drawCircle(width / 2, width / 2, radius, mPaint);
        mPaint.setColor(Color.BLACK);
        mRectF.set(width / 2 - radius, width / 2 - radius, width / 2 + radius, width / 2 + radius);
        canvas.drawArc(mRectF, 120, 180, true, mPaint);
    }

}
