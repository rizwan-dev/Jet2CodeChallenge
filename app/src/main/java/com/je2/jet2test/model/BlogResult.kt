package com.je2.jet2test.model


sealed class BlogResult {
    data class Success(val data: List<Blog>) : BlogResult()
    data class Error(val error: Exception) : BlogResult()
}
