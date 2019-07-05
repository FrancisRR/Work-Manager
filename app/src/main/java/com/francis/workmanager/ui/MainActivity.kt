package com.francis.workmanager.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.francis.workmanager.R
import com.francis.workmanager.base.BaseActivity
import com.francis.workmanager.ui.chainwork.ChainWorkActivity
import com.francis.workmanager.ui.periodicwork.PeriodicActivity
import com.francis.workmanager.ui.simplework.SimpleWorkActivity
import com.francis.workmanager.ui.uniquework.UniqueWorkActivity

class MainActivity : BaseActivity() {

    @BindView(R.id.btS)
    lateinit var btS: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        ButterKnife.bind(this)
    }


    @OnClick(R.id.btS, R.id.btC, R.id.btU, R.id.btP, R.id.btCC)
    public fun onClick(v: View) {
        when (v.id) {
            R.id.btS -> startActivity(Intent(this, SimpleWorkActivity::class.java))
            R.id.btC -> startActivity(Intent(this, ChainWorkActivity::class.java))
            R.id.btU -> startActivity(Intent(this, UniqueWorkActivity::class.java))
            R.id.btP -> startActivity(Intent(this, PeriodicActivity::class.java))
        }
    }

}