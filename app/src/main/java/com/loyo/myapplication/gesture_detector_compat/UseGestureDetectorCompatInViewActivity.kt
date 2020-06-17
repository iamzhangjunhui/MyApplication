package com.loyo.myapplication.gesture_detector_compat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import androidx.core.view.GestureDetectorCompat
import com.loyo.myapplication.R
import kotlinx.android.synthetic.main.activity_use_gesture_detector_compat_in_view.*

/**
 * 将GestureDetectorCompat用于View
 * 1.创建一个GestureDetectorCompat的实例
 * 2.实现View的setOnTouchListener方法
 */
class UseGestureDetectorCompatInViewActivity : AppCompatActivity() {
    private val TAG: String = "Gesture"
    private lateinit var gestureDetectorCompat: GestureDetectorCompat
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_use_gesture_detector_compat_in_view)
        gestureDetectorCompat =
            GestureDetectorCompat(this, object : GestureDetector.OnGestureListener {
                override fun onShowPress(e: MotionEvent?) {
                    Log.i(TAG, "onShowPress:手指按在触摸屏上，它的时间范围在按下起效，在长按之前 ")
                }

                override fun onSingleTapUp(e: MotionEvent?): Boolean {
                    Log.i(TAG, "onSingleTapUp:手指离开触摸屏的那一刹那 ");

                    return false
                }

                override fun onDown(e: MotionEvent?): Boolean {
                    Log.i(TAG, "刚刚手指接触到触摸屏的那一刹那，就是触的那一下")
                    return false
                }

                override fun onFling(
                    e1: MotionEvent?,
                    e2: MotionEvent?,
                    velocityX: Float,
                    velocityY: Float
                ): Boolean {
                    Log.i(TAG, "onFling:手指在触摸屏上迅速移动，并松开的动作 ")
                    return false
                }

                override fun onScroll(
                    e1: MotionEvent?,
                    e2: MotionEvent?,
                    distanceX: Float,
                    distanceY: Float
                ): Boolean {
                    Log.i(TAG, "onScroll:手指在触摸屏上滑动 ")
                    return false
                }

                override fun onLongPress(e: MotionEvent?) {
                    Log.i(TAG, "onLongPress:手指按在持续一段时间，并且没有松开 ")
                }
            })
        textView9.setOnTouchListener { v, event -> gestureDetectorCompat.onTouchEvent(event) }
    }

}
