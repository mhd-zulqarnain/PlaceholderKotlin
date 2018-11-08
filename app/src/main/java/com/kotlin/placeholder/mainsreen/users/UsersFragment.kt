package com.kotlin.placeholder.mainsreen.users

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kotlin.placeholder.R
import com.kotlin.placeholder.api.models.User
import com.kotlin.placeholder.databinding.FragmentUsersBinding
import com.kotlin.placeholder.mainsreen.users.adapter.UsersAdapter
import com.kotlin.placeholder.utils.debug


class UsersFragment : Fragment() {
    private lateinit var binding: FragmentUsersBinding
    private val usersViewModel: UsersViewModel
        get() {
            return ViewModelProviders.of(this).get(UsersViewModel::class.java)
        }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_users, container, false)

        initViewModel()
        initBinding()

        val appCompatActivity = activity as AppCompatActivity
        appCompatActivity.setSupportActionBar(binding.toolbar)
        appCompatActivity.supportActionBar?.setTitle(R.string.app_name)

        return binding.root
    }

    private fun initViewModel() {
        usersViewModel.init(UserModel())
    }

    private fun initBinding() {
        usersViewModel.usersData.observe(this, Observer {
            if (it != null) {
                handleUsers(it)
            }
        })
    }

    private fun handleUsers(users: List<User>) {
        binding.usersList.adapter = UsersAdapter(users)
        debug(UsersFragment::class, users)
    }

    companion object {
        fun newInstance() = UsersFragment()

        fun startFragment(supportFragmentManager: FragmentManager) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(android.R.id.content, newInstance())
                    .commit()
        }
    }
}