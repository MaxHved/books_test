package com.test.books.presentation.book

import com.github.terrakok.cicerone.Router
import com.test.books.data.RestClient
import com.test.books.di.Injector
import com.test.books.navigation.Screens
import com.test.books.presentation.base.BaseViewModel
import javax.inject.Inject

class BookDetailsViewModel @Inject constructor(
    private val router: Router,
    private val restClient: RestClient
): BaseViewModel() {

    fun back() {
        router.backTo(Screens.BooksList())
    }

    override fun onCleared() {
        Injector.clearBookDetailsComponent()
    }
}