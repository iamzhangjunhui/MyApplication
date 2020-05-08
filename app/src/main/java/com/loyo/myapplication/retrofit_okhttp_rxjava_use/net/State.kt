package com.loyo.myapplication.retrofit_okhttp_rxjava_use.net

/**
 * author：  HyZhan
 * created： 2018/10/12 20:50
 * desc：    状态类
 */
data class State(var code: StateType, var msg: String = "", var tip: String="")