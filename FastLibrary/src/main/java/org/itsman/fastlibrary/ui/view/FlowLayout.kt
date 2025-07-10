package org.itsman.fastlibrary.ui.view

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup

class FlowLayout(context: Context?, attrs: AttributeSet?) : ViewGroup(context, attrs) {
    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        var l = l
        val count = getChildCount()
        for (i in 0 until count) {
            getChildAt(i).layout(l, t, r, b)
            l += getChildAt(i).getMeasuredWidth()
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val childConut = getChildCount()
        for (i in 0 until childConut) {
            val childView = getChildAt(i)
            measureChild(childView, widthMeasureSpec, heightMeasureSpec)
        }
    }
}
