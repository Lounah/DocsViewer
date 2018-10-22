package com.lounah.docsviewer.presentation.main

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.lounah.docsviewer.R
import com.lounah.docsviewer.presentation.alldocs.AllDocsFragment
import com.lounah.docsviewer.presentation.common.BaseActivity
import com.lounah.docsviewer.presentation.favourites.FavouritesFragment
import com.lounah.docsviewer.presentation.sections.SectionsFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initUI()
    }

    private fun initUI() {
        setContentView(R.layout.activity_main)
        initViewPager()
        initTabLayout()
    }

    private fun initViewPager() {
        viewpager_main.offscreenPageLimit = 3
        viewpager_main.adapter = MainViewPagerAdapter(supportFragmentManager)
    }

    private fun initTabLayout() {
        tablayout_main.setupWithViewPager(viewpager_main)
    }

    inner class MainViewPagerAdapter(fragmentManager: FragmentManager)
        : FragmentPagerAdapter(fragmentManager) {

        private val NUM_ITEMS = 3

        override fun getCount() = NUM_ITEMS

        override fun getItem(position: Int): Fragment? =
                when (position) {
                    0 -> AllDocsFragment()
                    1 -> SectionsFragment()
                    2 -> FavouritesFragment()
                    else -> AllDocsFragment()
                }

        override fun getPageTitle(position: Int): CharSequence? = when (position) {
            0 -> resources.getString(R.string.all)
            1 -> resources.getString(R.string.sections)
            2 -> resources.getString(R.string.favourites)
            else -> ""
        }
    }
}
