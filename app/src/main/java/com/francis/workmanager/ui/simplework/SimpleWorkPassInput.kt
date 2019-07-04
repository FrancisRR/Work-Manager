package com.francis.workmanager.ui.simplework

import android.content.Context
import android.util.Log
import androidx.work.WorkerParameters
import com.francis.workmanager.base.BaseWorker

class SimpleWorkPassInput(val context: Context, val params: WorkerParameters) : BaseWorker(context, params) {

    private val TAG by lazy { SimpleWorkPassInput::class.java.simpleName }

    override fun doWork(): Result {
        val inputParam = inputData.getString("data")
        Log.e(TAG, ""+inputParam)
        return super.doWork()
    }
}