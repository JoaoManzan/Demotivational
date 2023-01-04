package com.example.demotivational.infra

import android.content.Context
import android.content.SharedPreferences

class SecurityPreferences(context: Context) {

    private val security: SharedPreferences =
        context.getSharedPreferences("Demotivation", Context.MODE_PRIVATE)

    fun storeString(key: String, str: String) {
        this.security.edit().putString(key, str).apply()
    }

    fun getString(key: String): String {
        return this.security.getString(key, "") ?: ""
    }
}