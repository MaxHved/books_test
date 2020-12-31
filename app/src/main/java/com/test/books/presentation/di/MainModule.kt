package com.test.books.presentation.di

import androidx.lifecycle.ViewModel
import com.test.books.di.viewmodel.ViewModelKey
import com.test.books.presentation.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class MainModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    internal abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel
}