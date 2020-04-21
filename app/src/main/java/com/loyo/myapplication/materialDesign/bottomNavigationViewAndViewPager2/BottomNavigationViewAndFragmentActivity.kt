package com.loyo.myapplication.materialDesign.bottomNavigationViewAndViewPager2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.loyo.myapplication.R
import kotlinx.android.synthetic.main.activity_bottom_navigation_view.*

class BottomNavigationViewAndFragmentActivity : AppCompatActivity() {
    lateinit var list: List<Fragment>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation_view_and_fragment)
        list = listOf<Fragment>(
            TestFragment.instasnce("首页"),
            TestFragment.instasnce("第二页"),
            TestFragment.instasnce("第三页"),
            TestFragment.instasnce("第四页"),
            TestFragment.instasnce("第五页")
        )
        //进入时默认选中第一页
        bottom.menu.getItem(0).isChecked = true
        val transaction = supportFragmentManager.beginTransaction()
        showFragment(0)
        //监听底部导航栏的变化，使viewpager随之发生页面变化
        bottom.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.view2 -> {
                    showFragment(1)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.view3 -> {
                    showFragment(2)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.view4 -> {
                    showFragment(3)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.view5 -> {
                    showFragment(4)
                    return@setOnNavigationItemSelectedListener true
                }
                else -> {
                    showFragment(0)
                    return@setOnNavigationItemSelectedListener true
                }
            }
        }


    }

    private fun showFragment(index: Int) {
        val currentFragment = supportFragmentManager.fragments.find { it.isVisible && it in list }
        val targetFragment = list[index]
        supportFragmentManager.beginTransaction().apply {
            currentFragment?.let {
                hide(it)
            }
            targetFragment.let { if (it.isAdded) show(it) else add(R.id.fragment, it) }
        }.commit()
    }
}

