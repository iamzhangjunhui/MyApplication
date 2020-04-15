package com.loyo.myapplication.retrofit_use

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.loyo.myapplication.retrofit_use.banner.BannerRepository
import com.loyo.myapplication.retrofit_use.banner.bean.BannerRsp
import com.loyo.myapplication.retrofit_use.base.BaseViewModel
import com.loyo.myapplication.retrofit_use.net.State

class BannerViewModel(application: Application) :
    BaseViewModel<BannerRepository>(application) {

    fun getBanners(liveData: MutableLiveData<List<BannerRsp>>): MutableLiveData<State> {
        val loadState = MutableLiveData<State>()
        mRepository.getBanner(liveData, loadState)
        return loadState
    }
}