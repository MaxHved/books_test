package com.test.books.presentation.books

import com.github.terrakok.cicerone.Router
import com.test.books.data.RestClient
import com.test.books.data.model.Book
import com.test.books.di.Injector
import com.test.books.navigation.Screens
import com.test.books.presentation.base.BaseViewModel
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.BehaviorSubject
import javax.inject.Inject

class BooksViewModel @Inject constructor(
    private val router: Router,
    private val restClient: RestClient
) : BaseViewModel() {

    val books: BehaviorSubject<List<Book>> = BehaviorSubject.create()
    val error: BehaviorSubject<Throwable> = BehaviorSubject.create()

    private var disposable: Disposable? = null


    fun search(query: String) {
        disposable?.dispose()
        if (query.isNotBlank()) {
            disposable = restClient.search(query)
                .subscribe(
                    { response ->
                        books.onNext(response.docs)
                    },
                    { throwable ->

                        error.onNext(throwable)
                    }
                )
        }
    }

    fun showBookDetails(book: Book) {
        router.navigateTo(Screens.BookDetail(book))
    }

    override fun onCleared() {
        disposable?.dispose()
        Injector.clearBooksComponent()
    }
}