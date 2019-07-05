package com.francis.workmanager.utils

import android.content.Context
import android.util.Log
import android.widget.Toast

object UiUtils {


    fun showToast(context: Context, msg: String) {
        Toast.makeText(context, "" + msg, Toast.LENGTH_SHORT).show()
    }

    fun log(TAG: String, msg: String) {
        Log.v(TAG, msg)
    }

    fun errorLog(TAG: String, msg: String) {
        Log.e(TAG, msg)
    }

}