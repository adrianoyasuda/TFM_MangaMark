package com.yasuda.tfmmangamark.util

import com.yasuda.tfmmangamark.api.MangaService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BookServiceGenerator {
    companion object {
        private var retrofit: Retrofit? = null
        private var service: MangaService? = null

        fun getService(): MangaService {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl("http://10.1.1.103:3000/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                service = retrofit!!.create(MangaService::class.java)
            }
            return service!!
        }
    }
}