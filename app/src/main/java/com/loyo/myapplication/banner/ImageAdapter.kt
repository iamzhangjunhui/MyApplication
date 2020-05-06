package com.loyo.myapplication.banner

import android.content.Context
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.youth.banner.adapter.BannerAdapter
import org.jetbrains.annotations.NotNull

class ImageAdapter(datas: List<String>):BannerAdapter<String, ImageAdapter.ImageViewHolder>(datas) {
    lateinit var context: Context

    class ImageViewHolder(@NotNull val imageView: ImageView) : RecyclerView.ViewHolder(imageView)

    override fun onCreateHolder(parent: ViewGroup?, viewType: Int): ImageViewHolder {
        context = parent!!.context
        val imageView = ImageView(context)
        imageView.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        imageView.scaleType=ImageView.ScaleType.FIT_XY
        return ImageViewHolder(imageView)
    }

    override fun onBindView(holder: ImageViewHolder?, data: String?, position: Int, size: Int) {
        Glide.with(context).load(data!!).into( holder!!.imageView)
    }
}