package com.kotlin.placeholder.mainsreen.users

import android.arch.lifecycle.ViewModel
import com.kotlin.placeholder.api.ApiExceptions
import com.kotlin.placeholder.api.models.User
import com.kotlin.placeholder.utils.debug
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class UsersViewModel : ViewModel(), ApiExceptions {
    private lateinit var model: UsersContractModel
    private val viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    fun init(model: UsersContractModel) {
        this.model = model;
        loadUsers()
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    private fun loadUsers() {
        uiScope.launch {
            val users: List<User>
            try {
                users = model.loadUsers()
                debug(UsersViewModel::class, users)
            } catch (e: Exception) {
                handleException(e)
                debug(UsersViewModel::class, e)
            }
        }
    }
}