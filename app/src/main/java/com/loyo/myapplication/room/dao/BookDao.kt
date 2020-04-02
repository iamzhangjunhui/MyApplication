package com.loyo.myapplication.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.loyo.myapplication.room.entity.Book
import com.loyo.myapplication.room.entity.User

@Dao
interface BookDao {
    @Insert
    fun insert(vararg book: Book)

    @Query("SELECT * FROM book")
    fun queryAll(): Array<Book>
}