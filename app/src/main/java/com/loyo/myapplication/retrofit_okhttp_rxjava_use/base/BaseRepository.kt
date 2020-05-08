package com.loyo.myapplication.retrofit_okhttp_rxjava_use.base

import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

open class BaseRepository {
    private val compositeDisposable by lazy() {
        CompositeDisposable()
    }
    fun addSubscribe(disposable: Disposable){
        compositeDisposable.add(disposable)
    }
    fun unSubscribe(){
        compositeDisposable.dispose()
    }
}