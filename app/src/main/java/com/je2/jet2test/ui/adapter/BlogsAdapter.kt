package com.je2.jet2test.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.je2.jet2test.databinding.ItemBlogsBinding
import com.je2.jet2test.model.Blog

/**
 * Adapter for the list of repositories.
 */
class BlogsAdapter : PagingDataAdapter<Blog, BlogViewHolder>(UIMODEL_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlogViewHolder {
        val binding: ItemBlogsBinding =
            ItemBlogsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BlogViewHolder(binding)
    }


    override fun onBindViewHolder(holder: BlogViewHolder, position: Int) {
        val uiModel = getItem(position)
        uiModel.let {
            holder.bind(uiModel)
        }
    }

    companion object {
        private val UIMODEL_COMPARATOR = object : DiffUtil.ItemCallback<Blog>() {
            override fun areItemsTheSame(oldItem: Blog, newItem: Blog): Boolean {
                return oldItem.id == newItem.id

            }

            override fun areContentsTheSame(oldItem: Blog, newItem: Blog): Boolean =
                oldItem == newItem
        }
    }
}