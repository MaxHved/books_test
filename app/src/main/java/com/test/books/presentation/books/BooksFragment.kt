package com.test.books.presentation.books

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.books.R
import com.test.books.data.model.Book
import com.test.books.databinding.FragmentBooksBinding
import com.test.books.di.Injector
import com.test.books.presentation.base.BaseFragment
import com.test.books.presentation.books.adapter.BooksAdapter
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

class BooksFragment : BaseFragment<BooksViewModel>() {

    private val compositeDisposable = CompositeDisposable()

    private lateinit var binding: FragmentBooksBinding
    private lateinit var adapter: BooksAdapter

    override fun inject() = Injector.bookComponent().inject(this)

    override fun injectViewModel() {
        viewModel = getViewModel()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = BooksAdapter(onActionItemListener)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBooksBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.toolbar.inflateMenu(R.menu.search)

        binding.booksList.adapter = adapter
        binding.booksList.layoutManager = LinearLayoutManager(requireContext())

        val searchView = binding.toolbar.menu.findItem(R.id.item_search).actionView as SearchView

        var disposable: Disposable = viewModel.books.subscribe { items ->
            binding.progressBar.visibility = View.GONE
            adapter.swap(items)
            if (items.isEmpty()) {
                binding.labelNotFound.visibility = View.VISIBLE
                val query = searchView.query.toString()
                binding.labelNotFound.text = getString(R.string.label_not_found, query)
            }
        }
        compositeDisposable.add(disposable)

        disposable = viewModel.error.subscribe {
            binding.progressBar.visibility = View.GONE
            binding.btnRetry.visibility = View.VISIBLE
        }
        compositeDisposable.add(disposable)



        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                binding.labelNotFound.visibility = View.GONE
                adapter.swap(emptyList())
                binding.progressBar.visibility = View.VISIBLE
                viewModel.search(query)
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })

        binding.btnRetry.setOnClickListener { v ->
            val query = searchView.query.toString()
            binding.progressBar.visibility = View.VISIBLE
            viewModel.search(query)
            v.visibility = View.GONE
        }
    }

    override fun onDestroyView() {
        compositeDisposable.clear()
        super.onDestroyView()
    }

    private val onActionItemListener = object : BooksAdapter.OnActionItemListener {
        override fun onItemClick(item: Book) {
            viewModel.showBookDetails(item)
        }
    }
}