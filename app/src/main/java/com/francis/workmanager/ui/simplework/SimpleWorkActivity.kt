package com.francis.workmanager.ui.simplework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.work.Data
import androidx.work.OneTimeWorkRequest
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import butterknife.ButterKnife
import com.francis.workmanager.R
import com.francis.workmanager.base.AppController
import com.francis.workmanager.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class SimpleWorkActivity : BaseActivity() {

    private val TAG by lazy { SimpleWorkActivity::class.java.simpleName }

    @set:Inject
    var workManager: WorkManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)
        AppController.Dagger.inject(this)




        btWork1.setOnClickListener { simpleWork() }

        btWork2.setOnClickListener { simpleWorkWithInput() }
    }


    private fun simpleWork() {
        //Simple work no input params
        //One time work, once finish never call again
        workManager?.enqueue(OneTimeWorkRequest.from(SimpleWork::class.java))
    }

    private fun simpleWorkWithInput() {
        //Simple work with input params
        //One time work, once finish never call again
        val re = OneTimeWorkRequestBuilder<SimpleWorkPassInput>().setInputData(createData()).build()
        workManager?.enqueue(re)
    }


    private fun createData(): Data {
        val data = Data.Builder()
        data.putString("data", "Francis")
        return data.build()
    }
}
