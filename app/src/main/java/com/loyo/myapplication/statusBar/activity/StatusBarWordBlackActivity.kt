package com.loyo.myapplication.statusBar.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.loyo.myapplication.R
import com.loyo.myapplication.statusBar.utils.StatusBarUtil

class StatusBarWordBlackActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_status_bar_word_black)
        //这里注意下 因为在评论区发现有网友调用setRootViewFitsSystemWindows 里面 winContent.getChildCount()=0 导致代码无法继续
        //是因为你需要在setContentView之后才可以调用 setRootViewFitsSystemWindows
        //当FitsSystemWindows设置 true 时，会在屏幕最上方预留出状态栏高度的 padding
        StatusBarUtil.setRootViewFitsSystemWindows(this, true)
        //设置状态栏透明
//        StatusBarUtil.setTranslucentStatus(this)
        //设置状态栏的字体和图标为深色
        StatusBarUtil.setStatusBarDarkTheme(this, true)
    }
}
