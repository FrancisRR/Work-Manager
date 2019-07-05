package com.francis.workmanager.ui.periodicwork

import android.annotation.SuppressLint
import android.content.Context
import androidx.annotation.UiThread
import androidx.work.WorkerParameters
import com.francis.workmanager.base.BaseWorker
import com.francis.workmanager.utils.UiUtils

class PeriodicWork(val context: Context, request: WorkerParameters) : BaseWorker(context, request) {


    private val TAG by lazy { PeriodicWork::class.java.simpleName }


    override fun doWork(): Result {
        UiUtils.errorLog(TAG, TAG)
        return Result.success()
    }

    @UiThread
    private fun toast() {
        UiUtils.showToast(context, TAG)
    }
}