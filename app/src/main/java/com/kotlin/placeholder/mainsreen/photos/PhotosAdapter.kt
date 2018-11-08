package com.kotlin.placeholder.mainsreen.photos

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.kotlin.placeholder.R
import com.kotlin.placeholder.api.models.Photo
import com.kotlin.placeholder.databinding.FragmentPhotosListItemBinding

class PhotosAdapter : RecyclerView.Adapter<PhotosAdapter.PhotosHolder>() {
    private val photos = ArrayList<Photo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<FragmentPhotosListItemBinding>(inflater, R.layout.fragment_photos_list_item, parent, false)
        return PhotosHolder(binding)
    }

    override fun getItemCount(): Int {
        return photos.size
    }

    override fun onBindViewHolder(holder: PhotosHolder, position: Int) {
        holder.bind(photos[position])
    }

    fun addPhotos(photos: List<Photo>) {
        val oldSize = photos.size
        this.photos.addAll(photos)
        notifyItemRangeInserted(oldSize, photos.size)
    }

    inner class PhotosHolder(var binding: FragmentPhotosListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(photo: Photo) {
            binding.photo = photo
        }

    }
}