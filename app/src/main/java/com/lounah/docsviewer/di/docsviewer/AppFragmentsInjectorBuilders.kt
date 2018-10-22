package com.lounah.docsviewer.di.docsviewer

import com.lounah.docsviewer.presentation.alldocs.AllDocsFragment
import com.lounah.docsviewer.presentation.alldocs.docdetails.DocDetailsDialogFragment
import com.lounah.docsviewer.presentation.favourites.FavouritesFragment
import com.lounah.docsviewer.presentation.sections.SectionsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface AppFragmentsInjectorBuilders {
    @ContributesAndroidInjector
    fun provideAllDocsFragment(): AllDocsFragment

    @ContributesAndroidInjector
    fun provideFavouritesFragment(): FavouritesFragment

    @ContributesAndroidInjector
    fun provideSectionsFragment(): SectionsFragment

    @ContributesAndroidInjector
    fun provideDocDetailsFragment(): DocDetailsDialogFragment
}