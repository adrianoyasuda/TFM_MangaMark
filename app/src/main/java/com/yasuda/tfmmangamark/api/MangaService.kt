package com.yasuda.tfmmangamark.api

import com.yasuda.tfmmangamark.model.Manga
import com.yasuda.tfmmangamark.model.User
import com.yasuda.tfmmangamark.results.GetChaptersResult
import retrofit2.Call
import retrofit2.http.*


interface MangaService {
    @GET("mangas")
    fun getAll(): Call<List<Manga>>

    @GET("mangas/{id}")
    fun get(): Call<Manga>

    @GET("chapters/{mangaId}")
    fun getChapters(@Path("mangaId") mangaId: Long): Call<GetChaptersResult>

    @GET("users")
    fun getAllUsers(): Call<List<User>>

    @GET("users/{id}")
    fun getUser(@Path("id") id: Long): Call<User>

    @Headers("Content-Type: Application/json")
    @POST("users")
    fun insertUser(@Body task: User): Call<User>

}