package com.kotlin.placeholder.mainsreen.photos

import com.kotlin.placeholder.App
import com.kotlin.placeholder.api.models.Album
import com.kotlin.placeholder.api.models.Photo

interface PhotosContractModel {
    suspend fun loadCurrentUserAlbums(id: Int): List<Album>
    suspend fun loadAlbumPhotos(id: Int): List<Photo>
}

class PhotosModel : PhotosContractModel {
    override suspend fun loadAlbumPhotos(id: Int): List<Photo> {
        return App.api.getPhotos(id).await()
    }

    override suspend fun loadCurrentUserAlbums(id: Int): List<Album> {
        return App.api.getAlbums(id).await()
    }

}