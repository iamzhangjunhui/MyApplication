package com.loyo.myapplication.retrofit_use

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.loyo.myapplication.R
import com.loyo.myapplication.retrofit_use.banner.bean.BannerRsp
import com.loyo.myapplication.databinding.ActivityRetrofitOkhttpRxjavaBinding
import com.loyo.myapplication.retrofit_use.base.LivecycleActivity
import com.loyo.myapplication.retrofit_use.net.State
import com.loyo.myapplication.retrofit_use.net.StateType


class RetrofitUseActivity :
    LivecycleActivity<BannerViewModel, ActivityRetrofitOkhttpRxjavaBinding>() {
    override fun getLayoutId(): Int = R.layout.activity_retrofit_okhttp_rxjava

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val data = MutableLiveData<List<BannerRsp>>(ArrayList())
        viewModel.getBanners(data).observe(this, toastObserver)


        dataBinding.list = data
    }

}
