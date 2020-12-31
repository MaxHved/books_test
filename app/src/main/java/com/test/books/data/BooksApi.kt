package com.test.books.data

import com.test.books.data.model.ResponseBook
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface BooksApi {

    @GET("/search.json")
    fun search(@Query("q") query: String): Single<ResponseBook>

}