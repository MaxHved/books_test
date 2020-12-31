package com.test.books.di


import com.test.books.di.viewmodel.ViewModelModule
import com.test.books.presentation.App
import com.test.books.presentation.di.MainComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NavigationModule::class,
        ViewModelModule::class,
        RestModule::class,
    ]
)
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: App): AppComponent
    }

    fun plusMainComponent(): MainComponent
}