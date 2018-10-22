package com.lounah.docsviewer.data.datasource.local.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.lounah.docsviewer.data.entity.Document
import io.reactivex.Flowable
import io.reactivex.Single

@Dao
interface DocsDao : BaseDao<Document> {

    @Query("SELECT * FROM documents")
    fun getAllDocs(): Flowable<List<Document>>

    @Query("SELECT * FROM documents WHERE id=:docId")
    fun getDocById(docId: String): Document
}