package com.example.notbored.data.service

import com.example.notbored.data.model.ResponseActivity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface APIServiceActivity {
    @GET("api/activity?")
    suspend fun getActivity(
        @Query("type") type: String,
        @Query("participants") participants: String
    ): Response<ResponseActivity>
}