package com.loyo.myapplication.useAssets

import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.webkit.WebChromeClient
import androidx.appcompat.app.AppCompatActivity
import com.loyo.myapplication.R
import kotlinx.android.synthetic.main.activity_use_assets.*
import javax.xml.parsers.SAXParserFactory

class UseAssetsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_use_assets)
        //加载assets中的html文件
        webView.loadUrl("file:///android_asset/policy.html")
        webView.webChromeClient = WebChromeClient()

        //加载assets中的图片
        //方法一：
//        val uri=Uri.parse("file:///android_asset/image/jack_beach.jpg")
//        Glide.with(this).load(uri).into(imageView)

        //方法二：
        val inputImage = assets.open("image/jack_beach.jpg")
        val bitmap = BitmapFactory.decodeStream(inputImage)
        imageView.setImageBitmap(bitmap)
        inputImage.close()

        //加载assets的xml文件
        val inputXml=assets.open("group.xml")
        val parser = SAXParserFactory.newInstance().newSAXParser()
        val groupTask=GroupHandlerTask()
        parser.parse(inputXml, groupTask)
        textView2.text = groupTask.groups.toString()
        Log.i("UseAssetsActivity",groupTask.groups.toString())
        inputXml.close()


        //跑马灯效果的必要条件之一
        textView2.isSelected = true
    }
}
