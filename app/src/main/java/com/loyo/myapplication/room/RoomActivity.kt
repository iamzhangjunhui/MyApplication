package com.loyo.myapplication.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.Room
import com.loyo.myapplication.R
import com.loyo.myapplication.Util.DataBaseUtil
import com.loyo.myapplication.room.entity.Book
import com.loyo.myapplication.room.entity.User
import kotlin.concurrent.thread

class RoomActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)
        thread {
            DataBaseUtil.userDao.insert(
                User(
                    "kaylee"
                )
            )
            DataBaseUtil.userDao.queryAll().iterator()
                .forEach { Log.i("RoomActivity", it.toString()) }
            DataBaseUtil.bookDao.insert(Book("老人与海"))
            DataBaseUtil.bookDao.queryAll().iterator().forEach { Log.i("RoomActivity", it.toString()) }
        }

    }
}
