package com.loyo.myapplication.mutiLanguage

import android.content.Context
import android.content.SharedPreferences

object SharedUtil {
    private const val sharedName = "shared_data"
    private fun getSharedPreference(context: Context): SharedPreferences {
        return context.getSharedPreferences(sharedName, Context.MODE_PRIVATE)
    }

    private fun getSharedPreferencesEdit(context: Context): SharedPreferences.Editor {
        return context.getSharedPreferences(sharedName, Context.MODE_PRIVATE).edit()

    }

    fun putString(context: Context, name: String, value: String) {
        getSharedPreferencesEdit(context).putString(name, value).commit()
    }

    fun getString(context: Context, name: String, defaultValue: String):String? {
        return getSharedPreference(context).getString(name,defaultValue)
    }
}