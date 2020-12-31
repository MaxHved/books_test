package com.test.books.di

import com.test.books.presentation.App
import com.test.books.presentation.book.di.BookDetailsComponent
import com.test.books.presentation.books.di.BooksComponent
import com.test.books.presentation.di.MainComponent

object Injector {

    private lateinit var appComponent: AppComponent
    private var mainComponent: MainComponent? = null
    private var booksComponent: BooksComponent? = null
    private var bookDetailComponent: BookDetailsComponent? = null

    fun init(app: App): AppComponent {
        appComponent = DaggerAppComponent.factory().create(app)
        return appComponent
    }

    fun mainComponent(): MainComponent {
        if (mainComponent == null) {
            mainComponent = appComponent.plusMainComponent()
        }
        return mainComponent!!
    }

    fun clearMainComponent() {
        mainComponent = null
    }

    fun bookComponent(): BooksComponent {
        if (booksComponent == null) {
            booksComponent = mainComponent().plusBooksComponent()
        }
        return booksComponent!!
    }

    fun clearBooksComponent() {
        booksComponent = null
    }

    fun bookDetailsComponent(): BookDetailsComponent {
        if (bookDetailComponent == null) {
            bookDetailComponent = mainComponent().plusBookDetailComponent()
        }
        return bookDetailComponent!!
    }

    fun clearBookDetailsComponent() {
        bookDetailComponent = null
    }
}