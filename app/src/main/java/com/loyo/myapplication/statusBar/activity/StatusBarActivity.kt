package com.loyo.myapplication.statusBar.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.loyo.myapplication.R
import com.loyo.myapplication.databinding.ActivityStatusBarBindingImpl
import com.loyo.myapplication.statusBar.StatusBarClick
import com.loyo.myapplication.statusBar.utils.StatusBarUtil

class StatusBarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityStatusBarBindingImpl>(
            this,
            R.layout.activity_status_bar
        ).also {
            it.click = StatusBarClick(this)
        }
    }
}
