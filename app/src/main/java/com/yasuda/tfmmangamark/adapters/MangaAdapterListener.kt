package com.yasuda.tfmmangamark.adapters

import com.yasuda.tfmmangamark.model.Manga
import com.yasuda.tfmmangamark.model.User

interface MangaAdapterListener {
    fun onBookSelected(manga: Manga)
    fun userInsert(user : User)
    fun userUpdate(user : User)
}