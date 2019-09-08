package com.example.axonusers.data

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class Login(parcel: Parcel) :Parcelable{
    @SerializedName("uuid")     var uuid: String? = null
    @SerializedName("username") var username: String? = null
    @SerializedName("password") var password: String? = null
    @SerializedName("salt")     var salt: String? = null
    @SerializedName("md5")      var md5: String? = null
    @SerializedName("sha1")     var sha1: String? = null
    @SerializedName("sha256")   var sha256: String? = null

    init {
        uuid = parcel.readString()
        username = parcel.readString()
        password = parcel.readString()
        salt = parcel.readString()
        md5 = parcel.readString()
        sha1 = parcel.readString()
        sha256 = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(uuid)
        parcel.writeString(username)
        parcel.writeString(password)
        parcel.writeString(salt)
        parcel.writeString(md5)
        parcel.writeString(sha1)
        parcel.writeString(sha256)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Login> {
        override fun createFromParcel(parcel: Parcel): Login {
            return Login(parcel)
        }

        override fun newArray(size: Int): Array<Login?> {
            return arrayOfNulls(size)
        }
    }
}