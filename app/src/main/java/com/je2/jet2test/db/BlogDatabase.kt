package com.je2.jet2test.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.je2.jet2test.model.Blog
import com.je2.jet2test.model.Media
import com.je2.jet2test.model.User

@Database(
        entities = [Blog::class , RemoteKeys::class, User::class, Media::class ],
        version = 1,
        exportSchema = false
)
@TypeConverters(TypeConverter::class)
abstract class BlogDatabase : RoomDatabase() {

    abstract fun blogsDao(): BlogDao
    abstract fun remoteKeysDao(): RemoteKeysDao

    companion object {

        @Volatile
        private var INSTANCE: BlogDatabase? = null

        fun getInstance(context: Context): BlogDatabase =
                INSTANCE ?: synchronized(this) {
                    INSTANCE
                            ?: buildDatabase(context).also { INSTANCE = it }
                }

        private fun buildDatabase(context: Context) =
                Room.databaseBuilder(context.applicationContext,
                        BlogDatabase::class.java, "Blogs.db")
                        .build()
    }
}
