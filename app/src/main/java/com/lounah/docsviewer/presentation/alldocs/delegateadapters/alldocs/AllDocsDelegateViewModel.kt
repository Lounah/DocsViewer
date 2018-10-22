package com.lounah.docsviewer.presentation.alldocs.delegateadapters.alldocs

import com.example.delegateadapter.delegate.diff.IComparableItem
import com.lounah.docsviewer.data.entity.Document

class AllDocsDelegateViewModel(var document: Document,
                               var onClickListener: OnDocumentClickListener) : IComparableItem {

    interface OnDocumentClickListener {
        fun onDocumentClicked(document: Document)
        fun onOptionsClicked(document: Document)
    }

    private companion object {
        private const val ID = "ALL_DOCS_VM"
    }

    override fun id(): Any = ID
    override fun content(): Any = ID
}