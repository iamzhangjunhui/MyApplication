package com.loyo.myapplication

import android.content.Context
import android.content.Intent
import com.loyo.myapplication.mutiLanguage.MutiLanguageActivity
import com.loyo.myapplication.android_q.AndroidQActivity
import com.loyo.myapplication.coroutines.CoroutinesActivity
import com.loyo.myapplication.easy_permissions.EasyPermissionsActivity
import com.loyo.myapplication.retrofit_use.RetrofitUseActivity
import com.loyo.myapplication.kotlinBy.KotlinByActivity
import com.loyo.myapplication.kotlinT.KotlinTActivity
import com.loyo.myapplication.useAssets.UseAssetsActivity
import com.loyo.myapplication.materialDesign.MaterialDesignActivity
import com.loyo.myapplication.recyclerview.RecycleViewActivity
import com.loyo.myapplication.room.RoomActivity
import com.loyo.myapplication.workManager.WorkManagerActivity

class MainActivityClick(private val context: Context) {
    fun toRecycleView() {
        context.startActivity(Intent(context, RecycleViewActivity::class.java))
    }

    fun toRoom() {
        context.startActivity(Intent(context, RoomActivity::class.java))
    }

    fun toMaterialDesignActivity() {
        context.startActivity(Intent(context, MaterialDesignActivity::class.java))
    }

    fun toAssets() {
        context.startActivity(Intent(context, UseAssetsActivity::class.java))
    }

    fun toWorkManager() {
        context.startActivity(Intent(context, WorkManagerActivity::class.java))
    }

    fun toKotlinBy() {
        context.startActivity(Intent(context, KotlinByActivity::class.java))
    }

    fun tokotlinT() {
        context.startActivity(Intent(context, KotlinTActivity::class.java))
    }

    fun toRetrofitOkhttpRxjava() {
        context.startActivity(Intent(context, RetrofitUseActivity::class.java))
    }

    fun toAndroidQ() {
        context.startActivity(Intent(context, AndroidQActivity::class.java))
    }

    fun toEasyPermissions() {
        context.startActivity(Intent(context, EasyPermissionsActivity::class.java))
    }

    fun toCoroutines() {
        context.startActivity(Intent(context, CoroutinesActivity::class.java))
    }

    fun toMutiLanguage() {
        context.startActivity(Intent(context, MutiLanguageActivity::class.java))
    }
}