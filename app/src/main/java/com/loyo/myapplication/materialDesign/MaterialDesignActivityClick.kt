package com.loyo.myapplication.materialDesign;

import android.content.Context
import android.content.Intent
import com.loyo.myapplication.materialDesign.bottomNavigationViewAndViewPager2.BottomNavigationViewAndFragmentActivity
import com.loyo.myapplication.materialDesign.bottomNavigationViewAndViewPager2.BottomNavigationViewAndViewPagerActivity
import com.loyo.myapplication.materialDesign.snackbar.SnackBarActivity

class MaterialDesignActivityClick(var context: Context) {
    fun toSnackBar(){
        context.startActivity(Intent(context, SnackBarActivity::class.java))
    }
    fun toBottomView(){
        context.startActivity(Intent(context, BottomNavigationViewAndViewPagerActivity::class.java))

    }
    fun toBottomView2(){
        context.startActivity(Intent(context, BottomNavigationViewAndFragmentActivity::class.java))

    }
}
