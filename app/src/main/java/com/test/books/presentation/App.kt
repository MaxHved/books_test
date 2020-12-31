package com.test.books.presentation

import android.app.Application
import com.test.books.di.Injector

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        Injector.init(this)
    }
}