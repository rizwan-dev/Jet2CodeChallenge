package com.je2.jet2test

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.je2.jet2test.api.BlogService
import com.je2.jet2test.data.BlogRepository
import com.je2.jet2test.db.BlogDatabase
import com.je2.jet2test.ui.viewmodel.ViewModelFactory


object Injection {


    private fun provideBlogRepository(context: Context): BlogRepository {
        return BlogRepository(BlogService.create(), BlogDatabase.getInstance(context))
    }


    fun provideViewModelFactory(context: Context): ViewModelProvider.Factory {
        return ViewModelFactory(provideBlogRepository(context))
    }
}
