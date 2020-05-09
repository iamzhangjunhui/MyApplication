package com.loyo.myapplication.Retrofit_okhttp_coroutines

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.loyo.myapplication.retrofit_okhttp_rxjava_use.banner.bean.BannerRsp
import com.loyo.myapplication.retrofit_okhttp_rxjava_use.base.BaseObserve
import com.loyo.myapplication.retrofit_okhttp_rxjava_use.base.BaseRepository
import com.loyo.myapplication.retrofit_okhttp_rxjava_use.net.RetrofitFactory
import com.loyo.myapplication.retrofit_okhttp_rxjava_use.net.State
import com.loyo.myapplication.Util.execute
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class BannerCoroutinesRepository : BaseRepository() {
    private val bannerService =
        RetrofitFactory.retrofit.create(
            IBannerSuspendService::class.java
        )

    suspend fun getBanner() =
        withContext(Dispatchers.IO) {
           bannerService.getBanner()
        }
}