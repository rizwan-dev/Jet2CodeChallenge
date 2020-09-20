package com.je2.jet2test.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.je2.jet2test.model.Media
import com.je2.jet2test.model.User

class TypeConverter{
    @TypeConverter
    fun fromUserList(userList: List<User?>?): String? {
        val type = object : TypeToken<List<User>>() {}.type
        return Gson().toJson(userList, type)
    }

    @TypeConverter
    fun toUserList(countryLangString: String?): List<User>? {
        val type = object : TypeToken<List<User?>?>() {}.type
        return Gson().fromJson<List<User>>(countryLangString, type)
    }

    @TypeConverter
    fun fromMediaList(mediaList: List<Media?>?): String? {
        val type = object : TypeToken<List<Media>>() {}.type
        return Gson().toJson(mediaList, type)
    }

    @TypeConverter
    fun toMediaList(countryLangString: String?): List<Media>? {
        val type = object : TypeToken<List<Media?>?>() {}.type
        return Gson().fromJson<List<Media>>(countryLangString, type)
    }

    @TypeConverter
    fun stringListToJson(value: List<String>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToStringList(value: String) = Gson().fromJson(value, Array<String>::class.java).toList()
}

