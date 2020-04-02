package com.loyo.myapplication.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.loyo.myapplication.room.dao.BookDao
import com.loyo.myapplication.room.dao.UserDao
import com.loyo.myapplication.room.entity.Book
import com.loyo.myapplication.room.entity.User

@Database(entities = [User::class, Book::class], version = 2)
abstract class TestDataBase : RoomDatabase() {
    companion object {
        var Migration_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("CREATE TABLE  IF NOT EXISTS Book('bookId' INTEGER PRIMARY KEY NOT NULL,'bookName' TEXT NOT NULL)")
            }

        }
    }

    abstract fun getUserDao(): UserDao
    abstract fun getBookDao(): BookDao
}