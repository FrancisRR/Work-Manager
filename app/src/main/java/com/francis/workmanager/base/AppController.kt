package com.francis.workmanager.base

import android.app.Application
import com.francis.workmanager.dagger.AppComponent
import com.francis.workmanager.dagger.AppModule
import com.francis.workmanager.dagger.DaggerAppComponent

class AppController : Application() {


    override fun onCreate() {
        super.onCreate()
        instance = this
        Dagger = DaggerAppComponent.builder().appModule(AppModule(this)).build()

    }


    companion object {
        internal lateinit var instance: AppController
        internal lateinit var Dagger: AppComponent
    }
}