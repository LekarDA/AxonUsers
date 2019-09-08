package com.example.axonusers.data

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class User(parcel: Parcel) :Parcelable {
    @SerializedName("results")  var results: List<Results>? = null
    @SerializedName("info")     var info: Info? = null

    init {
        results = arrayListOf<Results>().apply { parcel.readList(this, Results::class.java.classLoader) }
        info = parcel.readParcelable(Info::class.java.classLoader)
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeList(results)
        parcel.writeParcelable(info, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }

}