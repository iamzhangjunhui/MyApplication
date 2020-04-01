package com.loyo.myapplication.recyclerview

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.arch.core.util.Function
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.loyo.myapplication.R
import kotlinx.android.synthetic.main.activity_recycle_view.*
import javax.xml.transform.Source

class RecycleViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle_view)
        val recyclerViewAdapter = RecyclerViewAdapter()
        recyclerview.adapter = recyclerViewAdapter
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.addItemDecoration(object : RecyclerView.ItemDecoration() {

        })
        button2.setOnClickListener {
            recyclerViewAdapter.setData(arrayListOf("kaylee"))

        }

    }
}
