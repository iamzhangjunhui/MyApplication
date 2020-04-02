package com.loyo.myapplication.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.Room
import com.loyo.myapplication.R
import com.loyo.myapplication.room.entity.Book
import com.loyo.myapplication.room.entity.User
import kotlin.concurrent.thread

class RoomActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)
        val testDataBase: TestDataBase =
            Room.databaseBuilder(this, TestDataBase::class.java, "data")
                .addMigrations(TestDataBase.Migration_2)
                .build()
        var userDao = testDataBase.getUserDao()
        var bookDao = testDataBase.getBookDao()
        thread {
            userDao.insert(
                User(
                    "kaylee"
                )
            )
            userDao.queryAll().iterator()
                .forEach { Log.i("RoomActivity", it.toString()) }
            bookDao.insert(Book("老人与海"))
            bookDao.queryAll().iterator().forEach { Log.i("RoomActivity", it.toString()) }
        }

    }
}
