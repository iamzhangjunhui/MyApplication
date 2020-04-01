package com.loyo.myapplication.recyclerview

import android.text.TextUtils
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.loyo.myapplication.R
import com.loyo.myapplication.databinding.ItemRecyclerviewBinding
import java.util.*
import kotlin.collections.ArrayList

class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    var list = arrayListOf<String>()
    private set

     fun setData(arrayList: ArrayList<String>) {
        if (list.size != 0) {
           var result: DiffUtil.DiffResult = DiffUtil.calculateDiff(object : DiffUtil.Callback() {
                override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                    return TextUtils.equals(list[oldItemPosition], arrayList[newItemPosition])
                }

                override fun getOldListSize(): Int {
                    return list.size
                }

                override fun getNewListSize(): Int {
                    return arrayList.size
                }

                override fun areContentsTheSame(
                    oldItemPosition: Int,
                    newItemPosition: Int
                ): Boolean {
                    return TextUtils.equals(list[oldItemPosition], arrayList[newItemPosition])
                }

            })
            list = arrayList
            result.dispatchUpdatesTo(this)
        } else {
            list.addAll(arrayList)
            notifyItemRangeInserted(0,list.size)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemRecyclerviewBinding = DataBindingUtil.inflate<ItemRecyclerviewBinding>(
            LayoutInflater.from(parent.context), R.layout.item_recyclerview, parent, false
        )
        return ViewHolder(itemRecyclerviewBinding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemRecyclerviewBinding.item = list[position]
        holder.itemRecyclerviewBinding.executePendingBindings()
        holder.itemView.setOnClickListener {
            setData(arrayListOf("kaylee", "bobo", "nancy", "aaa", "bbbbb", "RRrr", "7777"))
        }
    }

    class ViewHolder(var itemRecyclerviewBinding: ItemRecyclerviewBinding) :
        RecyclerView.ViewHolder(itemRecyclerviewBinding.root) {

    }
}