package com.loyo.myapplication.retrofit_okhttp_rxjava_use.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.loyo.myapplication.Util.ReflectUtil
import com.loyo.myapplication.retrofit_okhttp_rxjava_use.net.State
import com.loyo.myapplication.retrofit_okhttp_rxjava_use.net.StateType

/**
 * activity基类
 * 1.定义Activity的ViewModel
 * 2.定义Activity的ViewDataBinding
 * 3.The LifecycleOwner that should be used for observing changes of LiveData in this binding.
 */
open abstract class LivecycleActivity<T : BaseViewModel<*>, S : ViewDataBinding> :
    AppCompatActivity() {
    lateinit var viewModel: T
    lateinit var dataBinding: S
    val toastObserver = Observer<State> { t ->
        when (t.code) {
            StateType.SUCCESS -> {
                Toast.makeText(
                    this,
                    "加载成功",
                    Toast.LENGTH_SHORT
                ).show()
                Log.i("toastObserver", "加载成功")
            }
            StateType.EMPTY -> {
                Toast.makeText(
                    this,
                    "数据为空",
                    Toast.LENGTH_SHORT
                ).show()
                Log.i("toastObserver", "数据为空")
            }

            StateType.NETWORK -> {
                Toast.makeText(
                    this,
                    "网络不给力",
                    Toast.LENGTH_SHORT
                ).show()
                Log.i("toastObserver", "网络不给力")

            }
            else -> {
                Toast.makeText(
                    this,
                    "加载失败",
                    Toast.LENGTH_SHORT
                ).show()
                Log.i("toastObserver", "加载失败")

            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel =
            ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory(application)).get(
                ReflectUtil.getClass(this)
            )
        dataBinding = DataBindingUtil.setContentView<S>(
            this,
            getLayoutId()
        ).also {
            it.lifecycleOwner = this
        }
    }

    abstract fun getLayoutId(): Int
}
