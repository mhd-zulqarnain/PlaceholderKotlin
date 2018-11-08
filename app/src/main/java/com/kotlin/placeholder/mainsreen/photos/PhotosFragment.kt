package com.kotlin.placeholder.mainsreen.photos

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kotlin.placeholder.R
import com.kotlin.placeholder.api.models.User
import com.kotlin.placeholder.databinding.FragmentPhotosBinding

class PhotosFragment : Fragment() {
    private val photosViewModel: PhotosViewModel
        get() {
            return ViewModelProviders.of(this)[PhotosViewModel::class.java]
        }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentPhotosBinding>(inflater, R.layout.fragment_photos, container, false)

        initViewModel()

        return binding.root
    }

    private fun initViewModel() {
        photosViewModel.init(PhotosModel())
    }

    companion object {
        private const val USER = "USER"

        fun newInstance(user: User): PhotosFragment {
            val bundle = Bundle()
            bundle.apply { putParcelable(USER, user) }
            val photosFragment = PhotosFragment()
            photosFragment.arguments = bundle
            return photosFragment
        }

        fun startFragment(supportFragmentManager: FragmentManager, user: User) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(android.R.id.content, newInstance(user))
                    .commit()
        }
    }
}