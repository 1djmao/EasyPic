package com.idjmao.easypic;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

/**
 * Created by 1djmao on 2018/2/26.
 */

public class BitMapp {

    public static Bitmap getBitMap(float progress){
        int width=250;
        int height=250;
        Bitmap bitmap= Bitmap.createBitmap(width,height,Bitmap.Config.ARGB_4444);
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                bitmap.setPixel(i,j,Color.TRANSPARENT);
            }
        }

        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        paint.setAntiAlias(true);
        Canvas cv = new Canvas(bitmap);
        cv.drawCircle(width/2,height/2,width/2,paint);

        paint.setStyle(Paint.Style.FILL);

        cv.drawArc(new RectF(10,10,width-10,height-10),-90,progress*360,true,paint);

        cv.save(Canvas.ALL_SAVE_FLAG);// 保存
        cv.restore();// 存储
        return bitmap;
    }

}
