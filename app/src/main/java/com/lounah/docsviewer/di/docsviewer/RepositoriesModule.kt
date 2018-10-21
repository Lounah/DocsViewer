package com.lounah.docsviewer.di.docsviewer

import android.app.Application
import android.arch.persistence.room.Room
import com.lounah.docsviewer.data.DocsApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoriesModule {

//
//    @Singleton
//    @Provides
//    fun provideDatabase(context: Application) =
//            Room.databaseBuilder(context, AppDatabase::class.java, BuildConfig.DB_NAME).fallbackToDestructiveMigration().build()
//
//    @Singleton
//    @Provides
//    fun provideOfferDao(db: AppDatabase) = db.offerDao()
//
//    @Singleton
//    @Provides
//    fun provideDislikedOfferDao(db: AppDatabase) = db.dislikedOfferDao()
//
//    @Singleton
//    @Provides
//    fun provideCallHistoryDao(db: AppDatabase) = db.callsDao()
//
//    @Singleton
//    @Provides
//    fun provideSettingsRepository(
//            settingsPreferences: SettingsPreferences,
//            networkSource: NetworkSource,
//            networkInfo: NetworkInfo) = SettingsRepositoryImpl(settingsPreferences, networkSource, networkInfo)
}