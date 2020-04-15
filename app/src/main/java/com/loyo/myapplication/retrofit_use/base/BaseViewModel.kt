package com.loyo.myapplication.retrofit_use.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.loyo.myapplication.Util.ReflectUtil

open class BaseViewModel<T:BaseRepository>(application: Application) : AndroidViewModel(application) {
    val mRepository: T by lazy {
        ReflectUtil.getClass<T>(this).getDeclaredConstructor()
            .newInstance()
    }

    override fun onCleared() {
        super.onCleared()
        mRepository.unSubscribe()
    }
}