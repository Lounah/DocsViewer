package com.lounah.docsviewer.domain

import com.lounah.docsviewer.data.entity.Document
import com.lounah.docsviewer.domain.repository.DocumentsRepository
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class DocumentsInteractor @Inject constructor(private val repository: DocumentsRepository) {

    fun getAllDocuments(): Observable<List<Document>> = repository.getAllDocuments()

    fun getDocumentById(id: String): Single<Document> = repository.getDocumentById(id)

}