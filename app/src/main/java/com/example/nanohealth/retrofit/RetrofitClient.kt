package com.example.nanohealth.retrofit

import com.example.nanohealth.utilities.Constants
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class RetrofitClient {

    companion object {
        var retrofit: Retrofit? = null
    }

    private var stringBuilder = StringBuilder()


    private var logging =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.HEADERS).setLevel(
            HttpLoggingInterceptor.Level.BODY
        )


    private val okHttpClient =
        OkHttpClient().newBuilder().addInterceptor(logging)
            .addInterceptor(Interceptor { chain ->
                val newRequest = chain.request().newBuilder().addHeader(
                    "Content-Type", "application/json"
                ).addHeader(
                    "Connection", "keep-alive"
                ).build()

                chain.proceed(newRequest)
            }).connectTimeout(20, TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS).retryOnConnectionFailure(true)
            .build()

    fun getRetrofitConnection(): Retrofit {

        return if (retrofit == null) {
            retrofit = Retrofit.Builder().client(okHttpClient).baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build()
            retrofit as Retrofit
        } else {
            retrofit as Retrofit
        }
    }

    fun clearRetrofit() {
        retrofit = null
    }
}