package com.kotlin.placeholder.mainsreen.users

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kotlin.placeholder.R
import com.kotlin.placeholder.databinding.UsersFragmentBinding

class UsersFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<UsersFragmentBinding>(inflater, R.layout.users_fragment, container, false)

        initViewModel()
        initBinding()

        return binding.root
    }

    private fun initViewModel() {
        val viewModel = ViewModelProviders.of(this).get(UsersViewModel::class.java)
        viewModel.init(UserModel())
    }

    private fun initBinding() {

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