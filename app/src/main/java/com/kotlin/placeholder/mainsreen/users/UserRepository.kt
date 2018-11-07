package com.kotlin.placeholder.mainsreen.users

import com.kotlin.placeholder.App
import com.kotlin.placeholder.api.models.User

interface UsersContractModel {
    suspend fun loadUsers(): List<User>
}

class UserModel : UsersContractModel {
    override suspend fun loadUsers() :List<User> {
        return App.api.getUsers().await()
    }
}