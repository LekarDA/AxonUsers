package com.example.axonusers.data

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class Results(parcel: Parcel) :Parcelable{
    @SerializedName("gender")   var gender: String? = null
    @SerializedName("name")     var name: Name? = null
    @SerializedName("location") var location: Location? = null
    @SerializedName("email")    var email: String? = null
    @SerializedName("login")    var login: Login? = null
    @SerializedName("dob")      var dob: Dob? = null
    @SerializedName("registered") var registered: Registered? = null
    @SerializedName("phone")    var phone: String? = null
    @SerializedName("cell")     var cell: String? = null
    @SerializedName("id")       var id: Id? = null
    @SerializedName("picture")  var picture: Pictures? = null
    @SerializedName("nat")      var nat: String? = null


    init {
        gender = parcel.readString()
        name = parcel.readParcelable(Name::class.java.classLoader)
        location = parcel.readParcelable(Location::class.java.classLoader)
        email = parcel.readString()
        login = parcel.readParcelable(Login::class.java.classLoader)
        dob = parcel.readParcelable(Dob::class.java.classLoader)
        registered = parcel.readParcelable(Registered::class.java.classLoader)
        phone = parcel.readString()
        cell = parcel.readString()
        id = parcel.readParcelable(Id::class.java.classLoader)
        picture = parcel.readParcelable(Pictures::class.java.classLoader)
        nat = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(gender)
        parcel.writeParcelable(name, flags)
        parcel.writeParcelable(location, flags)
        parcel.writeString(email)
        parcel.writeParcelable(login, flags)
        parcel.writeParcelable(dob,flags)
        parcel.writeParcelable(registered,flags)
        parcel.writeString(phone)
        parcel.writeString(cell)
        parcel.writeParcelable(id, flags)
        parcel.writeParcelable(picture, flags)
        parcel.writeString(nat)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Results> {
        override fun createFromParcel(parcel: Parcel): Results {
            return Results(parcel)
        }

        override fun newArray(size: Int): Array<Results?> {
            return arrayOfNulls(size)
        }
    }
}