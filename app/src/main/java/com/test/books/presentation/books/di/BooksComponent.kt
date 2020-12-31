package com.test.books.presentation.books.di

import com.test.books.presentation.books.BooksFragment
import dagger.Subcomponent

@Subcomponent(
    modules = [
        BooksModule::class,
    ]
)
interface BooksComponent {

    fun inject(fragment: BooksFragment)

}