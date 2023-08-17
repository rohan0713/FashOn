package com.kotlin.fashon.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Retrofit{

    init {
        println("Retrofit class is invoked")
    }

    private const val url = "https://fashon.free.beeceptor.com/"

    fun getClient() : MyApi {
        return Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(MyApi::class.java)
    }
}