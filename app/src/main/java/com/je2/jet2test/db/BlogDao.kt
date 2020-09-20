package com.je2.jet2test.db

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.je2.jet2test.model.Blog

@Dao
interface BlogDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(repos: List<Blog>)

    @Query("SELECT * FROM blogs")
    fun reposByName(): PagingSource<Int, Blog>

    @Query("DELETE FROM blogs")
    suspend fun clearBlogs()

}