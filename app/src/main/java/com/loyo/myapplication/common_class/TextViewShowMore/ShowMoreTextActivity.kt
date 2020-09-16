package com.loyo.myapplication.common_class.TextViewShowMore

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.loyo.myapplication.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*

/**
 * 参考： https://blog.csdn.net/dodouaj/article/details/52212835
 */
class ShowMoreTextActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        // 必须要计算并初始化宽度
        tvTest.initWidth(getWindowWidth(this))
        // 调用这个方法进行初始化设置文本内容
        tvTest.setExpandText("skdjsakljdsa多久啊可是多久撒开多久啊是开多久啊是开多久啊是卡卡的手机刷卡机大手大脚了打算金德拉克萨卡卡卢萨卡巨大的克拉克打开链接卡丹江口市卡里克打到卡接口接口大sad           开多久啊是科技大开店啦多久啊离开大厦看见的撒了多久撒离开多久啊哭多久啊哭多久啊哭大大口大口多久啊哭哭大的空间看看大家睡觉啊科技大空间啊就睡觉啊大家看撒开借记卡就卡记得记得记得就看见多久空间")

    }
    fun dp2px(dpValue: Float): Int {
        val scale: Float = getResources().getDisplayMetrics().density
        return (dpValue * scale + 0.5f).toInt()
    }
    fun getWindowWidth(context: Context): Int {
        val wm = context
            .getSystemService(Context.WINDOW_SERVICE) as WindowManager
        return wm.defaultDisplay.width
    }
}