package com.example.nanohealth.ui.main.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.nanohealth.data.models.Login
import com.example.nanohealth.data.models.LoginResponse
import com.example.nanohealth.data.repository.LoginRepository
import com.example.nanohealth.ui.base.BaseViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginViewModel constructor(
    application: Application
) : BaseViewModel(application) {

    private val loginRepository = LoginRepository()
    val loginResponse = MutableLiveData<LoginResponse>()


    fun sendLongRequest(email: String, password: String) {
        loading.value = true
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            val response = loginRepository.loginRequest(
                Login(username = email, password= password)
            )
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    loading.postValue(false)
                    loginResponse.postValue(response.body())
                } else {
                    loading.postValue(false)
                    apiError.postValue(response.message())
                }
            }
        }

    }


}