package com.yasuda.tfmmangamark.db.dao

import androidx.room.*
import com.yasuda.tfmmangamark.model.User

@Dao
interface UserDao {
    @Query("SELECT * FROM tb_user")
    fun getAll(): List<User>

    @Query("SELECT * FROM tb_user WHERE id = :id LIMIT 1")
    fun findById(id: Int): User?

    @Query("SELECT * FROM tb_user WHERE login LIKE :login AND password LIKE :password")
    fun findByName(login: String, password: String): List<User>

    @Insert
    fun  insert(user: User): Long

    @Update
    fun  update(user: User)

    @Delete
    fun remove(user: User)

}