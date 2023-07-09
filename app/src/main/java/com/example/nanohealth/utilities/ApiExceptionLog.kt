package com.example.nanohealth.utilities

import com.example.nanohealth.R
import com.example.nanohealth.data.models.ExceptionModel
import com.example.nanohealth.ui.NanoHealth
import java.net.SocketTimeoutException
import java.util.concurrent.TimeoutException

class ApiExceptionLog {

    companion object {
        fun parseException(throwable: Throwable): ExceptionModel {

            when (throwable) {
                is TimeoutException -> {
                    return ExceptionModel(
                        NanoHealth.applicationContext().getString(R.string.request_timeout),
                        R.drawable.ic_error
                    )
                }
                is SocketTimeoutException -> {
                    return ExceptionModel(
                        NanoHealth.applicationContext().getString(R.string.connection_time_out),
                        R.drawable.ic_error
                    )

                }
                is NoConnectivityExceptionClass -> {
                    return ExceptionModel(
                        NanoHealth.applicationContext().getString(R.string.no_network_messag),
                        R.drawable.ic_error
                    )
                }
                else -> {
                    return ExceptionModel(
                        NanoHealth.applicationContext().getString(R.string.no_response_message),
                        R.drawable.ic_error
                    )
                }
            }

        }
    }
}