package org.itsman.k_library.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class CanvasView extends View {


    private Paint text;
    public CanvasView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        text = new Paint();
        text.setTextSize(40);
        text.setColor(Color.RED);
        text.setTextAlign(Paint.Align.CENTER);
        text.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        
    }
}
