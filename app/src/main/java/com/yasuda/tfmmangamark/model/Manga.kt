package com.yasuda.tfmmangamark.model

import java.io.Serializable

data class Manga(
    var id: Long,
    var title: String,
    var author: String,
    var publisher: String,
    var year: Int,
    var edition: Int
) : Serializable {
    lateinit var chapters: List<Chapter>
}

