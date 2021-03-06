package com.loyo.myapplication.recyclerview.recyclerView

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class RecyclerviewItemDecoration : RecyclerView.ItemDecoration() {
    private val paint: Paint = Paint()
    private val divider = 2

    init {
        paint.color = Color.BLACK
    }

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)
        //得到的是这一屏幕有多少个孩子。不是说得到的总的孩子的数目。
        val count = parent.childCount
        for (i in 0 until count) {
            val view = parent.getChildAt(i)
            //获取该view在Recyclerview的真实位置
            c.drawRect(
                view.left.toFloat(), (view.bottom-divider).toFloat(),
                view.right.toFloat(), (view.bottom).toFloat(), paint
            )
        }

    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.bottom = divider
    }}
