package com.lounah.docsviewer.presentation.alldocs.docdetails

import android.arch.lifecycle.Observer
import android.content.Context
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lounah.docsviewer.R
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.dialog_document_details.*
import javax.inject.Inject
import android.content.Intent
import android.net.Uri
import com.lounah.docsviewer.data.entity.Document


class DocDetailsDialogFragment : DialogFragment() {

    companion object {
        private const val key_document_id = "KEY_DOCUMENT_ID"
        fun newInstance(documentId: String): DocDetailsDialogFragment {
            return DocDetailsDialogFragment().apply {
                arguments = Bundle().apply {
                    putString(key_document_id, documentId)
                }
            }
        }
    }

    @Inject
    lateinit var viewModel: DocDetailsViewModel

    private lateinit var docId: String

    private lateinit var currentDoc: Document

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.dialog_document_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        docId = arguments!![key_document_id] as String
        initUI()
        initViewModelObservers()
        viewModel.fetchDocumentById(docId)
    }

    override fun onStart() {
        super.onStart()
        val dialog = dialog
        if (dialog != null) {
            val width = ViewGroup.LayoutParams.MATCH_PARENT
            val height = ViewGroup.LayoutParams.MATCH_PARENT
            dialog.window.setLayout(width, height)
        }
    }

    private fun initViewModelObservers() {
        viewModel.doc.observe(this, Observer {
            it?.let {
                tv_docdetails_title.text = "${it.name}.${it.type}"
                tv_docdetails_file_type.text = it.type
                currentDoc = it
            }
        })
    }

    private fun initUI() {
        button_docdetails_ok.setOnClickListener { dismiss() }
        button_docdetails_open_with.setOnClickListener {
            if (::currentDoc.isInitialized) {
                openFile(currentDoc.link)
            }
        }
    }

    private fun openFile(link: String) {

        val browserIntent = Intent(Intent.ACTION_VIEW).apply {
            addCategory(Intent.CATEGORY_BROWSABLE)
            type = "application/pdf"
            data = Uri.parse(link)
        }
        val chooserIntent = Intent.createChooser(browserIntent, context!!.resources.getString(R.string.open_with)).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK
        }
        chooserIntent.resolveActivity(context?.packageManager)?.let {
            startActivity(chooserIntent)
        }
    }
}