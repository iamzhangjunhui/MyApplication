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
import java.util.jar.Manifest


/**
 * 1.Android Q 在外部存储设备中为每个应用提供了一个“隔离存储沙盒”,任何其他应用都无法直接访问您应用的沙盒文件。由于文件是您应用的私有文件，因此您不再需要任何权限即可在外部存储设备中访问和保存自己的文件。
 * 谷歌官方推荐应用在沙盒内存储文件的地址为Context.getExternalFilesDir()下的文件夹。比如要存储一张图片,则应放在Context.getExternalFilesDir(Environment.DIRECTORY_PICTURES)中。
 * 2.访问其他应用沙盒中的文件，继续使用 READ_EXTERNAL_STORAGE 和 WRITE_EXTERNAL_STORAGE 权限，只不过当拥有这些权限的时候，你只能访问媒体文件，无法访问其他文件。
 * 3.访问其他应用沙盒中的除媒体文件外的文件，必须使用存储访问框架（https://developer.android.google.cn/guide/topics/providers/document-provider）
 */

class AndroidQActivity : AppCompatActivity(), EasyPermissions.PermissionCallbacks {
    val REQUEST_PERMISSION = android.Manifest.permission.WRITE_EXTERNAL_STORAGE
    val REQUEST_CODE = 1002
    lateinit var bitmap: Bitmap
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
                    bitmap = resource
                    requestWritePermission()
                }

                override fun onLoadFailed(errorDrawable: Drawable?) {

                }

                override fun onResourceCleared(placeholder: Drawable?) {
                }
            })
    }

    fun requestWritePermission() {
        if (EasyPermissions.hasPermissions(this, REQUEST_PERMISSION)) {
            SaveImageUtil.saveToSystemGallery(bitmap, this@AndroidQActivity)
            //这里的view就是构造函数中传入的
            imageView4.setImageBitmap(bitmap)
        } else {
            EasyPermissions.requestPermissions(this, "需要写权限", REQUEST_CODE, REQUEST_PERMISSION)
        }
    }

    override fun onPermissionsDenied(requestCode: Int, perms: MutableList<String>) {
        if (EasyPermissions.permissionPermanentlyDenied(this, REQUEST_PERMISSION)) {
            AppSettingsDialog.Builder(this).build().show()
        }
    }

    override fun onPermissionsGranted(requestCode: Int, perms: MutableList<String>) {
        SaveImageUtil.saveToSystemGallery(bitmap, this@AndroidQActivity)
        //这里的view就是构造函数中传入的
        imageView4.setImageBitmap(bitmap)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this)
    }
}
