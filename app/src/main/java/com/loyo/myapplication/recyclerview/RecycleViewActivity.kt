package com.loyo.myapplication.recyclerview

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.loyo.myapplication.R
import kotlinx.android.synthetic.main.activity_recycle_view.*

class RecycleViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle_view)
        val recyclerViewAdapter = RecyclerViewAdapter()
        recyclerview.adapter = recyclerViewAdapter
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.addItemDecoration(object : RecyclerView.ItemDecoration() {

        })
        val source: LiveData<String> = MutableLiveData("KAYLEE")
        Log.i("日志source", source.value)

        val result =Transformations.switchMap(source){
            MutableLiveData("bbo")
        }


        Log.i("日志", result.value + "null")
        button2.setOnClickListener {
            recyclerViewAdapter.setData(arrayListOf("kaylee"))

        }

    }
}
