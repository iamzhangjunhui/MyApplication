package com.loyo.myapplication.retrofit_okhttp_rxjava_use.banner

import androidx.lifecycle.MutableLiveData
import com.loyo.myapplication.retrofit_okhttp_rxjava_use.banner.bean.BannerRsp
import com.loyo.myapplication.retrofit_okhttp_rxjava_use.base.BaseObserve
import com.loyo.myapplication.retrofit_okhttp_rxjava_use.base.BaseRepository
import com.loyo.myapplication.retrofit_okhttp_rxjava_use.net.RetrofitFactory
import com.loyo.myapplication.retrofit_okhttp_rxjava_use.net.State
import com.loyo.myapplication.Util.execute

class BannerRepository : BaseRepository() {
    private val bannerService =
        RetrofitFactory.retrofit.create(
            IBannerService::class.java
        )

    fun getBanner(liveData: MutableLiveData<List<BannerRsp>>,loadState:MutableLiveData<State>) {
        return bannerService.getBanner().execute(BaseObserve(liveData, loadState, this))
    }
}