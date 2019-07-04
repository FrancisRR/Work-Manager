package com.francis.workmanager.base

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

open class BaseWorker(context: Context, param: WorkerParameters) : Worker(context, param) {
    override fun doWork(): Result {
        return Result.success()
    }

}