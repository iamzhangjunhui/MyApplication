package com.loyo.myapplication.workManager

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.work.WorkInfo
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.loyo.myapplication.R
import kotlinx.android.synthetic.main.activity_use_assets.*
import kotlinx.android.synthetic.main.activity_work_manager.*

class WorkManagerActivity : AppCompatActivity() {
    private val imageViewModel: ImageViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work_manager)
        lifecycle.addObserver(imageViewModel)
        imageViewModel.getWorkInfosWork("work1").observe(this, Observer {
            if (it == null || it.isEmpty()) {
                return@Observer
            }
            val workInfo = it[0]
            if (workInfo.state == WorkInfo.State.SUCCEEDED) {
                val url = workInfo.outputData.getString("image")
                Log.i("WorkManagerActivity", "image url1:$url")

                Glide.with(this).load(url).error(R.drawable.ic_launcher_background)
                    .placeholder(R.mipmap.ic_launcher).into(imageView2)
            }
        })
        imageViewModel.getWorkInfosWork("work2").observe(this, Observer {
            if (it == null || it.isEmpty()) {
                return@Observer
            }
            if (it[0].state == WorkInfo.State.SUCCEEDED) {
                val url = it[0].outputData.getString("image")
                Log.i("WorkManagerActivity", "image url2:$url state:" + it[0].state)
                Glide.with(this).load(url).error(R.drawable.ic_launcher_background)
                    .placeholder(R.mipmap.ic_launcher).into(imageView3)
            }
        })

    }

}
