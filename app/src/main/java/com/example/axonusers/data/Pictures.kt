package com.example.axonusers.data

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class Pictures() :Parcelable{
    @SerializedName("large")     var large: String? = null
    @SerializedName("medium")    var medium: String? = null
    @SerializedName("thumbnail") var thumbnail: String? = null

    constructor(parcel: Parcel) : this() {
        large = parcel.readString()
        medium = parcel.readString()
        thumbnail = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(large)
        parcel.writeString(medium)
        parcel.writeString(thumbnail)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Pictures> {
        override fun createFromParcel(parcel: Parcel): Pictures {
            return Pictures(parcel)
        }

        override fun newArray(size: Int): Array<Pictures?> {
            return arrayOfNulls(size)
        }
    }

}