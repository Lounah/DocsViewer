package com.lounah.docsviewer.presentation.alldocs.delegateadapters.quickview

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import com.lounah.docsviewer.R
import com.lounah.docsviewer.data.entity.Document
import kotlinx.android.synthetic.main.item_alldocs_quckview.view.*

class QuckViewDocsRvAdapter(private val itemClickCallback: DocumentAdapterClickCallback)
    : RecyclerView.Adapter<QuckViewDocsRvAdapter.ViewHolder>() {

    interface DocumentAdapterClickCallback {
        fun onDocumentClicked(item: Document)
    }

    private val docs = mutableListOf<Document>()

    private var lastPosition = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_alldocs_quckview, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val doc = docs[position]

        holder.itemView.setOnClickListener {
            itemClickCallback.onDocumentClicked(doc)
        }

        holder.bind(doc)
    }

    override fun getItemCount() = docs.size

    internal fun updateDataSet(docs: List<Document>) {
        this.docs.clear()
        this.docs.addAll(docs)
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(doc: Document) {

            itemView.tv_item_alldocs_doctitle.text = "${doc.name}.${doc.type}"

            setAnimation(itemView, adapterPosition)
        }
    }

    private fun setAnimation(viewToAnimate: View, position: Int) {
        if (position > lastPosition) {
            val animation = AnimationUtils.loadAnimation(viewToAnimate.context, android.R.anim.fade_in)
            viewToAnimate.startAnimation(animation)
            lastPosition = position
        }
    }
}