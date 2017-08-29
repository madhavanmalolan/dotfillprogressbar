package com.madhavanmalolan.dotfillprogress;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by madhavan on 8/28/17.
 */

public class DotFillProgressbar extends View {

    int borderColor, fillColor;
    int spacing;
    int circles;
    int borderThickness;
    int radius;
    int initSpacing;
    int filled = 0;
    int locusRadius;




    public DotFillProgressbar(Context context) {
        super(context);
    }

    public DotFillProgressbar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray attrArray = context.getTheme().obtainStyledAttributes(attrs,R.styleable.DotProgressIndicator,0,0);
        try {
            borderColor = attrArray.getColor(R.styleable.DotProgressIndicator_circleBorderColor, Color.DKGRAY);
            fillColor = attrArray.getColor(R.styleable.DotProgressIndicator_circleFillColor, Color.LTGRAY);
            circles = attrArray.getInt(R.styleable.DotProgressIndicator_circles, 0);
            radius = attrArray.getDimensionPixelSize(R.styleable.DotProgressIndicator_circleRadius, 8);
            spacing = attrArray.getDimensionPixelSize(R.styleable.DotProgressIndicator_circleSpacing, 12);
            borderThickness = attrArray.getDimensionPixelSize(R.styleable.DotProgressIndicator_circleBorderWidth, 2);
            locusRadius = attrArray.getDimensionPixelSize(R.styleable.DotProgressIndicator_locusRadius, -1);
        }
        finally {
            attrArray.recycle();
        }
    }

    public DotFillProgressbar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void onDraw(Canvas canvas){
        if(circles == 0)
            return;
        int width = this.getMeasuredWidth();
        int height = this.getMeasuredHeight();
        initSpacing = circles % 2 == 0 ? spacing/2 : 0 ;
        Paint circle = new Paint();
        circle.setStyle(Paint.Style.STROKE);
        circle.setStrokeWidth(borderThickness);
        circle.setAntiAlias(true);
        circle.setColor(borderColor);

        Paint fill = new Paint();
        fill.setStyle(Paint.Style.FILL);
        fill.setColor(fillColor);
        fill.setAntiAlias(true);

        for(int i = 0 ; i < circles ; i++) {
            if(locusRadius < 0) {
                int centerY = this.getMeasuredHeight()/2;
                int centerX = (i+1)*spacing;
                if (i <= filled - 1)
                    canvas.drawCircle(centerX, centerY, radius, fill);
                canvas.drawCircle(centerX, centerY, radius, circle);
            }
            else {
                int centerY = (int)(height - locusRadius - radius - borderThickness - locusRadius* Math.sin(1.5*Math.PI + (i + 1 - (circles +1)/2.0)*spacing/locusRadius));
                int centerX = (int)(width/2.0 + locusRadius * Math.cos(1.5*Math.PI + (i + 1 - (circles +1)/2.0)*spacing/locusRadius));
                if (i <= filled - 1)
                    canvas.drawCircle(centerX, centerY, radius, fill);

                canvas.drawCircle(centerX, centerY, radius, circle);
            }
        }
    }


    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec){

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int width;
        int height;


        if (widthMode == MeasureSpec.EXACTLY) {
            width = widthSize;
        } else if (widthMode == MeasureSpec.AT_MOST) {
            if (locusRadius < 0)
                width = Math.min((circles+1)*spacing, widthSize);
            else
                width = getBoundingBoxWidth();
        } else {
            width = (circles+1)*spacing;
        }

        if (heightMode == MeasureSpec.EXACTLY) {
            height = heightSize;
        } else if (heightMode == MeasureSpec.AT_MOST) {
            if(locusRadius < 0)
                height = Math.min(2*radius, heightSize);
            else
                height = getBoundingBoxHeight();
        } else {
            height = 2*radius;
        }

        setMeasuredDimension(width, height);

    }

    public void setFilled(int count){
        filled = count;
        invalidate();
    }

    public void setCircles(int totalCircles, int filledCircles){
        circles = totalCircles;
        filled = filledCircles;
        invalidate();
    }


    int MARGIN = 2;
    private int getBoundingBoxWidth(){
        double theta = (double)spacing/locusRadius;
        if((circles+1)*theta < Math.PI){
            return (int)Math.ceil(2 * locusRadius * Math.sin((circles+1) * theta /2)) + MARGIN * (radius+borderThickness);
        }
        return 2*locusRadius + MARGIN * (radius+borderThickness);
    }

    private int getBoundingBoxHeight(){
        double theta = (double)spacing/locusRadius;
        if((circles + 1 ) * theta  > 2 * Math.PI) return 2*locusRadius + MARGIN * (radius+borderThickness);
        if((circles + 1) * theta > Math.PI){
            return (int)(locusRadius*(1+Math.sin((((circles + 1)*theta)-Math.PI)/2.0))) + MARGIN*(radius+borderThickness);
        }
        return (int)(locusRadius*(1-Math.cos((circles + 1)*theta/2.0))) + MARGIN * (radius+borderThickness);
    }


}
