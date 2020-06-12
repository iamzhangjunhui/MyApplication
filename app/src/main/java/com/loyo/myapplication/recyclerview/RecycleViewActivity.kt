package com.loyo.myapplication.recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.loyo.myapplication.R
import com.loyo.myapplication.recyclerview.recyclerView.UseRecycleViewActivity
import com.loyo.myapplication.recyclerview.recyclerView_listadapter.RecyclerViewListAdaoterActivity
import kotlinx.android.synthetic.main.activity_recycle_view2.*

class RecycleViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle_view2)
        button25.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    UseRecycleViewActivity::class.java
                )
            )
        }
        button26.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    RecyclerViewListAdaoterActivity::class.java
                )
            )
        }
    }
}
