package com.lounah.docsviewer.presentation.alldocs.delegateadapters.quickview

import com.example.delegateadapter.delegate.diff.IComparableItem
import com.lounah.docsviewer.data.entity.Document

class QuickViewViewModel(var docs: List<Document>) : IComparableItem {

    private companion object {
        private const val ID = "QUCK_VIEW_VM"
    }

    override fun id(): Any = ID
    override fun content(): Any = ID
}
