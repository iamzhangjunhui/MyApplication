package com.loyo.myapplication.android_q

import android.content.Context
import android.content.Intent

class AndroidQClick(val context: Context) {
    fun toDayNightMode() {
        context.startActivity(Intent(context, DayNightModeActivity::class.java))
    }
}