package com.loyo.myapplication.recyclerview.recyclerView

interface ItemChanged {
    fun move(fromIndex:Int,toIndex:Int)
    fun delete(deleteIndex:Int)
}