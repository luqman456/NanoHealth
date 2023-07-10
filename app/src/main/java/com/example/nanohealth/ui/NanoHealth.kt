package com.example.nanohealth.ui

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.example.nanohealth.data.Apis
import com.example.nanohealth.retrofit.RetrofitClient

class NanoHealth : Application() {

    companion object {

        @SuppressLint("StaticFieldLeak")
        private var instance: Context? = null

        fun applicationContext(): NanoHealth {
            return instance as NanoHealth
        }

        fun getRetrofitClient(): Apis {
            return RetrofitClient().getRetrofitConnection().create(Apis::class.java)
        }

    }

    init {
        instance = this
    }

    override fun onCreate() {
        super.onCreate()
    }

}