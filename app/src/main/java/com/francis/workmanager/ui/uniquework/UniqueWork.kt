package com.francis.workmanager.ui.uniquework

import android.content.Context
import android.util.Log
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import com.francis.workmanager.base.BaseWorker

class UniqueWork(context: Context, request: WorkerParameters) : BaseWorker(context, request) {

    private val TAG by lazy { UniqueWork::class.java.simpleName }
    override fun doWork(): Result {

        Log.e(TAG,"unique work triggered")
        for (i in 1..20) {
            Thread.sleep(1000)
            Log.e(TAG, "" + i)
        }

        return Result.success()
    }
}