package com.loyo.myapplication.recyclerview.recyclerview_contactadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.loyo.myapplication.R
import com.loyo.myapplication.recyclerview.recyclerView.RecyclerViewAdapter
import kotlinx.android.synthetic.main.item1.view.*


class Adapter1 (val  data:ArrayList<String>): RecyclerView.Adapter<Adapter1.ViewHolder>() {
    class ViewHolder(item: View) : RecyclerView.ViewHolder(item)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item1,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.txt1.text=data[position]
    }


}