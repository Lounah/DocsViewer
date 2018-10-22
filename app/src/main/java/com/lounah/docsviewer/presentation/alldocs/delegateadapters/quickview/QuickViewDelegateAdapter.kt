package com.lounah.docsviewer.presentation.alldocs.delegateadapters.quickview

import com.example.delegateadapter.delegate.KDelegateAdapter
import com.lounah.docsviewer.R
import com.lounah.docsviewer.data.entity.Document
import kotlinx.android.synthetic.main.delegate_item_quckview.*

class QuickViewDelegateAdapter
    : KDelegateAdapter<QuickViewViewModel>() {

    override fun onBind(item: QuickViewViewModel, viewHolder: KViewHolder) = with(viewHolder) {
        val adapter = QuckViewDocsRvAdapter(object : QuckViewDocsRvAdapter.DocumentAdapterClickCallback {
            override fun onDocumentClicked(item: Document) {

            }
        })
        rv_alldocs_quckview.adapter = adapter
        adapter.updateDataSet(item.docs)
    }

    override fun isForViewType(items: List<*>, position: Int) = items[position] is QuickViewViewModel

    override fun getLayoutId(): Int = R.layout.delegate_item_quckview
}
