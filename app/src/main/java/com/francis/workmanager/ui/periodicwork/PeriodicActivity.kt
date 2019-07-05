package com.francis.workmanager.ui.periodicwork

import android.os.Bundle
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequest
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.francis.workmanager.R
import com.francis.workmanager.base.AppController
import com.francis.workmanager.base.BaseActivity
import kotlinx.android.synthetic.main.activity_periodic.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class PeriodicActivity : BaseActivity() {

    private val TAG by lazy { PeriodicActivity::class.java.simpleName }
    @set:Inject
    var workManager: WorkManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_periodic)
        AppController.Dagger.inject(this)

        supportActionBar?.setTitle("Periodic work")

        btPeriodic.setOnClickListener { periodicWork() }
    }

    private fun periodicWork() {
        val work = PeriodicWorkRequestBuilder<PeriodicWork>(
            PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS,
            TimeUnit.MILLISECONDS
        ).build()
        workManager?.enqueueUniquePeriodicWork(TAG, ExistingPeriodicWorkPolicy.REPLACE, work)
    }
}