package com.lounah.docsviewer.data

import com.lounah.docsviewer.data.datasource.local.dao.DocsDao
import com.lounah.docsviewer.data.datasource.remote.DocsApi
import com.lounah.docsviewer.data.datasource.remote.beans.DocumentBean
import com.lounah.docsviewer.data.mapper.DataSourceMapper
import com.lounah.docsviewer.data.repository.DocumentsRepositoryImpl
import com.lounah.docsviewer.domain.repository.DocumentsRepository
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

@RunWith(JUnit4::class)
class DocumentsRepositoryTest {

    @Mock
    private lateinit var docsApi: DocsApi

    @Mock
    private lateinit var docsDao: DocsDao

    private lateinit var docsRepository: DocumentsRepository

    private val stubDocs = listOf(DocumentBean("name", "id", "type", "link"))

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        docsRepository = DocumentsRepositoryImpl(docsDao, docsApi)
    }

    @Test
    fun docs_savedInDbWhenLoaded() {
        `when`(docsApi.getAllDocs()).thenReturn(Single.just(stubDocs))
        `when`(docsDao.getAllDocs()).thenReturn(Single.just(DataSourceMapper.mapDocumentBeanToDocumentEntity(stubDocs)))

        docsRepository.getAllDocuments().test()

        verify(docsApi).getAllDocs()
        verifyNoMoreInteractions(docsApi)
        verify(docsDao).insertAll(DataSourceMapper.mapDocumentBeanToDocumentEntity(stubDocs))
    }

    @Test
    fun doc_getsById() {
        `when`(docsApi.getDocById(stubDocs[0].id!!)).thenReturn(Single.just(stubDocs[0]))

        docsRepository.getDocumentById(stubDocs[0].id!!).test().assertValue(DataSourceMapper.mapDocumentBeanToDocumentEntity(stubDocs[0]))

        verify(docsApi).getDocById(stubDocs[0].id!!)
        verifyNoMoreInteractions(docsApi)
    }

}