package com.kotlin.placeholder.mainsreen.photos

import android.arch.lifecycle.ViewModel
import com.kotlin.placeholder.api.models.User
import com.kotlin.placeholder.utils.debug
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class PhotosViewModel : ViewModel() {
    private lateinit var model: PhotosContractModel
    private lateinit var user: User
    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

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
            model.loadCurrentUserAlbums(user.id).forEach { debug(PhotosViewModel::class, it) }
        }
    }


}