package com.example.nanohealth.data

import com.example.nanohealth.data.models.Login
import com.example.nanohealth.data.models.LoginResponse
import com.example.nanohealth.data.models.Product
import com.example.nanohealth.data.models.ProductList
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path
import java.net.IDN

interface Apis {

    @Headers(
        "Content-Type:application/json", "accept:application/json"
    )
    @POST("auth/login")
    suspend fun loginRequest(@Body loginRequest: Login): Response<LoginResponse>

    @Headers(
        "Content-Type:application/json", "accept:application/json"
    )
    @GET("products")
    suspend fun getProductList(): Response<List<Product>>

    @Headers(
        "Content-Type:application/json", "accept:application/json"
    )
    @GET("products/{id}")
    suspend fun getProductDetails(@Path("id") id:Int): Response<Product>
}