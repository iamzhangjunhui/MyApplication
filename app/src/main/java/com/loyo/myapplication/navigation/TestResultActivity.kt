package com.loyo.myapplication.navigation

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.loyo.myapplication.R

class TestResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_result)
    }

    override fun onBackPressed() {
        val intent = Intent()
        intent.putExtra("name", "kaylee")
        setResult(Activity.RESULT_OK, intent)
        super.onBackPressed()

    }
}
