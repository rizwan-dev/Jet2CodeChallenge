package com.example.android.codelabs.paging.ui

import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter

class BlogsLoadStateAdapter(
        private val retry: () -> Unit
) : LoadStateAdapter<BlogsLoadStateViewHolder>() {
    override fun onBindViewHolder(holder: BlogsLoadStateViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): BlogsLoadStateViewHolder {
        return BlogsLoadStateViewHolder.create(parent, retry)
    }
}
