package com.lounah.docsviewer.data.repository

import com.lounah.docsviewer.data.datasource.local.dao.DocsDao
import com.lounah.docsviewer.data.datasource.remote.DocsApi
import com.lounah.docsviewer.data.entity.Document
import com.lounah.docsviewer.data.mapper.DataSourceMapper.mapDocumentBeanToDocumentEntity
import com.lounah.docsviewer.domain.repository.DocumentsRepository
import io.reactivex.Flowable
import io.reactivex.Single
import javax.inject.Inject

class DocumentsRepositoryImpl @Inject constructor(private val docsDao: DocsDao,
                                                  private val api: DocsApi) : DocumentsRepository {

    override fun getAllDocuments(): Flowable<List<Document>> {
        return Single.merge(getAllDocsFromDb(), getAllDocsFromApi())
    }

    override fun getDocumentById(id: String): Single<Document> {
        return api.getDocById(id).map { mapDocumentBeanToDocumentEntity(it)  }
    }

    private fun getAllDocsFromDb(): Single<List<Document>> = docsDao.getAllDocs()

    private fun getAllDocsFromApi(): Single<List<Document>> = api.getAllDocs()
            .map { mapDocumentBeanToDocumentEntity(it) }
            .doOnSuccess { docsDao.insertAll(it) }
}