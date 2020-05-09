package com.loyo.myapplication.Retrofit_okhttp_coroutines;


import com.loyo.myapplication.retrofit_okhttp_rxjava_use.banner.bean.BannerRsp
import com.loyo.myapplication.retrofit_okhttp_rxjava_use.net.BaseResponse
import retrofit2.http.GET;

public interface IBannerSuspendService {
    @GET("/banner/json")
    suspend fun getBanner(): BaseResponse<List<BannerRsp>>
}
