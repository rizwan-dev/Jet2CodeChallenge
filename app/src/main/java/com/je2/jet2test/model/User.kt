package com.je2.jet2test.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
    val about: String = "",
    val avatar: String = "",
    val blogId: String = "",
    val city: String = "",
    val createdAt: String = "",
    val designation: String = "",
    @PrimaryKey
    val id: String = "",
    val lastname: String = "",
    val name: String = ""
)