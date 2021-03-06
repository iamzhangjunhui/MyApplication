package com.loyo.myapplication.materialDesign

import android.content.Context
import android.content.Intent
import com.loyo.myapplication.materialDesign.appBarLayout.AppBarLayoutActivity
import com.loyo.myapplication.materialDesign.bottomNavigationViewAndViewPager2.BottomNavigationViewAndFragmentActivity
import com.loyo.myapplication.materialDesign.bottomNavigationViewAndViewPager2.BottomNavigationViewAndViewPagerActivity
import com.loyo.myapplication.materialDesign.drawerLayoutAndNavigationView.DrawerLayoutAndNavigationViewActivity
import com.loyo.myapplication.materialDesign.floatingActionMenu.FloatingActionMenuActivity
import com.loyo.myapplication.materialDesign.slidingPaneLayout.SlidingPaneLayoutActivity
import com.loyo.myapplication.materialDesign.snackbar.SnackBarActivity
import com.loyo.myapplication.materialDesign.toolBar.ToolBarActivity

class MaterialDesignActivityClick(var context: Context) {
    fun toSnackBar() {
        context.startActivity(Intent(context, SnackBarActivity::class.java))
    }

    fun toBottomView() {
        context.startActivity(Intent(context, BottomNavigationViewAndViewPagerActivity::class.java))

    }

    fun toBottomView2() {
        context.startActivity(Intent(context, BottomNavigationViewAndFragmentActivity::class.java))
    }

    fun toAppBarLayout() {
        context.startActivity(Intent(context, AppBarLayoutActivity::class.java))
    }

    fun toToolBar() {
        context.startActivity(Intent(context, ToolBarActivity::class.java))
    }

    fun toDrawerLayout() {
        context.startActivity(Intent(context, DrawerLayoutAndNavigationViewActivity::class.java))
    }

    fun toFloatingActionMenu() {
        context.startActivity(Intent(context, FloatingActionMenuActivity::class.java))
    }
    fun toSlidingPaneLayoutActivity(){
        context.startActivity(Intent(context, SlidingPaneLayoutActivity::class.java))
    }
}
