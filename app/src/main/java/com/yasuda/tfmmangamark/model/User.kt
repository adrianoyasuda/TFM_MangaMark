package com.yasuda.tfmmangamark.model

import java.io.Serializable

data class User(
    var id: Long,
    var login: String,
    var password: String
): Serializable{
    lateinit var mymangas:List<Manga>
}