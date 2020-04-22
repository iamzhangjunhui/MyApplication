package com.loyo.myapplication.mutiLanguage

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.TextUtils
import androidx.appcompat.app.AppCompatActivity
import com.loyo.myapplication.R
import kotlinx.android.synthetic.main.activity_set_language.*
import java.util.*
import kotlin.system.exitProcess


class SetLanguageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_language)
        when (getConfiguration().language) {
            "zh"-> radioButton.isChecked = true
            "en" -> radioButton2.isChecked = true
        }
        radioButton.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                setConfiguration(Locale.SIMPLIFIED_CHINESE)
            }
        }
        radioButton2.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                setConfiguration(Locale.ENGLISH)
                SharedUtil.putString(this, "locale", "")
            }
        }
        button9.setOnClickListener {
            //这里最好重新启动到MainActivity
            val intent = Intent(this, MutiLanguageActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }

    private fun getConfiguration(): Locale {
        val localeS = SharedUtil.getString(this, "locale", "")
        return if (TextUtils.isEmpty(localeS)) {
            //获取系统设置语言
            val configuration = resources.configuration
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                configuration.locales[0]
            } else {
                configuration.locale
            }
        } else {
            return Locale(localeS!!)
        }
    }

    private fun setConfiguration(locale: Locale) {
        val configuration = resources.configuration
        configuration.setLocale(locale)
        //createConfigurationContext(configuration)设置不生效
        resources.updateConfiguration(configuration,resources.displayMetrics)
    }
}
