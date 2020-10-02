package com.yasuda.tfmmangamark.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tb_user")
data class User(
    @ColumnInfo(name = "login")
    var login: String,
    @ColumnInfo(name = "password")
    var password: String,
    @ColumnInfo(name = "mybooks")
    var mybooks: String
){
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}