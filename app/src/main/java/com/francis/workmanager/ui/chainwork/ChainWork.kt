package com.francis.workmanager.ui.chainwork

import android.content.Context
import android.util.Log
import androidx.work.WorkerParameters
import com.francis.workmanager.base.BaseWorker

class ChainWork(val context: Context, val params: WorkerParameters) : BaseWorker(context, params) {

    private val TAG by lazy { ChainWork::class.java.simpleName }
    override fun doWork(): Result {
        Log.e(TAG, "Chain work completed")
        return super.doWork()
    }
}