package com.loyo.myapplication.easy_permissions


import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.loyo.myapplication.R
import kotlinx.android.synthetic.main.activity_easy_permissions.*
import pub.devrel.easypermissions.AfterPermissionGranted
import pub.devrel.easypermissions.AppSettingsDialog
import pub.devrel.easypermissions.EasyPermissions
import pub.devrel.easypermissions.PermissionRequest

//an annotation argument must be a compile-time constant
private const val PERMISSION_WRITE_CODE: Int = 1001

class EasyPermissionsActivity : AppCompatActivity(), EasyPermissions.PermissionCallbacks {
    val PERMISSION_WRITE = android.Manifest.permission.WRITE_EXTERNAL_STORAGE
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_easy_permissions)
        button.setOnClickListener { requestPermission() }

    }

    @AfterPermissionGranted(PERMISSION_WRITE_CODE)//这个注解可有可无
    fun requestPermission() {
        if (EasyPermissions.hasPermissions(this, PERMISSION_WRITE)) {
            Toast.makeText(this, "权限获取成功", Toast.LENGTH_SHORT).show()
        } else {
//            EasyPermissions.requestPermissions(this,"需要写权限", PERMISSION_WRITE_CODE,PERMISSION_WRITE)
            //或者为了更好地控制对话框，使用以下方式
            EasyPermissions.requestPermissions(
                PermissionRequest.Builder(this, PERMISSION_WRITE_CODE, PERMISSION_WRITE)
                    .setRationale("需要获取写权限")
                    .setPositiveButtonText("确定")
                    .setNegativeButtonText("取消")
                    .build()
            )
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        //需要传入receivers：this,否则无法监听到PermissionCallbacks
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this)
    }

    override fun onPermissionsDenied(requestCode: Int, perms: MutableList<String>) {
        if (EasyPermissions.permissionPermanentlyDenied(this, PERMISSION_WRITE)
        ) {
            //这个提示框的语言为英文的，可以进行自定义
            AppSettingsDialog.Builder(this).setTitle("需要请求写权限").setRationale("设置为啥必须该权限")
                .setNegativeButton("取消").setPositiveButton("设置").build().show()
        }

    }

    override fun onPermissionsGranted(requestCode: Int, perms: MutableList<String>) {
        Toast.makeText(this, "权限获取成功", Toast.LENGTH_SHORT).show()


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        //从设置页返回
        if (requestCode == AppSettingsDialog.DEFAULT_SETTINGS_REQ_CODE) { // Do something after user returned from app settings screen, like showing a Toast.
            Toast.makeText(
                this,
                "从设置页返回",
                Toast.LENGTH_SHORT
            )
                .show()
        }
    }

}
