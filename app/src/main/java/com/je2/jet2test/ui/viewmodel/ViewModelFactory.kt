package com.je2.jet2test.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.je2.jet2test.data.BlogRepository

/**
 * Factory for ViewModels
 */
class ViewModelFactory(private val repository: BlogRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BlogsViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return BlogsViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
