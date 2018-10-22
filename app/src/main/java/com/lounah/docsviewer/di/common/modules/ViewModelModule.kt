package com.lounah.docsviewer.di.common.modules

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.lounah.docsviewer.di.common.ViewModelKey
import com.lounah.docsviewer.presentation.alldocs.AllDocsViewModel
import com.lounah.docsviewer.presentation.alldocs.docdetails.DocDetailsViewModel
import com.lounah.docsviewer.presentation.common.AppViewModelFactory
import com.lounah.docsviewer.presentation.favourites.FavouritesViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(AllDocsViewModel::class)
    abstract fun bindAllDocsViewModel(viewModel: AllDocsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DocDetailsViewModel::class)
    abstract fun bindDocDetailsViewModel(viewModel: DocDetailsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FavouritesViewModel::class)
    abstract fun bindFavouritesViewModel(viewModel: FavouritesViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: AppViewModelFactory): ViewModelProvider.Factory
}