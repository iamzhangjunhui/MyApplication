package com.loyo.myapplication.recyclerview.recyclerview_contactadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.loyo.myapplication.R
import kotlinx.android.synthetic.main.item2.view.*


class Adapter2 (val data:ArrayList<String>): RecyclerView.Adapter<Adapter2.ViewHolder>() {
    class ViewHolder(item: View) : RecyclerView.ViewHolder(item)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item2,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return  data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.txt2.text=data[position]
    }


}