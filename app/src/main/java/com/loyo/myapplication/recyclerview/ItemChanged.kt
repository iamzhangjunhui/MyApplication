package com.loyo.myapplication.recyclerview

interface ItemChanged {
    fun move(fromIndex:Int,toIndex:Int)
    fun delete(deleteIndex:Int)
}