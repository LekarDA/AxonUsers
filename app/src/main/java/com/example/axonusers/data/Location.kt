package com.example.axonusers.data

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class Location() :Parcelable{
    @SerializedName("street")       var street: String? = null
    @SerializedName("city")         var city: String? = null
    @SerializedName("state")        var state: String? = null
    @SerializedName("postcode")     var postcode: String? = null
    @SerializedName("coordinates")  var coordinates: Coordinates? = null
    @SerializedName("timezone")     var timezone:Timezone? = null

    constructor(parcel: Parcel) : this() {
        street = parcel.readString()
        city = parcel.readString()
        state = parcel.readString()
        postcode = parcel.readString()
        coordinates = parcel.readParcelable(Coordinates::class.java.classLoader)
        timezone = parcel.readParcelable(Timezone::class.java.classLoader)
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(street)
        parcel.writeString(city)
        parcel.writeString(state)
        parcel.writeString(postcode)
        parcel.writeParcelable(coordinates, flags)
        parcel.writeParcelable(timezone, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Location> {
        override fun createFromParcel(parcel: Parcel): Location {
            return Location(parcel)
        }

        override fun newArray(size: Int): Array<Location?> {
            return arrayOfNulls(size)
        }
    }

}