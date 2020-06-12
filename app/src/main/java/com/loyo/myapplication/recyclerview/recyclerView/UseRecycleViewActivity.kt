package com.loyo.myapplication.recyclerview.recyclerView

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.loyo.myapplication.R
import com.loyo.myapplication.recyclerview.recyclerView.ItemTouchChangedCallBack
import com.loyo.myapplication.recyclerview.recyclerView.RecyclerViewAdapter
import com.loyo.myapplication.recyclerview.recyclerView.RecyclerviewItemDecoration
import kotlinx.android.synthetic.main.activity_recycle_view.*

class UseRecycleViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle_view)
        val recyclerViewAdapter =
            RecyclerViewAdapter()
        recyclerview.adapter = recyclerViewAdapter
        recyclerview.layoutManager = LinearLayoutManager(this)
        val callBack=
            ItemTouchChangedCallBack(
                recyclerViewAdapter
            )
        val itemHelper=ItemTouchHelper(callBack)
        itemHelper.attachToRecyclerView(recyclerview)
        recyclerview.addItemDecoration(RecyclerviewItemDecoration())
        button2.setOnClickListener {
            recyclerViewAdapter.setData(arrayListOf("kaylee", "bobo", "nancy", "aaa", "bbbbb", "RRrr", "7777"))
        }
    }
}
