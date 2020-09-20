package com.je2.jet2test.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.je2.jet2test.api.BlogService
import com.je2.jet2test.db.BlogDatabase
import com.je2.jet2test.model.Blog
import kotlinx.coroutines.flow.Flow

/**
 * Repository class that works with local and remote data sources.
 */
class BlogRepository(
    private val service: BlogService,
    private val database: BlogDatabase
) {

    /**
     * Search repositories whose names match the query, exposed as a stream of data that will emit
     * every time we get more data from the network.
     */
    fun getSearchResultStream(): Flow<PagingData<Blog>> {

        val pagingSourceFactory = { database.blogsDao().reposByName() }

        return Pager(
                config = PagingConfig(pageSize = NETWORK_PAGE_SIZE, enablePlaceholders = false),
                remoteMediator = BlogRemoteMediator(
                        service,
                        database
                ),
                pagingSourceFactory = pagingSourceFactory
        ).flow
    }

    companion object {
        private const val NETWORK_PAGE_SIZE = 15
    }
}
