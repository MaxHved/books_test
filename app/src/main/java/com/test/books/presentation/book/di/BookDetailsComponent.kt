package com.test.books.presentation.book.di

import com.test.books.presentation.book.BookDetailsFragment
import dagger.Subcomponent

@Subcomponent(
    modules = [
        BookDetailsModule::class,
    ]
)
interface BookDetailsComponent {

    fun inject(fragment: BookDetailsFragment)

}