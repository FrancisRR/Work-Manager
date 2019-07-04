package com.francis.workmanager.dagger

import com.francis.workmanager.ui.chainwork.ChainWorkActivity
import com.francis.workmanager.ui.simplework.SimpleWorkActivity
import com.francis.workmanager.ui.uniquework.UniqueWorkActivity
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun inject(req: SimpleWorkActivity)
    fun inject(req: ChainWorkActivity)
    fun inject(req: UniqueWorkActivity)
}