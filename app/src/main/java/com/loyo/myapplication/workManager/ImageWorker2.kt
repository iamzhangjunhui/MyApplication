package com.loyo.myapplication.workManager

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import java.lang.Thread.sleep

class ImageWorker2(context: Context, workerParams: WorkerParameters) :
    Worker(context, workerParams) {
    override fun doWork(): Result {
        return try {
            //打印inputData
            Log.i("ImageWorker2", "image url:"+inputData.getString("image"))
            Log.i("ImageWorker2 耗时任务前", System.currentTimeMillis().toString()+Thread.currentThread().name)
            sleep(20000)
            Log.i("ImageWorker2 耗时任务后", System.currentTimeMillis().toString()+Thread.currentThread().name+"是否关闭："+isStopped)
            //将传入的inputData传作为output传回去
            Result.success(inputData)
        } catch (e: Exception) {
            Result.retry()
        }
    }

    override fun onStopped() {
        super.onStopped()
        //此时或者尽早关闭数据库和文件的打开句柄
        Log.i("ImageWorker2", "关闭work2 是否关闭：$isStopped")
    }

}