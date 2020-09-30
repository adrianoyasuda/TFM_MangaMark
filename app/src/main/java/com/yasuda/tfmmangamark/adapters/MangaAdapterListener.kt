package com.yasuda.tfmmangamark.adapters

import com.yasuda.tfmmangamark.model.Manga

interface MangaAdapterListener {
    fun onBookSelected(manga: Manga)
}