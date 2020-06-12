package com.loyo.myapplication.recyclerview.recyclerView_listadapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.loyo.myapplication.R
import kotlinx.android.synthetic.main.item_test_listadapter.view.*

class MyListAdapter : ListAdapter<Person, MyListAdapter.ViewHolder>(PersonItemCallback()){
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_test_listadapter,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val person=getItem(position)
        holder.itemView.textView7.text=person.name
        holder.itemView.textView8.text= person.age.toString()
    }


}

class PersonItemCallback : ItemCallback<Person>() {
    override fun areItemsTheSame(oldItem: Person, newItem: Person): Boolean {
        return oldItem.name == newItem.name&&oldItem.age==newItem.age
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: Person, newItem: Person): Boolean {
        return newItem == oldItem
    }


}