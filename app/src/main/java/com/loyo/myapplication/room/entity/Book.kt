package com.loyo.myapplication.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Book(var bookName: String) {
    @PrimaryKey(autoGenerate = true)
    var bookId: Int = 0
}