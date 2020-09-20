package com.je2.jet2test.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.je2.jet2test.databinding.ItemBlogsBinding
import com.je2.jet2test.model.Blog


class BlogViewHolder(private val binding: ItemBlogsBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(blog: Blog?) {
        blog?.let {
            binding.blog = it
            if (it.media.isNotEmpty()) {
                binding.media = it.media[0]
            }
            else{
                binding.media = null
            }
            binding.executePendingBindings()
        }
    }
}
