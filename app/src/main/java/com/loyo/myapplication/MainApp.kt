package com.loyo.myapplication

import android.app.Application

class MainApp : Application() {
    companion object {
        lateinit var mainApp: MainApp
    }

    override fun onCreate() {
        super.onCreate()
        mainApp = this
    }
}