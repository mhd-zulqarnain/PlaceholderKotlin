package com.kotlin.placeholder.mainsreen.photos

import com.kotlin.placeholder.App
import com.kotlin.placeholder.api.models.Album

interface PhotosContractModel {
    suspend fun loadCurrentUserAlbums(id: Int): List<Album>
}

class PhotosModel : PhotosContractModel {

    override suspend fun loadCurrentUserAlbums(id: Int): List<Album> {
        return App.api.getAlbums(id).await()
    }

}