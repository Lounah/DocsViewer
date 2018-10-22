package com.lounah.docsviewer.presentation.alldocs

import android.arch.lifecycle.Observer
import android.content.Intent
import android.net.Uri
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.example.delegateadapter.delegate.diff.DiffUtilCompositeAdapter
import com.example.delegateadapter.delegate.diff.IComparableItem
import com.lounah.docsviewer.R
import com.lounah.docsviewer.data.entity.Document
import com.lounah.docsviewer.presentation.alldocs.delegateadapters.alldocs.AllDocsDelegateAdapter
import com.lounah.docsviewer.presentation.alldocs.delegateadapters.alldocs.AllDocsDelegateViewModel
import com.lounah.docsviewer.presentation.alldocs.delegateadapters.quickview.QuickViewDelegateAdapter
import com.lounah.docsviewer.presentation.alldocs.delegateadapters.quickview.QuickViewViewModel
import com.lounah.docsviewer.presentation.alldocs.docdetails.DocDetailsDialogFragment
import com.lounah.docsviewer.presentation.common.BaseFragment
import kotlinx.android.synthetic.main.fragment_all_docs.*
import javax.inject.Inject

class AllDocsFragment : BaseFragment() {

    override val TAG = "all_docs_fragment"
    override val layoutRes = R.layout.fragment_all_docs

    @Inject
    lateinit var viewModel: AllDocsViewModel

    private var allDocsDelegateAdapter = AllDocsDelegateAdapter()
    private var quickViewDelegateAdapter = QuickViewDelegateAdapter()

    private lateinit var contentRecyclerViewAdapter: DiffUtilCompositeAdapter


    override fun initUI() {
        initContentRvAdapter()
        initViewModelObservers()
        viewModel.getAllDocs()
    }

    private fun initContentRvAdapter() {
        rv_alldocs.layoutManager = LinearLayoutManager(context)
        contentRecyclerViewAdapter = DiffUtilCompositeAdapter.Builder()
                .add(quickViewDelegateAdapter)
                .add(allDocsDelegateAdapter)
                .build()
        rv_alldocs.adapter = contentRecyclerViewAdapter
    }


    private fun initViewModelObservers() {
        viewModel.docs.observe(this, Observer { docs ->
            docs?.let {
                contentRecyclerViewAdapter.swapData(buildViewModelsList(it))
            }
        })

        viewModel.doc.observe(this, Observer {
            it?.let {
                openPdfInBrowser(it.link)
            }
        })

        viewModel.loadingState.observe(this, Observer {
            it?.let {
                if (it) showLoading() else hideLoading()
            }
        })
    }

    private fun buildViewModelsList(docs: List<Document>): List<IComparableItem> {
        val result = mutableListOf<IComparableItem>()
        result += QuickViewViewModel(docs)
        docs.forEach {
            result += AllDocsDelegateViewModel(it, object : AllDocsDelegateViewModel.OnDocumentClickListener {
                override fun onDocumentClicked(document: Document) {
                    viewModel.fetchDocumentById(document.id)
                }

                override fun onOptionsClicked(document: Document) {
                    DocDetailsDialogFragment.newInstance(document.id)
                            .show(childFragmentManager, DocDetailsDialogFragment.javaClass.simpleName)
                }

            })
        }
        return result
    }

    private fun showLoading() {
        view_alldocs_loading.visibility = View.VISIBLE
    }

    private fun hideLoading() {
        view_alldocs_loading.visibility = View.GONE
    }

    private fun openPdfInBrowser(link: String) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
        startActivity(browserIntent)
    }
}