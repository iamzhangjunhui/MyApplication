package com.loyo.myapplication

import android.content.Context
import android.content.Intent

class MainActivityClick(private val context: Context) {
    fun toRecycleView() {
        context.startActivity(Intent(context, RecycleViewActivity::class.java))
    }
}