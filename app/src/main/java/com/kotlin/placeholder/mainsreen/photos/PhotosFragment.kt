package com.kotlin.placeholder.mainsreen.photos

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
import com.kotlin.placeholder.databinding.FragmentPhotosBinding
import com.kotlin.placeholder.utils.debug

class PhotosFragment : Fragment() {
    private lateinit var photosAdapter: PhotosAdapter

    private val photosViewModel: PhotosViewModel
        get() = ViewModelProviders.of(this)[PhotosViewModel::class.java]

    private val user: User
        get() = arguments?.getParcelable(USER)
                ?: throw IllegalArgumentException(" there is no user in arguments")


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentPhotosBinding>(inflater, R.layout.fragment_photos, container, false)

        initViewModel()

        val appCompatActivity = activity as AppCompatActivity
        appCompatActivity.setSupportActionBar(binding.toolbar.toolbar)
        appCompatActivity.supportActionBar?.setTitle(R.string.app_name)
        appCompatActivity.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        appCompatActivity.supportActionBar?.setDisplayShowHomeEnabled(true)

        photosAdapter = PhotosAdapter()
        binding.photosList.adapter = photosAdapter

        return binding.root
    }

    private fun initViewModel() {
        photosViewModel.init(PhotosModel(), user)
        photosViewModel.photosData.observe(this, Observer { it?.let { photos -> photosAdapter.addPhotos(photos) } })
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
                    .addToBackStack(null)
                    .commit()
        }
    }
}