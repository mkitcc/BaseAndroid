package org.itsman.fastlibrary.ui.view

import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View


/**
 * 手式识别
 *
 */

fun listenScroll(view: View, view2: View) {

    val gd = object : GestureDetector.SimpleOnGestureListener() {
        override fun onDown(e: MotionEvent): Boolean {
            //必须返回true,
            return true
        }

        override fun onScroll(
            e1: MotionEvent?,
            e2: MotionEvent,
            distanceX: Float,
            distanceY: Float
        ): Boolean {
            view2.x = e2.x
            view2.y = e2.y
            return true
        }
    }
    val gesture = GestureDetector(view.context, gd)

    view.setOnTouchListener { view, mt ->
//            if (mt.action == MotionEvent.ACTION_MOVE) {
//                bind.ivIcon.x=mt.x
//                bind.ivIcon.y=mt.y
//            }
//            return@setOnTouchListener true
        return@setOnTouchListener gesture.onTouchEvent(mt)
    }
}