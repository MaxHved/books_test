package com.test.books.data

import com.test.books.data.model.ResponseBook
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import javax.inject.Inject

class RestClient @Inject constructor(
    retrofit: Retrofit
) {

    private val booksApi: BooksApi = retrofit.create(BooksApi::class.java)


    fun search(query: String): Single<ResponseBook> {
        return booksApi.search(query)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }


}