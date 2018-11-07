package com.kotlin.placeholder.api

import android.widget.Toast
import com.kotlin.placeholder.App
import com.kotlin.placeholder.R
import java.io.IOException

interface ApiExceptions {
    fun handleException(exception: Exception) {
        when (exception) {
            is IOException -> {
                Toast.makeText(App.context, R.string.error_check_internet_connection, Toast.LENGTH_SHORT).show()
            }
            else -> {
                Toast.makeText(App.context, R.string.error_unknown_http_error, Toast.LENGTH_SHORT).show()
            }
        }
    }
}