package com.loyo.myapplication.banner

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.loyo.myapplication.R
import com.youth.banner.indicator.CircleIndicator
import kotlinx.android.synthetic.main.activity_banner.*

/**
 * banner的使用文档：
 * https://github.com/youth5201314/banner
 */
class BannerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_banner)
        banner.adapter = ImageAdapter(
            listOf<String>(
                "http://tupian.qianqianhua.com/uploads/20180108/00/1515341994-RbwiXIhetD.jpg",
                "http://tupian.qianqianhua.com/uploads/20180108/00/1515341995-SkQoPqClWF.jpg",
                "http://tupian.qianqianhua.com/uploads/20180108/00/1515341996-kgJucQtvIG.jpg",
                "http://tupian.qianqianhua.com/uploads/20180108/00/1515342001-DCFWMBOjZK.jpg"
            )
        )
        banner.setIndicator(CircleIndicator(this))
        banner.setIndicatorSelectedColor(Color.RED)
    }

    override fun onStart() {
        super.onStart()
        //开始轮播
        banner.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        //结束轮播
        banner.destroy()
    }
}
