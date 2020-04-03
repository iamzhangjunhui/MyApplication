package com.loyo.myapplication.materialDesign;

import android.content.Context
import android.content.Intent
import com.loyo.myapplication.materialDesign.snackbar.SnackBarActivity

class MaterialDesignActivityClick(var context: Context) {
    fun toSnackBar(){
        context.startActivity(Intent(context, SnackBarActivity::class.java))

    }
}
