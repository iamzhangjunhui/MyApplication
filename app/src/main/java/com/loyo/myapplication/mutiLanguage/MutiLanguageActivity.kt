package com.loyo.myapplication.mutiLanguage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.loyo.myapplication.R.layout.activity_muti_language
import kotlinx.android.synthetic.main.activity_muti_language.*

class MutiLanguageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_muti_language)
        button8.setOnClickListener {
            startActivity(Intent(this,SetLanguageActivity::class.java))
        }
    }


}