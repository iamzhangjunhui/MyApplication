package com.loyo.myapplication.retrofit_okhttp_rxjava_use.banner;

import com.loyo.myapplication.retrofit_okhttp_rxjava_use.banner.bean.BannerRsp
import com.loyo.myapplication.retrofit_okhttp_rxjava_use.net.BaseResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET;

public interface IBannerService {
    @GET("/banner/json")
    fun getBanner(): Observable<BaseResponse<List<BannerRsp>>>
}
