package com.lounah.docsviewer.presentation.alldocs.delegateadapters.alldocs

import android.util.Log
import com.example.delegateadapter.delegate.KDelegateAdapter
import com.lounah.docsviewer.R
import kotlinx.android.synthetic.main.item_alldocs_document.*

class AllDocsDelegateAdapter
    : KDelegateAdapter<AllDocsDelegateViewModel>() {

    override fun onBind(item: AllDocsDelegateViewModel, viewHolder: KViewHolder) = with(viewHolder) {
        tv_item_alldocs_document_doctitle.text = "${item.document.name}.${item.document.type}"
        iv_item_alldocs_advanced.setOnClickListener {
            item.onClickListener::onOptionsClicked.invoke(item.document)
        }
        cl_item_document.setOnClickListener {
            item.onClickListener::onDocumentClicked.invoke(item.document)
        }
    }

    override fun isForViewType(items: List<*>, position: Int) = items[position] is AllDocsDelegateViewModel

    override fun getLayoutId(): Int = R.layout.item_alldocs_document
}