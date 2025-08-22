package com.example.quranapp.utils

import android.app.Activity
import android.content.Intent

object AppRestartHelper {
    fun restartApp(activity: Activity) {
        val intent = Intent(activity, activity::class.java)
        activity.finish()
        activity.startActivity(intent)
        Runtime.getRuntime().exit(0)
    }
}