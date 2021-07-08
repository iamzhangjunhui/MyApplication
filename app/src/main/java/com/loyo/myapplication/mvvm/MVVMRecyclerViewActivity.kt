package com.loyo.myapplication.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.loyo.myapplication.R
import kotlinx.android.synthetic.main.activity_m_v_v_m_recycler_view.*

class MVVMRecyclerViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_m_v_v_m_recycler_view)
        recyclerview.layoutManager=LinearLayoutManager(this)
        recyclerview.adapter= MVVMRecyclerViewAdapter(arrayListOf("shss","ss","ss","ffr","shss","ss","ss","ffr","shss","ss","ss","ffr","shss","ss","ss","ffr","shss","ss","ss","ffr","shss","ss","ss","ffr","shss","ss","ss","ffr","shss","ss","ss","ffr","shss","ss","ss","ffr","shss","ss","ss","ffr","shss","ss","ss","ffr","shss","ss","ss","ffr","shss","ss","ss","ffr","shss","ss","ss","ffr"))
    }
}