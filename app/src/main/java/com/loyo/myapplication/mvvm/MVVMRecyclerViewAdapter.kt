package com.loyo.myapplication.mvvm

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.loyo.myapplication.BR
import com.loyo.myapplication.R

 class MVVMRecyclerViewAdapter(val data: ArrayList<String>) : RecyclerView.Adapter<MVVMRecyclerViewAdapter.ViewHolder>() {
    class ViewHolder(val dataBinding: ViewDataBinding) : RecyclerView.ViewHolder(dataBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context),R.layout.item_mvvm_recyclerview,parent,false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //绑定数据
        val binding=holder.dataBinding
        binding.setVariable(BR.itemMvvm,data[position])
    }

}