package com.je2.jet2test.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.je2.jet2test.model.User

@Entity(tableName = "blogs")
data class Blog(
        val comments: Int,
        val content: String,
        val createdAt: String,
        @PrimaryKey
        val id: String,
        val likes: Int,
        val media: List<Media>,
        val user: List<User>
)