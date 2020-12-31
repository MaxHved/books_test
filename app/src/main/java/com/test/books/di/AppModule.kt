package com.test.books.di

import android.content.Context
import com.test.books.presentation.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideContext(application: App): Context = application.applicationContext!!

}