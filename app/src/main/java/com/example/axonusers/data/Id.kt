package com.example.axonusers.data

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import org.jetbrains.annotations.Nullable
import java.lang.Exception
import java.lang.NumberFormatException


class Id() :Parcelable {


    @SerializedName("name")  var name: String? = "test"
    @SerializedName("value") var value: String? = "test"


    constructor(parcel: Parcel) : this() {
        name = parcel.readString()
        value = parcel.readString()
    }

    companion object CREATOR : Parcelable.Creator<Id> {
        override fun createFromParcel(parcel: Parcel): Id {
            return Id(parcel)
        }

        override fun newArray(size: Int): Array<Id?> {
            return arrayOfNulls(size)
        }
    }

    override fun writeToParcel(parcel: Parcel?, p1: Int) {
        parcel?.writeString(name)
        parcel?.writeString(value)
    }

    override fun describeContents(): Int {
        return 0
    }
}