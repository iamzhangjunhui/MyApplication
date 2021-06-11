package com.loyo.myapplication.recyclerview.recyclerview_contactadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.loyo.myapplication.R
import kotlinx.android.synthetic.main.activity_recycler_view_concat_adapter.*

class RecyclerViewConcatAdapterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_concat_adapter)
        val config = ConcatAdapter.Config.Builder()
            .setIsolateViewTypes(true)
            .setStableIdMode(ConcatAdapter.Config.StableIdMode.SHARED_STABLE_IDS).build()
        val adapter = ConcatAdapter(config)
        adapter.addAdapter(Adapter1(arrayListOf("Aa", "aaa")).apply { setHasStableIds(true) })
        adapter.addAdapter(Adapter2(arrayListOf("qq", "ddd")).apply { setHasStableIds(true) })
        recyclerview.adapter = adapter
        recyclerview.layoutManager = LinearLayoutManager(this )
    }
}