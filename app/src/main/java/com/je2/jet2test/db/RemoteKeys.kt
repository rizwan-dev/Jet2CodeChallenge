package com.je2.jet2test.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "remote_keys")
data class RemoteKeys(
        @PrimaryKey val blogId: String,
        val prevKey: Int?,
        val nextKey: Int?
)
