package com.test.books.presentation.books.di

import androidx.lifecycle.ViewModel
import com.test.books.di.viewmodel.ViewModelKey
import com.test.books.presentation.books.BooksViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class BooksModule {

    @Binds
    @IntoMap
    @ViewModelKey(BooksViewModel::class)
    internal abstract fun bindBooksViewModel(viewModel: BooksViewModel): ViewModel

}