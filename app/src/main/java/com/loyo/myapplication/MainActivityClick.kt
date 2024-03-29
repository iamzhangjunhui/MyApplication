package com.loyo.myapplication

import android.content.Context
import android.content.Intent
import com.loyo.myapplication.Retrofit_okhttp_coroutines.RetrofitRxJavaCoroutinesBannerActivity
import com.loyo.myapplication.mutiLanguage.MutiLanguageActivity
import com.loyo.myapplication.android_q.AndroidQActivity
import com.loyo.myapplication.banner.BannerActivity
import com.loyo.myapplication.common_class.TextViewShowMore.ShowMoreTextActivity
import com.loyo.myapplication.coroutines.CoroutinesActivity
import com.loyo.myapplication.displayCutout.DisplayCutoutActivity
import com.loyo.myapplication.easy_permissions.EasyPermissionsActivity
import com.loyo.myapplication.gesture_detector_compat.UseGestureDetectorCompatInActivity
import com.loyo.myapplication.retrofit_okhttp_rxjava_use.RetrofitUseActivity
import com.loyo.myapplication.kotlinBy.KotlinByActivity
import com.loyo.myapplication.kotlinT.KotlinTActivity
import com.loyo.myapplication.useAssets.UseAssetsActivity
import com.loyo.myapplication.materialDesign.MaterialDesignActivity
import com.loyo.myapplication.mvvm.MVVMRecyclerViewActivity
import com.loyo.myapplication.navigation.NavigationActivity
import com.loyo.myapplication.netStatus.NetStatusActivity
import com.loyo.myapplication.recyclerview.RecycleViewActivity
import com.loyo.myapplication.room.RoomActivity
import com.loyo.myapplication.statusBar.activity.StatusBarActivity
import com.loyo.myapplication.use_autocompletetextview.UseAutoCompleteTextViewActivity
import com.loyo.myapplication.viewdraghelper.UseViewDragHelperActivity
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

    fun toRetrofitOkhttpCoroutines() {
        context.startActivity(Intent(context, RetrofitRxJavaCoroutinesBannerActivity::class.java))
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

    fun toStatusBar() {
        context.startActivity(Intent(context, StatusBarActivity::class.java))
    }

    fun toNetStatus() {
        context.startActivity(Intent(context, NetStatusActivity::class.java))
    }

    fun toNavigation() {
        context.startActivity(Intent(context, NavigationActivity::class.java))
    }

    fun toDisplayCutout() {
        context.startActivity(Intent(context, DisplayCutoutActivity::class.java))
    }

    fun toBanner() {
        context.startActivity(Intent(context, BannerActivity::class.java))
    }
    fun toGestureDetectorCompat(){
        context.startActivity(Intent(context,UseGestureDetectorCompatInActivity::class.java))
    }
    fun toViewDragHelper(){
        context.startActivity(Intent(context,UseViewDragHelperActivity::class.java))
    }
    fun toTextShowMoreTextView(){
        context.startActivity(Intent(context,ShowMoreTextActivity::class.java))
    }
    fun toMVVM(){
        context.startActivity(Intent(context,MVVMRecyclerViewActivity::class.java))
    }
    fun toAutoCompleteTextView(){
        context.startActivity(
            Intent(context,
                UseAutoCompleteTextViewActivity::class.java)
        )
    }
}