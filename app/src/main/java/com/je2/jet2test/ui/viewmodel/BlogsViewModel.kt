package com.je2.jet2test.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.je2.jet2test.data.BlogRepository
import com.je2.jet2test.model.Blog
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow


@ExperimentalCoroutinesApi
class BlogsViewModel(private val repository: BlogRepository) : ViewModel() {


    fun loadArticles(): Flow<PagingData<Blog>> {

        return repository.getSearchResultStream().cachedIn(viewModelScope)

    }
}




