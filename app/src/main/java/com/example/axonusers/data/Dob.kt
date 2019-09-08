package com.example.axonusers.data

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class Dob(parcel: Parcel) :Parcelable{
    @SerializedName("date") var date: String? = null
    @SerializedName("age") var age: Int = 0

    init {
        date = parcel.readString()
        age = parcel.readInt()
    }


    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(date)
        parcel.writeInt(age)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Dob> {
        override fun createFromParcel(parcel: Parcel): Dob {
            return Dob(parcel)
        }

        override fun newArray(size: Int): Array<Dob?> {
            return arrayOfNulls(size)
        }
    }
}