package com.loyo.myapplication.Util

import android.content.Context
import androidx.room.Room
import com.loyo.myapplication.MainApp
import com.loyo.myapplication.room.TestDataBase

object DataBaseUtil {
    val testDataBase: TestDataBase =
        Room.databaseBuilder(MainApp.mainApp, TestDataBase::class.java, "data")
            .addMigrations(TestDataBase.Migration_3)
            .build()
    var userDao = testDataBase.getUserDao()
    var bookDao = testDataBase.getBookDao()

}