package com.example.axonusers.data

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName


class Id(parcel: Parcel) :Parcelable {

    @SerializedName("name")  var name: String? = null
    @SerializedName("value") var value: String? = null

    init {
        name = parcel.readString()
        value = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(value)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Id> {
        override fun createFromParcel(parcel: Parcel): Id {
            return Id(parcel)
        }

        override fun newArray(size: Int): Array<Id?> {
            return arrayOfNulls(size)
        }
    }

}