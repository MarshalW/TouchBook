package com.example.touchbook;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;

/**
 * Created with IntelliJ IDEA.
 * User: marshal
 * Date: 13-4-22
 * Time: 上午10:55
 * To change this template use File | Settings | File Templates.
 */
public class TouchView extends AbsoluteLayout {
    public TouchView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setStrokeWidth(3);

        paint.setColor(Color.parseColor("#70ffff00"));
        canvas.drawRect(0, 0, 360 * 2, 70 * 2, paint);

        paint.setColor(Color.parseColor("#70ffff55"));
        canvas.drawRect(0, 70 * 2, 360 * 2, 182 * 2, paint);

        paint.setColor(Color.parseColor("#70ffff10"));
        canvas.drawRect(0, 182 * 2, 360 * 2, 409 * 2, paint);

        paint.setColor(Color.parseColor("#70fff010"));
        canvas.drawRect(0, 409 * 2, 360 * 2, 544 * 2, paint);

        paint.setColor(Color.parseColor("#70ff0000"));
        canvas.drawRect(152 * 2, 182 * 2, 360 * 2, 323 * 2, paint);
    }
}
