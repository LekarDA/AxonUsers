package com.example.axonusers.data

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class Coordinates(parcel: Parcel) :Parcelable{
    @SerializedName("latitude") var latitude: String? = null
    @SerializedName("longitude") var longitude: String? = null


    init {
        latitude = parcel.readString()
        longitude = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(latitude)
        parcel.writeString(longitude)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Coordinates> {
        override fun createFromParcel(parcel: Parcel): Coordinates {
            return Coordinates(parcel)
        }

        override fun newArray(size: Int): Array<Coordinates?> {
            return arrayOfNulls(size)
        }
    }
}