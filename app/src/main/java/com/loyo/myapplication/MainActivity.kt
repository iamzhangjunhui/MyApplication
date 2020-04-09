package com.loyo.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableChar
import androidx.databinding.ObservableField
import com.loyo.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main).also {
            it.click = MainActivityClick(this)
            var data=ObservableField<String>()
            data.set("KAYLEE")
            it.data= data
            it.item="kaylee"

        }
    }
}
