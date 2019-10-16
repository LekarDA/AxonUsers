package com.example.axonusers.data

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class Info() :Parcelable{
    @SerializedName("seed")    var seed: String? = null
    @SerializedName("results") var results: Int = 0
    @SerializedName("page")    var page: Int = 0
    @SerializedName("version") var version: String? = null

    constructor(parcel: Parcel) : this() {
        seed = parcel.readString()
        results = parcel.readInt()
        page = parcel.readInt()
        version = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(seed)
        parcel.writeInt(results)
        parcel.writeInt(page)
        parcel.writeString(version)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Info> {
        override fun createFromParcel(parcel: Parcel): Info {
            return Info(parcel)
        }

        override fun newArray(size: Int): Array<Info?> {
            return arrayOfNulls(size)
        }
    }


}