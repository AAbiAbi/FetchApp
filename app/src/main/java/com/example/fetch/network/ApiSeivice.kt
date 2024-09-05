package com.example.fetch.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

// Define your data model (same as JSON structure)
data class Item(val id: Int, val listId: Int, val name: String?)

// Define Retrofit API interface
interface FetchService {
    @GET("hiring.json")
    suspend fun getItems(): List<Item>
}

// Build Retrofit instance
fun createRetrofitService(): FetchService {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://fetch-hiring.s3.amazonaws.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    return retrofit.create(FetchService::class.java)
}
