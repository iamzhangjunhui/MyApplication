package com.loyo.myapplication.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(var name: String) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
