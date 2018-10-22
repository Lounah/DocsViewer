package com.lounah.docsviewer.data.mapper

import com.lounah.docsviewer.data.datasource.remote.beans.DocumentBean
import com.lounah.docsviewer.data.entity.Document

object DataSourceMapper {

    fun mapDocumentBeanToDocumentEntity(bean: DocumentBean) = Document(
            id = bean.id ?: "",
            name = bean.name ?: "",
            type = bean.type ?: "",
            link = bean.link ?: "")

    fun mapDocumentBeanToDocumentEntity(beans: List<DocumentBean>): List<Document> {
        return beans.map { mapDocumentBeanToDocumentEntity(it) }
    }
}