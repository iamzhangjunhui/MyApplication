package com.loyo.myapplication.retrofit_okhttp_rxjava_use.net

open class BaseResponse<T>(var data: T, var errorCode: Int = -1, var errorMsg: String = "")