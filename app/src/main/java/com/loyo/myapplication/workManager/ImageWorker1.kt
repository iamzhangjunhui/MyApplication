package com.loyo.myapplication.workManager

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import java.lang.Thread.currentThread

class ImageWorker1(context: Context, workerParams: WorkerParameters) :
    Worker(context, workerParams) {
    override  fun doWork(): Result {
        return try {
            Log.i("ImageWorker1", "image url:"+inputData.getString("image"))
            Log.i("ImageWorker1", currentThread().name)
            throw Exception("抛异常")
//            Result.success(inputData)
        } catch (e: Exception) {
            Result.retry()
        }    }


}