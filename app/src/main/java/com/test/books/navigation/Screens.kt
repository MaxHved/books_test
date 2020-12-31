package com.test.books.navigation

import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.test.books.data.model.Book
import com.test.books.presentation.book.BookDetailsFragment
import com.test.books.presentation.books.BooksFragment

object Screens {

    fun BooksList() = FragmentScreen(key = BooksFragment::class.simpleName) {
        BooksFragment()
    }

    fun BookDetail(book: Book) = FragmentScreen(key = BookDetailsFragment::class.simpleName) {
        BookDetailsFragment.newInstance(book)
    }
}