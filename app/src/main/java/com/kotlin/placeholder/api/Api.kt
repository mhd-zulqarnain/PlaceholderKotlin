package com.kotlin.placeholder.api

import com.kotlin.placeholder.api.models.Album
import com.kotlin.placeholder.api.models.Photo
import com.kotlin.placeholder.api.models.User
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET(users)
    fun getUsers(): Deferred<List<User>>

    @GET(albums)
    fun getAlbums(@Query(userId) id: Int): Deferred<List<Album>>

    @GET(photos)
    fun getPhotos(@Query(albumId) id: Int): Deferred<List<Photo>>
}