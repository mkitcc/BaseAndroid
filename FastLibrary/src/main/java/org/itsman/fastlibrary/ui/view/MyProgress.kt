package org.itsman.fastlibrary.ui.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Paint
import android.graphics.RectF
import android.graphics.Shader
import android.util.AttributeSet
import android.view.View

class MyProgress constructor(context: Context, attr: AttributeSet? = null, defStyle: Int = 0) : View
    (context, attr, defStyle) {


    //文本
    var txtPaint = Paint()
    var bPaint = Paint()
    var pPaint = Paint()
    var radius: Float = 0f
    var background: Int = 0
    var progressColor1: Int = 0
    var progressColor2: Int = 0

    //进度条
    var progress: Int = 0

    var max: Int = 0

    constructor(context: Context, attr: AttributeSet? = null) : this(context, attr, 0) {

    }

    init {
        txtPaint.textSize = 25f
        txtPaint.color = Color.rgb(255, 255, 255)
    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        radius = measuredWidth / 5.0f
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        //背景
        bPaint.color = background
        canvas.drawRoundRect(
            RectF(0f, 0f, measuredWidth.toFloat(), measuredHeight.toFloat()),
            radius.toFloat(),
            radius.toFloat(),
            bPaint
        )

        //当前进度
        var p = progress / max.toFloat()
        //如果进度不对
        if (p < 0) return
        if (p >= 1) p = 1f
        //前景
        pPaint.shader = LinearGradient(
            0F, 0F, measuredWidth.toFloat(), measuredHeight.toFloat(),
            intArrayOf(progressColor1, progressColor2), null, Shader.TileMode.CLAMP
        )

        canvas.drawRoundRect(
            RectF(0F, 0F, measuredWidth * p, measuredHeight.toFloat()),
            radius.toFloat(),
            radius.toFloat(),
            pPaint
        )

        //计算字体的长度 + padding 才是按钮的长度
        val str = (p * 100).toInt().toString() + "%"
        val fm = txtPaint.fontMetrics
        val txtH = fm.ascent + fm.descent + fm.leading
        val txtW = txtPaint.measureText(str)
        //按钮
        canvas.drawRoundRect(
            RectF(
                (measuredWidth * p - txtW - 10).toFloat(), (measuredHeight - txtH) / 2f-5,
                measuredWidth * p, (measuredHeight + (txtH - measuredHeight)+5)
            ),
            radius.toFloat(),
            radius.toFloat(),
            bPaint
        )

    }

    fun setColor(b: Int, p1: Int, p2: Int) {
        background = b
        progressColor1 = p1
        progressColor2 = p2
        invalidate()
    }

//    fun setMax(m: Int) {
//        max = m
//    }

    fun setP(p: Int) {
        progress = p
        invalidate()
    }
}