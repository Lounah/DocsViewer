package com.lounah.docsviewer.di.docsviewer

import com.lounah.docsviewer.data.repository.DocumentsRepositoryImpl
import com.lounah.docsviewer.domain.repository.DocumentsRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class ImplementationBindingModule {

    @Singleton
    @Binds
    abstract fun bindDocumentsRepository(impl: DocumentsRepositoryImpl): DocumentsRepository

}