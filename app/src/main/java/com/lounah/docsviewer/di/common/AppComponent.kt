package com.lounah.docsviewer.di.common

import android.app.Application
import android.content.Context
import com.lounah.docsviewer.app.DocsViewerApplication
import com.lounah.docsviewer.di.common.modules.AppModule
import com.lounah.docsviewer.di.common.modules.NetworkModule
import com.lounah.docsviewer.di.docsviewer.ImplementationBindingModule
import com.lounah.docsviewer.di.docsviewer.RepositoriesModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    ActivitiesBuildersModule::class,
    AppModule::class,
    NetworkModule::class,
    RepositoriesModule::class,
    ImplementationBindingModule::class
])
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        @BindsInstance
        fun appContext(@ApplicationContext context: Context): Builder

        fun build(): AppComponent
    }

    fun inject(app: DocsViewerApplication)
}