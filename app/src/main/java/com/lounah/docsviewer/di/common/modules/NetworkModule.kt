package com.lounah.docsviewer.di.common.modules

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.lounah.docsviewer.data.datasource.remote.DocsApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
class NetworkModule {

    private val BASE_API_URL = "http://95.213.236.54:3000/"

    @Singleton
    @Provides
    fun provideHttpClient() = OkHttpClient.Builder()
            .readTimeout(30, TimeUnit.SECONDS)
            .build()

    @Singleton
    @Provides
    fun provideGson() = GsonBuilder().create()

    @Singleton
    @Provides
    fun provideRetrofit(httpClient: OkHttpClient, gson: Gson) = Retrofit.Builder()
            .baseUrl(BASE_API_URL)
            .client(httpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

    @Singleton
    @Provides
    fun provideApi(retrofit: Retrofit) = retrofit.create(DocsApi::class.java)

}