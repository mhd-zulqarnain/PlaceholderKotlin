package com.kotlin.placeholder.users.viewModel

import android.arch.lifecycle.ViewModel
import com.kotlin.placeholder.users.model.UsersContractModel

class UsersViewModel : ViewModel() {
    private lateinit var model: UsersContractModel

    fun init(model: UsersContractModel) {
        this.model = model;
        loadUsers()
    }

    private fun loadUsers() {
        model.loadUsers()
    }


}