package com.loyo.myapplication.materialDesign.bottomNavigationViewAndViewPager2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2.ORIENTATION_VERTICAL
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.loyo.myapplication.R
import com.loyo.myapplication.materialDesign.bottomNavigationViewAndViewPager2.TestFragment.Companion.instasnce
import kotlinx.android.synthetic.main.activity_bottom_navigation_view.*

class BottomNavigationViewAndViewPagerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation_view)
        val list = listOf<Fragment>(
            instasnce("首页"),
            instasnce("第二页"),
            instasnce("第三页"),
            instasnce("第四页"),
            instasnce("第五页")
        )
        //进入时默认选中第一页
        bottom.menu.getItem(0).isChecked = true
        viewpager.adapter = TestViewAdapter(list, this)
        viewpager.orientation = ORIENTATION_VERTICAL
        var lastMenuView = bottom.menu.getItem(0)
        //监听viewpager的页面变化，使底部导航栏随之变化
        viewpager.registerOnPageChangeCallback(object : OnPageChangeCallback() {

            override fun onPageSelected(position: Int) {
                val menuView = bottom.menu.getItem(position)
                if (menuView != lastMenuView) {
                    lastMenuView.isChecked = false
                }
                lastMenuView = menuView
                menuView.isChecked = true
            }
        })
        //监听底部导航栏的变化，使viewpager随之发生页面变化
        bottom.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.view2 -> {
                    viewpager.currentItem = 1
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.view3 -> {
                    viewpager.currentItem = 2
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.view4 -> {
                    viewpager.currentItem = 3
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.view5 -> {
                    viewpager.currentItem = 4
                    return@setOnNavigationItemSelectedListener true
                }
                else -> {
                    viewpager.currentItem = 0
                    return@setOnNavigationItemSelectedListener true
                }
            }
        }


    }
}
