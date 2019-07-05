package com.francis.workmanager.ui.uniquework

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkInfo
import androidx.work.WorkManager
import butterknife.ButterKnife
import butterknife.OnClick
import com.francis.workmanager.R
import com.francis.workmanager.base.AppController
import com.francis.workmanager.base.BaseActivity
import javax.inject.Inject

class UniqueWorkActivity : BaseActivity() {

    private val TAG by lazy { UniqueWorkActivity::class.java.simpleName }

    @set:Inject
    var workManager: WorkManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chain)
        ButterKnife.bind(this)
        AppController.Dagger.inject(this)

        supportActionBar?.setTitle("Unique work")
    }


    @OnClick(R.id.btUniqueWork, R.id.btWorkData)
    public fun onClick(v: View) {
        when (v.id) {
            R.id.btUniqueWork -> uniqueWork()
            R.id.btWorkData -> getstatus()
        }
    }

    private fun uniqueWork() {
        //workManager?.enqueue(OneTimeWorkRequest.from(UniqueWork::class.java))

        /*
        * Please enable above line
        * and continuous click button it create one job for multi time
        * that issue solved by below function one operation is process keep the same operation
        * */

        val work = OneTimeWorkRequestBuilder<UniqueWork>().addTag(TAG).build()
        workManager?.enqueueUniqueWork(TAG, ExistingWorkPolicy.KEEP, work)
    }

    private fun getstatus() {
        val info: LiveData<List<WorkInfo>>? = workManager?.getWorkInfosByTagLiveData(TAG)
        info?.observe(this, Observer { res ->
            if (res.isNullOrEmpty()) {
                return@Observer
            }
            val workInfo = res.get(0)

            Log.e(TAG, "" + workInfo.id)
            Log.e(TAG, "" + workInfo.state.isFinished)
            info.removeObservers(this)

        })
    }


}