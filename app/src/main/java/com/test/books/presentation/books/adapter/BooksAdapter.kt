package com.test.books.presentation.books.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.test.books.data.model.Book
import com.test.books.data.model.coverUrl
import com.test.books.databinding.ItemBookBinding

class BooksAdapter(private val listener: OnActionItemListener) :
    RecyclerView.Adapter<BooksAdapter.ViewHolder>() {

    interface OnActionItemListener {
        fun onItemClick(item: Book)
    }

    private val items: MutableList<Book> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBookBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = items.size

    fun swap(items: List<Book>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ItemBookBinding) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        init {
            binding.root.setOnClickListener(this)
        }

        fun bind(item: Book) {
            binding.title.text = item.title
            binding.author.text = item.author_name.joinToString { it }
            Glide.with(binding.cover)
                .load(item.coverUrl())
                .into(binding.cover)
        }

        override fun onClick(v: View?) {
            val item = items[adapterPosition]
            listener.onItemClick(item)
        }
    }
}