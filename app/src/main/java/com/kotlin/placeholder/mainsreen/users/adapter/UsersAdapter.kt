package com.kotlin.placeholder.mainsreen.users.adapter

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.kotlin.placeholder.R
import com.kotlin.placeholder.api.models.User
import com.kotlin.placeholder.databinding.FragmentUserListItemBinding

class UsersAdapter(var users: List<User>, var interaction: UsersAdapterInteraction) : RecyclerView.Adapter<UsersAdapter.UsersHolder>() {

    interface UsersAdapterInteraction {
        fun onClickItem(user: User)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<FragmentUserListItemBinding>(inflater, R.layout.fragment_user_list_item, parent, false)
        return UsersHolder(binding)
    }

    override fun getItemCount() = users.size

    override fun onBindViewHolder(holder: UsersHolder, position: Int) {
        holder.bind(users[position])
    }

    inner class UsersHolder(var binding: FragmentUserListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User) {
            binding.user = user
            itemView.setOnClickListener { interaction.onClickItem(user) }
        }
    }
}