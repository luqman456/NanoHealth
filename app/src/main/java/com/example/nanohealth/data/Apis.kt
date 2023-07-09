package com.example.nanohealth.data

import com.example.nanohealth.data.models.Login
import com.example.nanohealth.data.models.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface Apis {

    @Headers(
        "Content-Type:application/json", "accept:application/json"
    )
    @POST("auth/login")
    suspend fun loginRequest(@Body loginRequest: Login): Response<LoginResponse>
}