package com.loyo.myapplication.materialDesign.drawerLayout

import android.os.Bundle
import android.view.Gravity
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.loyo.myapplication.R
import kotlinx.android.synthetic.main.activity_drawer_layout.*


class DrawerLayoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawer_layout)
        setSupportActionBar(toolbar)
        toolbar.setNavigationIcon(R.drawable.ic_menu_black_24dp)
        //DrawerLayout与mToolbar关联起来
        val actionBarDrawerToggle =
            ActionBarDrawerToggle(this, drawer_layout, toolbar, R.string.open, R.string.close)
        actionBarDrawerToggle.syncState()
        //手动打开/关闭
//        drawer_layout.openDrawer(navigation_view)
//        drawer_layout.closeDrawer(navigation_view)
        //监听
//        drawer_layout.addDrawerListener(object : DrawerLayout.DrawerListener {
//            override fun onDrawerStateChanged(newState: Int) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//            }
//
//            override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//            }
//
//            override fun onDrawerClosed(drawerView: View) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//            }
//
//            override fun onDrawerOpened(drawerView: View) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//            }
//        })
    }
}
