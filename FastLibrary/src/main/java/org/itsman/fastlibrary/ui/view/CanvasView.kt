package org.itsman.fastlibrary.ui.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import org.itsman.fastlibrary.R

class CanvasView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    private val text: Paint
    private val circle: Paint

    init {
        text = Paint().apply {
            textSize = 40f
            setColor(Color.BLACK)
            textAlign = Paint.Align.CENTER
            isAntiAlias = true
        }
        circle = Paint().apply {
            style = Paint.Style.STROKE
            strokeWidth = 5f
            isAntiAlias = true
        }
        val aa = context?.obtainStyledAttributes(attrs, R.styleable.CanvasView, 0, 0)
        attrs?.let {
            val width =
                it.getAttributeValue("http://schemas.android.com/apk/res/android", "layout_width")
            width.plus(100)
        }
        aa?.recycle()
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        event?.run {
            if (event.action== MotionEvent.ACTION_MOVE){
            }
            offsetLeftAndRight(x.toInt())
            offsetTopAndBottom(y.toInt())
        }
        return super.onTouchEvent(event)
    }

    override fun onDraw(canvas: Canvas) {
        canvas.drawColor(Color.parseColor("#e3e3e3"))
        val x = canvas.width / 2f
        val y = canvas.height / 2f
        val path = Path().apply { addCircle(x, y, x - 10, Path.Direction.CW) }
        canvas.drawPath(path, circle)
        repeat(12) {
            canvas.drawLine(x, 10f, x, 20f, text)
            canvas.rotate(30f, x, y)
        }
    }
}
