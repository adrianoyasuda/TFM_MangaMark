package com.yasuda.tfmmangamark.fragments

import com.yasuda.tfmmangamark.model.Manga

interface MangaListFragmentListener {
    fun onBookSelected(manga: Manga)
}