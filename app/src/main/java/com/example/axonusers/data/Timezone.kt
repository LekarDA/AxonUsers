package com.example.axonusers.data

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class Timezone() : Parcelable {
    @SerializedName("offset")      var offset: String? = null
    @SerializedName("description") var description: String? = null

    constructor(parcel: Parcel) : this() {
        offset = parcel.readString()
        description = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(offset)
        parcel.writeString(description)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Timezone> {
        override fun createFromParcel(parcel: Parcel): Timezone {
            return Timezone(parcel)
        }

        override fun newArray(size: Int): Array<Timezone?> {
            return arrayOfNulls(size)
        }
    }

}