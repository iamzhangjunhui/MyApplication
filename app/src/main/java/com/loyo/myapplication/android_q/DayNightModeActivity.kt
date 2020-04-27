package com.loyo.myapplication.android_q

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.loyo.myapplication.R
import kotlinx.android.synthetic.main.activity_day_night_mode.*

class DayNightModeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //这个设置可以放在BaseActivity中设置，需要设置在setContentView之前才会生效
        //只要使用DayNight的theme,默认都会切换黑暗主题，默认背景颜色为黑色，字体颜色为白色
        //如果设置颜色没有在theme中定义，那么切换模式的时候不会变化
        if (getDarkModeStatus()) {
            setTheme(R.style.main_theme_dark)
        } else {
            setTheme(R.style.main_theme_light)
        }
        setContentView(R.layout.activity_day_night_mode)

    }

    private fun getDarkModeStatus(): Boolean {
        val mode = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
        return mode == Configuration.UI_MODE_NIGHT_YES
    }
}
