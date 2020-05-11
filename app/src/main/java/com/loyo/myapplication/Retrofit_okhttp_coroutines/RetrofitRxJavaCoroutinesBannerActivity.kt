package com.loyo.myapplication.Retrofit_okhttp_coroutines

import android.app.AlertDialog
import android.app.Dialog
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.loyo.myapplication.NetState
import com.loyo.myapplication.R
import com.loyo.myapplication.databinding.ActivityRetrofitOkhttpRxjavaBinding
import com.loyo.myapplication.databinding.ActivityRetrofitRxJavaCoroutinesBannerBinding
import kotlinx.android.synthetic.main.activity_retrofit_rx_java_coroutines_banner.*

class RetrofitRxJavaCoroutinesBannerActivity : AppCompatActivity() {
    lateinit var dialog: AlertDialog
    lateinit var bannerViewModelCoroutines: BannerViewModelCoroutines
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityRetrofitRxJavaCoroutinesBannerBinding>(
            this,
            R.layout.activity_retrofit_rx_java_coroutines_banner
        ).also { it ->
            bannerViewModelCoroutines =
                ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(
                    BannerViewModelCoroutines::class.java
                )
            it.banners = bannerViewModelCoroutines.bannersLiveData
            //注意这里的NetState需要定义在com.loyo.myapplication.Retrofit_okhttp_coroutines包外，否则会报Type mismatch: inferred type is MutableLiveData<com.loyo.myapplication.Retrofit_okhttp_coroutines.NetState> but MutableLiveData<Retrofit_okhttp_coroutines.NetState!>? was expected
            it.netState = bannerViewModelCoroutines.netState
            bannerViewModelCoroutines.getBanners()
            it.lifecycleOwner = this

            netDialog()

        }

    }

    fun netDialog() {
        bannerViewModelCoroutines.netState.observe(this, Observer<NetState> {
            if (it == NetState.Success || it == NetState.Default) {
                dialog.dismiss()
            } else if (it == NetState.Loading) {
                dialog.show()
            } else if (it == NetState.Error) {
                dialog.setMessage("加载失败")
            }
        })
        dialog = AlertDialog.Builder(this).create()
        dialog.setMessage("正在加载中。。")
    }
}
