package com.loyo.myapplication.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.loyo.myapplication.room.entity.User

@Dao
interface UserDao {
    @Insert
    fun insert(vararg user: User)
    @Query("SELECT * FROM user")
    fun queryAll(): Array<User>
}