package com.francis.workmanager.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import butterknife.ButterKnife
import butterknife.OnClick
import com.francis.workmanager.R
import com.francis.workmanager.base.BaseActivity
import com.francis.workmanager.ui.chainwork.ChainWorkActivity
import com.francis.workmanager.ui.simplework.SimpleWorkActivity
import com.francis.workmanager.ui.uniquework.UniqueWorkActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        ButterKnife.bind(this)
    }


    @OnClick(R.id.btS, R.id.btC, R.id.btU)
    public fun onClick(v: View) {
        when (v.id) {
            R.id.btS -> startActivity(Intent(this, SimpleWorkActivity::class.java))
            R.id.btC -> startActivity(Intent(this, ChainWorkActivity::class.java))
            R.id.btU -> startActivity(Intent(this, UniqueWorkActivity::class.java))
        }
    }

}