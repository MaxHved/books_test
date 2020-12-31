package com.test.books.presentation.book

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.test.books.R
import com.test.books.data.model.Book
import com.test.books.databinding.FragmentBookDetailBinding
import com.test.books.di.Injector
import com.test.books.presentation.base.BaseFragment

class BookDetailsFragment : BaseFragment<BookDetailsViewModel>() {

    companion object {
        private const val ARG_BOOK_ID = "arg_book_id"

        fun newInstance(book: Book): BookDetailsFragment {
            val args = Bundle()
            args.putParcelable(ARG_BOOK_ID, book)
            val fragment = BookDetailsFragment()
            fragment.arguments = args
            return fragment
        }
    }

    private lateinit var binding: FragmentBookDetailBinding

    override fun inject() = Injector.bookDetailsComponent().inject(this)

    override fun injectViewModel() {
        viewModel = getViewModel()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBookDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.toolbar.navigationIcon =
            ContextCompat.getDrawable(requireContext(), R.drawable.ic_baseline_arrow_back_24)
        binding.toolbar.setNavigationOnClickListener {
            viewModel.back()
        }
    }
}