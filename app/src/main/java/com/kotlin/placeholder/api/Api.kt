package com.kotlin.placeholder.api

import com.kotlin.placeholder.api.models.User
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface Api {
    @GET(users)
    fun getUsers(): Deferred<List<User>>
}