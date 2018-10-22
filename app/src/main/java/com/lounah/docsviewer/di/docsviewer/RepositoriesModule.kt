package com.lounah.docsviewer.di.docsviewer

import android.app.Application
import android.arch.persistence.room.Room
import com.lounah.docsviewer.BuildConfig
import com.lounah.docsviewer.data.datasource.local.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoriesModule {


    @Singleton
    @Provides
    fun provideDatabase(context: Application) =
            Room.databaseBuilder(context, AppDatabase::class.java, BuildConfig.DB_NAME).fallbackToDestructiveMigration().build()

    @Singleton
    @Provides
    fun provideDocsDao(db: AppDatabase) = db.docsDao()
}