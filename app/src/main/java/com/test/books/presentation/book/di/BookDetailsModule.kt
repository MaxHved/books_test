package com.test.books.presentation.book.di

import androidx.lifecycle.ViewModel
import com.test.books.di.viewmodel.ViewModelKey
import com.test.books.presentation.book.BookDetailsViewModel
import com.test.books.presentation.books.BooksViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class BookDetailsModule {

    @Binds
    @IntoMap
    @ViewModelKey(BookDetailsViewModel::class)
    internal abstract fun bindBookDetailsViewModel(viewModel: BookDetailsViewModel): ViewModel

}