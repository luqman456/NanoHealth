package com.example.nanohealth.data.repository

import com.example.nanohealth.data.models.Login
import com.example.nanohealth.ui.NanoHealth

class LoginRepository {

    suspend fun loginRequest(login: Login) =
        NanoHealth.getRetrofitClient().loginRequest(login)
}