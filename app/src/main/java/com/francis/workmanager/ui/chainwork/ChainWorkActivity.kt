package com.francis.workmanager.ui.chainwork

import android.os.Bundle
import androidx.work.Data
import androidx.work.OneTimeWorkRequest
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import butterknife.ButterKnife
import com.francis.workmanager.R
import com.francis.workmanager.base.AppController
import com.francis.workmanager.base.BaseActivity
import com.francis.workmanager.ui.simplework.SimpleWork
import com.francis.workmanager.ui.simplework.SimpleWorkPassInput
import kotlinx.android.synthetic.main.activity_chain_work.*
import javax.inject.Inject

class ChainWorkActivity : BaseActivity() {

    private val TAG by lazy { ChainWorkActivity::class.java.simpleName }

    @set:Inject
    var workManager: WorkManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chain_work)
        ButterKnife.bind(this)
        AppController.Dagger.inject(this)

        btChain.setOnClickListener { chainWork() }
    }


    /*
    * This method trigger for three job.
    * Three job only run in sequenc, One completed after that only next job will trigger
    * */
    private fun chainWork() {


        val work1 = OneTimeWorkRequest.from(SimpleWork::class.java)
        val work2 = OneTimeWorkRequestBuilder<SimpleWorkPassInput>().setInputData(createInputData()).build()
        val work3 = OneTimeWorkRequest.from(ChainWork::class.java)

        workManager?.beginWith(work1)?.then(work2)?.then(work3)?.enqueue()

    }


    private fun createInputData(): Data {
        val builder = Data.Builder()
        builder.putString("data", "Hai")
        return builder.build()
    }
}