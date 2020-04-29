package com.loyo.myapplication.displayCutout

import android.app.Activity
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.DisplayCutout
import android.view.View
import android.view.WindowInsets
import android.view.WindowManager
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.setMargins
import com.loyo.myapplication.R
import com.loyo.myapplication.statusBar.utils.StatusBarUtil
import kotlinx.android.synthetic.main.activity_display_cutout.*

class DisplayCutoutActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_cutout)
        StatusBarUtil.setRootViewFitsSystemWindows(this, true);
        StatusBarUtil.setTranslucentStatus(this)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) {
            root_layout.setOnApplyWindowInsetsListener { v, insets ->
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                    val displayCutout: DisplayCutout? = insets.displayCutout
                    val bottom = displayCutout?.safeInsetBottom
                    val left = displayCutout?.safeInsetLeft
                    val right = displayCutout?.safeInsetRight
                    val top = displayCutout?.safeInsetTop
                    val param: ConstraintLayout.LayoutParams =
                        button14.layoutParams as ConstraintLayout.LayoutParams
                    param.setMargins(left ?: 0, top ?: 0, right ?: 0, bottom ?: 0)

                    val param2: ConstraintLayout.LayoutParams =
                        button15.layoutParams as ConstraintLayout.LayoutParams
                    param2.setMargins(left ?: 0, top ?: 0, right ?: 0, bottom ?: 0)

                    val param3: ConstraintLayout.LayoutParams =
                        button16.layoutParams as ConstraintLayout.LayoutParams
                    param3.setMargins(left ?: 0, top ?: 0, right ?: 0, bottom ?: 0)

                    val param4: ConstraintLayout.LayoutParams =
                        button17.layoutParams as ConstraintLayout.LayoutParams
                    param4.setMargins(left ?: 0, top ?: 0, right ?: 0, bottom ?: 0)
                    return@setOnApplyWindowInsetsListener insets.consumeSystemWindowInsets()
                } else {
                    Log.i("DisplayCutoutActivity", "小于Android 9.0")
                    return@setOnApplyWindowInsetsListener insets.consumeSystemWindowInsets()
                }
            }
        }

    }
}
