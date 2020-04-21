package com.loyo.myapplication.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.loyo.myapplication.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class CoroutinesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?)= runBlocking {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutines)
        //新建一个协程
        val job=GlobalScope.launch {
            delay(1000)//是一个特殊的 挂起函数 ，它不会造成线程阻塞，但是会 挂起 协程，并且只能在协程中使用。
            Log.i("CoroutinesActivity","协程中非阻塞等待1s")
        }
        job.join()//等待子协程完成才进行
    }

}
