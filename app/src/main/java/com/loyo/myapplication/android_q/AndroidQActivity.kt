package com.loyo.myapplication.android_q

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomViewTarget
import com.loyo.myapplication.R
import kotlinx.android.synthetic.main.activity_android_q.*
import pub.devrel.easypermissions.AfterPermissionGranted
import pub.devrel.easypermissions.AppSettingsDialog
import pub.devrel.easypermissions.EasyPermissions
import pub.devrel.easypermissions.PermissionRequest


/**
 * 1.Android Q 在外部存储设备中为每个应用提供了一个“隔离存储沙盒”,任何其他应用都无法直接访问您应用的沙盒文件。由于文件是您应用的私有文件，因此您不再需要任何权限即可在外部存储设备中访问和保存自己的文件。
 * 谷歌官方推荐应用在沙盒内存储文件的地址为Context.getExternalFilesDir()下的文件夹。比如要存储一张图片,则应放在Context.getExternalFilesDir(Environment.DIRECTORY_PICTURES)中。
 *2. 访问系统媒体文件：Q中引入了一个新定义媒体文件的共享集合，如果要访问沙盒外的媒体共享文件，比如照片，音乐，视频等，需要申请新的媒体权限:READ_MEDIA_IMAGES,READ_MEDIA_VIDEO,READ_MEDIA_AUDIO,申请方法同原来的存储权限。
 *3.访问系统下载文件：对于系统下载文件夹的访问，暂时没做限制，但是，要访问其中其他应用的文件，必须允许用户使用系统的文件选择器应用来选择文件。
 */

class AndroidQActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_android_q)
        //部分url图片转成Bitmap有问题，Bitmap不为空但是加载出来是空白，addListener又没有报错
        Glide.with(this).asBitmap()
            .load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1587017992937&di=32880e1a7dedfebc81c7636dd28512d6&imgtype=0&src=http%3A%2F%2Fc.hiphotos.baidu.com%2Fzhidao%2Fpic%2Fitem%2Fd009b3de9c82d1587e249850820a19d8bd3e42a9.jpg")
            .into(object : CustomViewTarget<ImageView, Bitmap>(imageView4) {
                override fun onResourceReady(
                    resource: Bitmap,
                    transition: com.bumptech.glide.request.transition.Transition<in Bitmap>?
                ) {
                    SaveImageUtil.saveToSystemGallery(resource, this@AndroidQActivity)
                    //这里的view就是构造函数中传入的
                    imageView4.setImageBitmap(resource)
                }

                override fun onLoadFailed(errorDrawable: Drawable?) {

                }

                override fun onResourceCleared(placeholder: Drawable?) {
                }
            })
    }
}
