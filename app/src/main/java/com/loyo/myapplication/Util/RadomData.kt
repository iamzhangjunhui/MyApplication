package com.loyo.myapplication.Util

import java.util.*


class RadomData {
    companion object {
        private val random = Random()
        //传入一组数据，从该组数据中随机返回一个字符串
        fun getRandomData(list: List<String>): String {
            val index = random.nextInt(
                list.size)
            return list[index]
        }
    }
}