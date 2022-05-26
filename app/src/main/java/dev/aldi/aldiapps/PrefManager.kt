package dev.aldi.aldiapps

import android.annotation.SuppressLint
import android.content.Context;
import android.content.SharedPreferences;

class PrefManager(val context: Context, private val preferenceName: String = "AldiNugrahaApps") {
    private val pref: SharedPreferences
        get() = context.getSharedPreferences(preferenceName, Context.MODE_PRIVATE)

    private val editor: SharedPreferences.Editor
        @SuppressLint("CommitPrefEdits") get() = pref.edit()

    var firstTime: Boolean
        get() = pref.getBoolean("FIRST_TIME", true)
        set(value) {
            editor.putBoolean("FIRST_TIME", value).apply()
        }
}
