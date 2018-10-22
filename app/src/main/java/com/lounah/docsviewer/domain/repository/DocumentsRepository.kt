package com.lounah.docsviewer.domain.repository

import com.lounah.docsviewer.data.entity.Document
import io.reactivex.Flowable
import io.reactivex.Single

interface DocumentsRepository {
    fun getAllDocuments(): Flowable<List<Document>>

    fun getDocumentById(id: String): Single<Document>
}