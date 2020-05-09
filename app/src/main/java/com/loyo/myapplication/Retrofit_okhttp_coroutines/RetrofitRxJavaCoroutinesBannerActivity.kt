package com.loyo.myapplication.Retrofit_okhttp_coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.loyo.myapplication.R
import com.loyo.myapplication.databinding.ActivityRetrofitOkhttpRxjavaBinding
import com.loyo.myapplication.databinding.ActivityRetrofitRxJavaCoroutinesBannerBinding

class RetrofitRxJavaCoroutinesBannerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityRetrofitRxJavaCoroutinesBannerBinding>(
            this,
            R.layout.activity_retrofit_rx_java_coroutines_banner
        ).also {
            val bannerViewModelCoroutines = ViewModelProvider(this,ViewModelProvider.NewInstanceFactory()).get(BannerViewModelCoroutines::class.java)
            it.banners=bannerViewModelCoroutines.bannersLiveData
            bannerViewModelCoroutines.getBanners()
            it.lifecycleOwner=this
        }
    }
}
