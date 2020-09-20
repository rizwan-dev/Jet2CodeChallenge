package com.je2.jet2test.api

import com.je2.jet2test.model.Blog
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


interface BlogService {
    @GET("jet2/api/v1/blogs")
    suspend fun fetchBlogs(
            @Query("page") page: Int,
            @Query("limit") itemsPerPage: Int
    ): List<Blog>

    companion object {
        private const val BASE_URL = "https://5e99a9b1bc561b0016af3540.mockapi.io/"

        fun create(): BlogService {
            val logger = HttpLoggingInterceptor()
            logger.level = Level.BASIC

            val client = OkHttpClient.Builder()
                    .addInterceptor(logger)
                    .build()
            return Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(BlogService::class.java)
        }
    }
}