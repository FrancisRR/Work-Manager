package com.francis.workmanager.dagger

import com.francis.workmanager.ui.chainwork.ChainWorkActivity
import com.francis.workmanager.ui.periodicwork.PeriodicActivity
import com.francis.workmanager.ui.simplework.SimpleWorkActivity
import com.francis.workmanager.ui.uniquework.UniqueWorkActivity
import com.francis.workmanager.utils.UiUtils
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun inject(req: SimpleWorkActivity)
    fun inject(req: ChainWorkActivity)
    fun inject(req: UniqueWorkActivity)
    fun inject(req: PeriodicActivity)
}