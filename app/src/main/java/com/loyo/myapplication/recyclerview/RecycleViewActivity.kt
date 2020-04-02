package com.loyo.myapplication.recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.loyo.myapplication.R
import kotlinx.android.synthetic.main.activity_recycle_view.*

class RecycleViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle_view)
        val recyclerViewAdapter = RecyclerViewAdapter()
        recyclerview.adapter = recyclerViewAdapter
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.addItemDecoration(RecyclerviewItemDecoration())
        button2.setOnClickListener {
            recyclerViewAdapter.setData(arrayListOf("kaylee", "bobo", "nancy", "aaa", "bbbbb", "RRrr", "7777"))
        }
    }
}
