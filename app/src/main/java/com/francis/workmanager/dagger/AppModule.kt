package com.francis.workmanager.dagger

import androidx.work.WorkManager
import com.francis.workmanager.base.AppController
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule(private var appController: AppController) {


    @Provides
    @Singleton
    public fun getInstance(): AppController {
        return appController
    }


    @Provides
    @Singleton
    public fun getWorkManager(): WorkManager {
        return WorkManager.getInstance()
    }

}