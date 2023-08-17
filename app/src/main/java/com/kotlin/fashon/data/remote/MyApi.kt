package com.kotlin.fashon.data.remote

import com.kotlin.fashon.data.model.Product
import retrofit2.Response
import retrofit2.http.GET

interface MyApi {

    @GET("products/popular")
    suspend fun getProducts(): Response<List<Product>>
}