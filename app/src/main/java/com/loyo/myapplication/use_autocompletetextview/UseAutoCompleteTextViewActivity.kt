package com.loyo.myapplication.use_autocompletetextview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.loyo.myapplication.R
import kotlinx.android.synthetic.main.activity_use_auto_complete_text_view.*

class UseAutoCompleteTextViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_use_auto_complete_text_view)
        autoCompleteTextView.setAdapter(AutoCompleteTextViewAdapter(arrayListOf("sss","rere","tyt","yuyu")))
    }
}