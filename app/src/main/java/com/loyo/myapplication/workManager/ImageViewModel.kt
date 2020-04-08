package com.loyo.myapplication.workManager

import android.app.Application
import android.content.Context
import androidx.lifecycle.*
import androidx.work.*
import java.lang.Thread.sleep
import java.util.concurrent.TimeUnit

class ImageViewModel(application: Application) : AndroidViewModel(application), LifecycleObserver {
    private val workManager = WorkManager.getInstance(application)

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun apply() {
        /**
         * 指定网络状态执行任务
         * NetworkType.NOT_REQUIRED：对网络没有要求
         * NetworkType.CONNECTED：网络连接的时候执行
         * NetworkType.UNMETERED：不计费的网络比如WIFI下执行
         * NetworkType.NOT_ROAMING：非漫游网络状态
         * NetworkType.METERED：计费网络比如3G，4G下执行。
         */
        val constraints =
            Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()
        val requestWorker1 =
            OneTimeWorkRequestBuilder<ImageWorker1>()
                .addTag("work1")
                //加入队列后至少经过 1 秒再运行。
                .setInitialDelay(1, TimeUnit.SECONDS)
                .setInputData(workDataOf("image" to "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1586323903309&di=5d21ec79c0ef4ce81c0710152422b64e&imgtype=0&src=http%3A%2F%2Fvdposter.bdstatic.com%2F137578305b9c745685fab427c6118679.jpeg"))
                //最小重试时间不能小于10s,最大重试时间不能超过5小时
                //设置重试策略为每次增长为10*2^n,其中n为重试次数，比如第一次为10*2^0，第二次为：10*2^1，第三次为：10*2^2
                .setBackoffCriteria(BackoffPolicy.LINEAR, 10, TimeUnit.SECONDS)
                //添加约束
                .setConstraints(constraints).build()
        val requestWorker2 =
            OneTimeWorkRequestBuilder<ImageWorker2>().setInputData(workDataOf("image" to "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1586323903308&di=29fbb0cd521cb84796b56fa1d8682c29&imgtype=0&src=http%3A%2F%2Fpics4.baidu.com%2Ffeed%2F2cf5e0fe9925bc31bfe6323c3f89ddb7ca1370b3.jpeg%3Ftoken%3D8c0dbbd8c71510e420916599992f67bc%26s%3D4BA438626AD163E94D1421DE0000C0E2"))
                //设置重试策略为每次增长为10*n,第一次为10，第二次为20，第三次为30
                .setBackoffCriteria(BackoffPolicy.LINEAR, 10, TimeUnit.SECONDS)
                .setInputMerger(OverwritingInputMerger::class)
                .addTag("work2").build()
        //这样返回的output就是各自的了
        workManager.beginWith(listOf(requestWorker1, requestWorker2)).enqueue()
        //在使用 OneTimeWorkRequest 链时，父级 OneTimeWorkRequest 的输出将作为输入传递给子级
//      workManager.beginWith(requestWorker1).then(requestWorker2).enqueue()

    }

    fun getWorkInfosWork(tag: String): LiveData<List<WorkInfo>> {
        return workManager.getWorkInfosByTagLiveData(tag)
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun cancelAll() {
        workManager.cancelAllWork()
    }

}