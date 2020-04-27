package com.loyo.myapplication.statusBar

import android.content.Context
import android.content.Intent
import com.loyo.myapplication.statusBar.activity.StatusBarWordBlackActivity
import com.loyo.myapplication.statusBar.activity.StatusBarWordWhiteActivity
import com.loyo.myapplication.statusBar.activity.StatusPictureActivity

class StatusBarClick (val context: Context){
    fun toStatusBarWordWhite(){
        context.startActivity(Intent(context,StatusBarWordWhiteActivity::class.java))
    }
    fun toStatusBarWordBlack(){
        context.startActivity(Intent(context, StatusBarWordBlackActivity::class.java))
    }
    fun toStatusPicture(){
        context.startActivity(Intent(context,StatusPictureActivity::class.java))
    }
}