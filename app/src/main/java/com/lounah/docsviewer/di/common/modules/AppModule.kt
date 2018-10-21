package com.lounah.docsviewer.di.common.modules

import com.lounah.docsviewer.util.AppSchedulersProvider
import com.lounah.docsviewer.util.SchedulersProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class AppModule {
    @Provides
    @Singleton
    fun provideAppScheduler(): SchedulersProvider = AppSchedulersProvider()
}