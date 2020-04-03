package com.loyo.myapplication

import android.content.Context
import android.content.Intent
import com.loyo.myapplication.materialDesign.MaterialDesignActivity
import com.loyo.myapplication.recyclerview.RecycleViewActivity
import com.loyo.myapplication.room.RoomActivity
import com.loyo.myapplication.materialDesign.snackbar.SnackBarActivity

class MainActivityClick  (private val context: Context) {
    fun toRecycleView() {
        context.startActivity(Intent(context, RecycleViewActivity::class.java))
    }
    fun toRoom(){
        context.startActivity(Intent(context, RoomActivity::class.java))

    }
    fun toMaterialDesignActivity(){
        context.startActivity(Intent(context, MaterialDesignActivity::class.java))

    }
}