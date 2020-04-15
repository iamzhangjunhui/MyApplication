package com.loyo.myapplication.retrofit_use.base

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.loyo.myapplication.retrofit_use.net.BaseResponse
import com.loyo.myapplication.retrofit_use.net.State
import com.loyo.myapplication.retrofit_use.net.StateType
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

class BaseObserve<S, T : BaseResponse<S>>(
    private val liveData: MutableLiveData<S>,
    private val loadState: MutableLiveData<State>,
    private val mRepository: BaseRepository
) : Observer<T> {
    override fun onComplete() {
    }

    override fun onSubscribe(d: Disposable) {
        mRepository.addSubscribe(d)
    }

    override fun onNext(t: T) {
        if (t.errorCode == 0) {
            if (t.data is List<*>) {
                if ((t.data as List<*>).isEmpty()) {
                    Log.e("BaseObserve", "data 为null")
                    loadState.postValue(State(StateType.EMPTY, tip = "数据为空"))
                    return
                }
            }
            Log.i("BaseObserve", "加载成功")
            loadState.postValue(State(StateType.SUCCESS, tip = "加载成功"))
            liveData.postValue(t.data)
        } else {
            Log.e("BaseObserve", "errorCode:" + t.errorCode + "  errorMsg:" + t.errorMsg)
            loadState.postValue(State(StateType.ERROR, tip = t.errorMsg))
        }
    }

    override fun onError(e: Throwable?) {
        Log.e("BaseObserve", e.toString())
        loadState.postValue(State(StateType.NETWORK, tip = "网络不给力"))
    }

}