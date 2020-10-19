package com.loyo.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableField
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.loyo.myapplication.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import pub.devrel.easypermissions.AfterPermissionGranted
import pub.devrel.easypermissions.EasyPermissions
import java.util.jar.Manifest


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main).also {
            it.click = MainActivityClick(this)
            var data = ObservableField<String>()
            data.set("KAYLEE")
            it.data = data
            it.item = "kaylee"
            btnEmail.setOnClickListener{
                val uri = Uri.parse("mailto:1126238932@qq.com")
                //使用Intent.ACTION_SEND的会调起非邮箱应用
                val intent = Intent(Intent.ACTION_SENDTO, uri)
                startActivity(intent)
            }
        }
    }


}
