package com.test.books.presentation.di

import com.test.books.presentation.MainActivity
import com.test.books.presentation.book.di.BookDetailsComponent
import com.test.books.presentation.books.di.BooksComponent
import dagger.Subcomponent

@Subcomponent(
    modules = [
        MainModule::class
    ]
)
interface MainComponent {

    fun inject(activity: MainActivity)

    fun plusBooksComponent(): BooksComponent

    fun plusBookDetailComponent(): BookDetailsComponent
}