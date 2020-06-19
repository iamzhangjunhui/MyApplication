package com.loyo.myapplication.viewdraghelper

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.loyo.myapplication.R
import kotlinx.android.synthetic.main.activity_room.*
import kotlinx.android.synthetic.main.activity_use_view_drag_helper.*

class UseViewDragHelperActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_use_view_drag_helper)
        textView10.setOnClickListener { Toast.makeText(this,textView10.text,Toast.LENGTH_SHORT).show() }
        textView11.setOnClickListener { Toast.makeText(this,textView11.text,Toast.LENGTH_SHORT).show() }
        textView12.setOnClickListener { Toast.makeText(this,textView12.text,Toast.LENGTH_SHORT).show() }


    }
}
