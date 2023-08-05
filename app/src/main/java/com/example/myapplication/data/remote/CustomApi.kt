package com.example.myapplication.data.remote

import com.example.myapplication.data.remote.dtos.TimeLineDto
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Path

interface CustomApi {

    @Multipart
    @GET("weather")
    suspend fun refreshWeather(): Response<TimeLineDto>


}