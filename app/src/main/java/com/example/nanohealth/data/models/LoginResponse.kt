package com.example.nanohealth.data.models

import com.google.gson.annotations.SerializedName

data class LoginResponse(@SerializedName("token") var token: String? = null)
