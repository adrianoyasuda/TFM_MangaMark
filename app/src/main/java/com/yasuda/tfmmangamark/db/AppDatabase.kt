package com.yasuda.tfmmangamark.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.yasuda.tfmmangamark.db.dao.UserDao
import com.yasuda.tfmmangamark.model.User

@Database(entities = [User::class],version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao
}