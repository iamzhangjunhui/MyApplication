package com.loyo.myapplication.materialDesign.floatingActionMenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.loyo.myapplication.R
import kotlinx.android.synthetic.main.activity_floating_action_menu.*

class FloatingActionMenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_floating_action_menu)
        floatingActionButton1.setOnClickListener {
            Toast.makeText(this, "floatingActionButton1", Toast.LENGTH_SHORT).show()
        }
        floatingActionButton2.setOnClickListener {
            Toast.makeText(this, "floatingActionButton2", Toast.LENGTH_SHORT).show()
        }
    }
}
