package com.loyo.myapplication.materialDesign.drawerLayoutAndNavigationView

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.loyo.myapplication.R
import kotlinx.android.synthetic.main.activity_drawer_layout.*
import kotlinx.android.synthetic.main.drawer_header.*
import kotlinx.android.synthetic.main.drawer_header.view.*


class DrawerLayoutAndNavigationViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawer_layout)
        setSupportActionBar(toolbar)
        toolbar.setNavigationIcon(R.drawable.ic_menu_black_24dp)


        //DrawerLayout相关
        //DrawerLayout与mToolbar关联起来
        val actionBarDrawerToggle =
            ActionBarDrawerToggle(this, drawer_layout, toolbar, R.string.open, R.string.close)
        actionBarDrawerToggle.syncState()
        /*//手动打开/关闭
        drawer_layout.openDrawer(navigation_view)
        drawer_layout.closeDrawer(navigation_view)
        //监听
        drawer_layout.addDrawerListener(object : DrawerLayout.DrawerListener {
        override fun onDrawerStateChanged(newState: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onDrawerClosed(drawerView: View) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onDrawerOpened(drawerView: View) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
        })*/


        //NavigationView相关
        //icon的颜色全为灰色，通过以下方式解决,注意在xml中设置app:itemIconTint="@null"无效
        navigation_view.itemIconTintList = null
        //navigation_view.getHeaderView(0)获取头布局
        navigation_view.getHeaderView(0).button21.setOnClickListener {
            Toast.makeText(this, navigation_view.headerCount.toString(), Toast.LENGTH_SHORT).show()
        }
        navigation_view.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.view -> Toast.makeText(
                    this@DrawerLayoutAndNavigationViewActivity,
                    "第一页",
                    Toast.LENGTH_SHORT
                ).show()
                R.id.view2 -> Toast.makeText(
                    this@DrawerLayoutAndNavigationViewActivity,
                    "第二页",
                    Toast.LENGTH_SHORT
                ).show()
                R.id.view3 -> Toast.makeText(
                    this@DrawerLayoutAndNavigationViewActivity,
                    "第三页",
                    Toast.LENGTH_SHORT
                ).show()
                R.id.view4 -> Toast.makeText(
                    this@DrawerLayoutAndNavigationViewActivity,
                    "第四页",
                    Toast.LENGTH_SHORT
                ).show()
                R.id.view5 -> Toast.makeText(
                    this@DrawerLayoutAndNavigationViewActivity,
                    "第五页",
                    Toast.LENGTH_SHORT
                ).show()
            }
            true
        }
    }
}
