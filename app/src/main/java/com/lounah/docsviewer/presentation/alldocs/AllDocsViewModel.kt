package com.lounah.docsviewer.presentation.alldocs

import android.arch.lifecycle.MutableLiveData
import com.lounah.docsviewer.data.entity.Document
import com.lounah.docsviewer.domain.DocumentsInteractor
import com.lounah.docsviewer.presentation.common.BaseViewModel
import com.lounah.docsviewer.util.SchedulersProvider
import javax.inject.Inject

class AllDocsViewModel @Inject constructor(private val docsInteractor: DocumentsInteractor,
                                           private val schedulersProvider: SchedulersProvider) : BaseViewModel() {

    internal val loadingState = MutableLiveData<Boolean>()
    internal val docs = MutableLiveData<List<Document>>()
    internal val doc = MutableLiveData<Document>()

    internal fun getAllDocs() {
        disposables.add(docsInteractor.getAllDocuments()
                .doOnSubscribe { loadingState.postValue(true) }
                .subscribeOn(schedulersProvider.io())
                .observeOn(schedulersProvider.ui())
                .subscribe({ result ->
                    docs.postValue(result)
                    loadingState.postValue(false)
                }, { e -> }))
    }

    internal fun fetchDocumentById(id: String) {
        disposables.add(docsInteractor.getDocumentById(id)
                .subscribeOn(schedulersProvider.io())
                .observeOn(schedulersProvider.ui())
                .subscribe({ result ->
                    doc.postValue(result)
                }, { e -> }))
    }

}