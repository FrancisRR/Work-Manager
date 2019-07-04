package com.francis.workmanager.ui.simplework

import android.content.Context
import android.util.Log
import androidx.work.WorkerParameters
import com.francis.workmanager.base.BaseWorker

class SimpleWork(val context: Context, params: WorkerParameters) : BaseWorker(context, params) {

    private val TAG by lazy { SimpleWork::class.java.simpleName }

    override fun doWork(): Result {
        Log.e(TAG, "Simple work executed")
        return super.doWork()
    }
}