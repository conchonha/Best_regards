package com.example.baseprojectandroid.compoments.custom_view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class Login_bg extends View {
    private Paint mPaint;
    private Paint mPaint1;
    private CornerPathEffect mCorEffect;
    private float radius = 50f;
    private Path mPath;
    private Path mPath1;

    public Login_bg(Context context) {
        super(context);
        init();
    }

    public Login_bg(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Login_bg(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public Login_bg(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPath1.moveTo(getWidth(), 0);
        mPath1.lineTo(450, 0);
        mPath1.lineTo(0,getHeight()/3);
        mPath1.lineTo(0, getHeight());
        mPath1.lineTo(getWidth(), getHeight());
        mPath1.close();
        canvas.drawPath(mPath1, mPaint1);
        mPath.moveTo(0, 0);
        mPath.lineTo(getWidth()/4, 0);
        mPath.lineTo(getWidth(),getHeight()/3);
        mPath.lineTo(getWidth(), getHeight());
        mPath.lineTo(0, getHeight());
        mPath.close();
        canvas.drawPath(mPath, mPaint);
    }

    private void init(){
        mPaint = new Paint();
        mPath = new Path();
        mPath1 = new Path();
        mCorEffect = new CornerPathEffect(radius);

        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(6);
        mPaint.setPathEffect(mCorEffect);

        mPaint1 = new Paint();
        mPaint1.setColor(Color.BLUE);
        mPaint1.setStrokeWidth(6);
        mPaint1.setPathEffect(mCorEffect);
    }
}
