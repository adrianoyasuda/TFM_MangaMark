package com.yasuda.tfmmangamark.api

import com.yasuda.tfmmangamark.model.Manga
import com.yasuda.tfmmangamark.results.GetChaptersResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MangaService {
    @GET("books")
    fun getAll(): Call<List<Manga>>

    @GET("books/{id}")
    fun get(): Call<Manga>

    @GET("chapters/{bookId}")
    fun getChapters(@Path("bookId") bookId: Long): Call<GetChaptersResult>
}