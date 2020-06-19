package com.loyo.myapplication.viewdraghelper

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.LinearLayout
import androidx.customview.widget.ViewDragHelper
import androidx.customview.widget.ViewDragHelper.*
import com.loyo.myapplication.R
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

/**
 * 参考链接：https://juejin.im/entry/594fd0276fb9a06bbc4acc5b
 * https://juejin.im/entry/5642b95e60b28045db01c13f
 */
class MyLinearLayout : LinearLayout {
    var mStartLeft = 0
    var mStartTop = 0
    var mDragLeft = 0
    var mDragTop = 0
    val TAG: String = "MyLinearLayout"
    lateinit var viewDragHelper: ViewDragHelper

    init {
        Log.i(TAG, "init")
        viewDragHelper = ViewDragHelper.create(this, object : Callback() {
            /**
             * 可以用于设置那个子View可以被拖动（如：return child.id==R.id.textView12），返回true表示可以拖动,否则不能拖动
             */
            override fun tryCaptureView(child: View, pointerId: Int): Boolean {
                Log.i(TAG, "tryCaptureView")
                return false
            }

            /**
             * 开始拖动，可以获取拖动前的位置信息
             */
            override fun onViewCaptured(capturedChild: View, activePointerId: Int) {
                super.onViewCaptured(capturedChild, activePointerId)
                mStartLeft = capturedChild.left
                mStartTop = capturedChild.top
                Log.i(TAG, "onViewCaptured")

            }

            /**
             * left , top 分别为即将移动到的位置
             */
            override fun clampViewPositionHorizontal(child: View, left: Int, dx: Int): Int {
                val childWidth = dp2px(context, 100f)
                val leftBound = width - childWidth
                val rightBound = width + childWidth
                val newLeft = min(max(leftBound, left), rightBound)
                mDragLeft = newLeft
                Log.i(
                    TAG,
                    "clampViewPositionHorizontal,width:$width,child.width:${child.measuredWidth},leftBound:$leftBound,rightBound:$rightBound,newLeft:$newLeft"
                )

                return newLeft
            }

//            override fun clampViewPositionVertical(child: View, top: Int, dy: Int): Int {
//                mDragTop = top
//                return top
//            }
            /**
             *停止拖动的时候回调该方法
             */
            override fun onViewReleased(releasedChild: View, xvel: Float, yvel: Float) {
                super.onViewReleased(releasedChild, xvel, yvel)
                //如果拖动的距离太小，就回到原来的位置
                if (abs(mDragLeft - mStartLeft) < 100 && abs(mDragTop - mStartTop) < 100) {
                    //将 child 安置到坐标 (finalLeft,finalTop) 的位置
                    viewDragHelper.settleCapturedViewAt(mStartLeft, mStartTop)
                    invalidate()
                }
                Log.i(TAG, "onViewReleased")

            }

            //如果子View为Button或是TextView设置了clickable=true，需要重写getViewHorizontalDragRange方法和getViewVerticalDragRange方法。
            //如果只横向或竖向移动，只需要重写一个方法即可
            //返回的值为移动的距离
            override fun getViewHorizontalDragRange(child: View): Int {
                Log.i(TAG, "getViewHorizontalDragRange")
                return measuredWidth - child.measuredWidth

            }

            override fun getViewVerticalDragRange(child: View): Int {
                Log.i(TAG, "getViewVerticalDragRange")
                return measuredHeight - child.measuredHeight

            }

            /**
             * 边缘拖动开始，这里的边缘是该ViewGroup的边缘
             */
            override fun onEdgeDragStarted(edgeFlags: Int, pointerId: Int) {
                super.onEdgeDragStarted(edgeFlags, pointerId)
                viewDragHelper.captureChildView(getChildAt(childCount - 1), pointerId)
                Log.i(TAG, "onEdgeDragStarted")


            }

            override fun onEdgeTouched(edgeFlags: Int, pointerId: Int) {
                super.onEdgeTouched(edgeFlags, pointerId)
                Log.i(TAG, "onEdgeTouched")

            }
        })
        //设置左边缘和右边缘可以拖动
        viewDragHelper.setEdgeTrackingEnabled(EDGE_RIGHT or EDGE_LEFT)
    }

    constructor(context: Context) : super(context)

    /**
     * 注意：这里需要调用父类的构造方法再加自己的逻辑，否则ConstraintLayout布局中约束不起作用
     */
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet) {
        Log.i(TAG, "constructor2")

    }

    constructor(context: Context, attributeSet: AttributeSet, defStyleAttr: Int) : super(
        context,
        attributeSet,
        defStyleAttr
    ) {
        Log.i(TAG, "constructor3")
    }

    /**
     * 如果子View不消耗事件，那么整个手势（DOWN-MOVE*-UP）都是直接进入onTouchEvent，在onTouchEvent的DOWN的时候就确定了captureView。
     * 如果消耗事件（比如子View可以点击），那么就会先走onInterceptTouchEvent方法，判断是否可以捕获，而在判断的过程中会去判断另外两个回调的方法：
     * getViewHorizontalDragRange和getViewVerticalDragRange，只有这两个方法返回大于0的值才能正常的捕获。
     */
    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        return viewDragHelper.shouldInterceptTouchEvent(ev!!)
        Log.i(TAG, "onInterceptTouchEvent")

    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        viewDragHelper.processTouchEvent(event!!)
        Log.i(TAG, "onTouchEvent")

        return true
    }

    //实现回到原来位置的动画效果
    override fun computeScroll() {
        super.computeScroll()
        if (viewDragHelper.continueSettling(true)) {
            invalidate()
        }
        Log.i(TAG, "computeScroll")

    }

    fun dp2px(context: Context, dpValue: Float): Int {
        val scale: Float = context.resources.displayMetrics.density
        return (dpValue * scale + 0.5f).toInt()
    }
}