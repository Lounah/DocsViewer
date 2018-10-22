package com.lounah.docsviewer.presentation.alldocs.docdetails

import android.arch.lifecycle.MutableLiveData
import com.lounah.docsviewer.data.entity.Document
import com.lounah.docsviewer.domain.DocumentsInteractor
import com.lounah.docsviewer.presentation.common.BaseViewModel
import com.lounah.docsviewer.util.SchedulersProvider
import javax.inject.Inject

class DocDetailsViewModel @Inject constructor(private val docsInteractor: DocumentsInteractor,
                                              private val schedulersProvider: SchedulersProvider) : BaseViewModel() {

    internal val doc = MutableLiveData<Document>()

    fun fetchDocumentById(id: String) {
        disposables.add(docsInteractor.getDocumentById(id)
                .subscribeOn(schedulersProvider.io())
                .observeOn(schedulersProvider.ui())
                .subscribe({ result ->
                    doc.postValue(result)
                }, { e -> }))
    }
}