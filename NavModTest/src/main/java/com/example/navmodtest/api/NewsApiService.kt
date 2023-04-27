package com.example.navmodtest.api

import com.example.navmodtest.model.APIResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {

    @GET("v2/top-headlines")
    suspend fun getTopHeadLines(
        @Query("country")
        country: String,
        @Query("page")
        page: Int,
        @Query("apiKey")
        apiKey: String = "6e78994c26b747fab331f7563db4663c"
    ): Response<APIResponse>
}