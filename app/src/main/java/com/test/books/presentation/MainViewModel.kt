package com.test.books.presentation

import com.github.terrakok.cicerone.Router
import com.test.books.di.Injector
import com.test.books.navigation.Screens
import com.test.books.presentation.base.BaseViewModel
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val router: Router
): BaseViewModel() {

    init {
        router.newRootScreen(Screens.BooksList())
    }

    override fun onCleared() {
        Injector.clearMainComponent()
    }
}