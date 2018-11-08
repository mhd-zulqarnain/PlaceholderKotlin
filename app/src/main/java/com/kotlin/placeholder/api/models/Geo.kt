package com.kotlin.placeholder.api.models

import android.os.Parcel
import android.os.Parcelable

data class Geo(val lat: Float, val lng: Float):Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readFloat(),
            parcel.readFloat()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeFloat(lat)
        parcel.writeFloat(lng)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Geo> {
        override fun createFromParcel(parcel: Parcel): Geo {
            return Geo(parcel)
        }

        override fun newArray(size: Int): Array<Geo?> {
            return arrayOfNulls(size)
        }
    }
}