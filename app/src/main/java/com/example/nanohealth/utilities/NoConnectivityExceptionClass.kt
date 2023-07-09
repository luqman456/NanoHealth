package com.example.nanohealth.utilities

import java.io.IOException

class NoConnectivityExceptionClass : IOException() {

    override val cause: Throwable?
        get() = super.cause


}