package com.lounah.docsviewer.data.datasource.remote

import com.lounah.docsviewer.data.datasource.remote.beans.DocumentBean
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface DocsApi {
    @GET("api/v1/documents/all")
    fun getAllDocs(): Single<List<DocumentBean>>

    @GET("api/v1/documents/get/{id}")
    fun getDocById(@Path(value = "id", encoded = true) id: String): Single<DocumentBean>

    // Что-то непонятное здесь возвращается
    // Не знаю, стоит ли вообще это имплементить
    @GET("api/v1/documents/fav")
    fun getFavouriteDocs(): Single<List<DocumentBean>>
}