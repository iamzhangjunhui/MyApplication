package com.loyo.myapplication.Retrofit_okhttp_coroutines

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.loyo.myapplication.Util.safeLaunch
import com.loyo.myapplication.retrofit_okhttp_rxjava_use.banner.bean.BannerRsp

class BannerViewModelCoroutines : ViewModel() {
    var bannersLiveData = MutableLiveData<List<BannerRsp>>()
    fun getBanners() {
        //viewModelScope,This scope will be canceled when ViewModel will be cleared
        viewModelScope.safeLaunch {
            block = {
                val response = BannerCoroutinesRepository().getBanner()
                if (response.errorCode == 0) {
                    bannersLiveData.postValue(response.data)
                } else {
                    Log.i("getBannerSuccess", response.errorMsg)
                }
            }
            error = { error -> Log.i("getBannerError", error.toString()) }
        }
    }
}