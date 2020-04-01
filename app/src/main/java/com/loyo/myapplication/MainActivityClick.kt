package com.loyo.myapplication

import android.content.Context
import android.content.Intent
import com.loyo.myapplication.recyclerview.RecycleViewActivity
import java.lang.reflect.Constructor

class MainActivityClick  (private val context: Context) {
    fun toRecycleView() {
        context.startActivity(Intent(context, RecycleViewActivity::class.java))
    }
}