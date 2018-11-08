package com.kotlin.placeholder.mainsreen.photos

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.kotlin.placeholder.api.models.Photo
import com.kotlin.placeholder.api.models.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class PhotosViewModel : ViewModel() {
    private lateinit var model: PhotosContractModel
    private lateinit var user: User
    private val viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
    val photosData = MutableLiveData<List<Photo>>()

    fun init(model: PhotosContractModel, user: User) {
        this.model = model
        this.user = user
        loadPhotos()
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    private fun loadPhotos() {
        uiScope.launch {
            model.loadCurrentUserAlbums(user.id).forEach {
                photosData.value = model.loadAlbumPhotos(it.id)
            }
        }
    }
}