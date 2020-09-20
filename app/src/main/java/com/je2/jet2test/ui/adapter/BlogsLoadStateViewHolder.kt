package com.example.android.codelabs.paging.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.recyclerview.widget.RecyclerView
import com.je2.jet2test.databinding.ItemLoadStateFooterViewBinding

class BlogsLoadStateViewHolder(
        private val binding: ItemLoadStateFooterViewBinding,
        retry: () -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    init {
        binding.retryButton.setOnClickListener { retry.invoke() }
    }

    fun bind(loadState: LoadState) {
        if (loadState is LoadState.Error) {
            binding.errorMsg.text = loadState.error.localizedMessage
        }
        binding.progressBar.isVisible = loadState is LoadState.Loading
        binding.retryButton.isVisible = loadState !is LoadState.Loading
        binding.errorMsg.isVisible = loadState !is LoadState.Loading
    }

    companion object {
        fun create(parent: ViewGroup, retry: () -> Unit): BlogsLoadStateViewHolder {
            val binding = ItemLoadStateFooterViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return BlogsLoadStateViewHolder(binding, retry)
        }
    }
}
