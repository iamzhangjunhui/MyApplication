package com.loyo.myapplication.retrofit_okhttp_rxjava_use.banner.bean

/**
 * author：  HyZhan
 * created： 2018/10/14 18:57
 * desc：    banner
 */
data class BannerRsp(var id: Int,
                var desc: String,
                var imagePath: String,
                var title: String,
                var url: String)