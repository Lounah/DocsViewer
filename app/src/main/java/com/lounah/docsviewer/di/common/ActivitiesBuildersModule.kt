package com.lounah.docsviewer.di.common

import com.lounah.docsviewer.di.docsviewer.AppFragmentsInjectorBuilders
import com.lounah.docsviewer.presentation.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivitiesBuildersModule {
    @ContributesAndroidInjector(modules = [
        AppFragmentsInjectorBuilders::class]
    )
    fun provideMainActivity(): MainActivity
}