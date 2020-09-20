package com.je2.jet2test.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "media")
data class Media(
        val blogId: String = "",
        val createdAt: String = "",
        @PrimaryKey
        val id: String = "",
        val image: String = "",
        val title: String = "",
        val url: String = ""
)