package com.example.nanohealth.ui.base

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.nanohealth.data.models.ExceptionModel
import com.example.nanohealth.utilities.ApiExceptionLog
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Job

open class BaseViewModel(application: Application) : AndroidViewModel(application) {

    @SuppressLint("StaticFieldLeak")
    val context: Context = getApplication<Application>().applicationContext

    val apiCallException = MutableLiveData<ExceptionModel>()
    var job: Job? = null
    val loading = MutableLiveData<Boolean?>()
    val apiError = MutableLiveData<String?>()

    val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        val exceptionModel = ApiExceptionLog.parseException(throwable)
        Log.e("Ex", "${throwable.printStackTrace()}")
        apiCallException.postValue(exceptionModel)
    }


    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }

}