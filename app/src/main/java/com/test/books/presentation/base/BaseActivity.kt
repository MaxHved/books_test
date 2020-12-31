package com.test.books.presentation.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

abstract class BaseActivity<VM: BaseViewModel>: AppCompatActivity() {

    protected lateinit var viewModel: VM
    @Inject
    protected lateinit var viewModelFactory: ViewModelProvider.Factory

    protected abstract fun injectActivity()

    protected abstract fun injectViewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        injectActivity()
        super.onCreate(savedInstanceState)
        injectViewModel()
    }

    protected inline fun <reified T : ViewModel> getViewModel(): T {
        return ViewModelProvider(this, viewModelFactory)[T::class.java]
    }
}