package com.loyo.myapplication.recyclerview.recyclerView

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

class ItemTouchChangedCallBack (val adapter: RecyclerViewAdapter):ItemTouchHelper.Callback() {
    override fun getMovementFlags(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder
    ): Int {

        val dragFlags = ItemTouchHelper . UP.or(ItemTouchHelper . DOWN)       //允许上下的拖动
        val swipeFlags = ItemTouchHelper . LEFT  //只允许从右向左侧滑
        return makeMovementFlags(dragFlags, swipeFlags)
}

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        return true
    }

    override fun onMoved(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        fromPos: Int,
        target: RecyclerView.ViewHolder,
        toPos: Int,
        x: Int,
        y: Int
    ) {
        super.onMoved(recyclerView, viewHolder, fromPos, target, toPos, x, y)
        adapter.move(fromPos,toPos)

    }
    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        adapter.delete(viewHolder.adapterPosition)
    }

}