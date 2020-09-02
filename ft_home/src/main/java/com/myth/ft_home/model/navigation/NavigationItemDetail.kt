package com.myth.ft_home.model.navigation

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

/**
 * @author : myth_hai
 * @date : 2020/9/2 15:54
 * @description : NavigationItemDetail
 */
data class NavigationItemDetail(
    val id: Int,
    val link: String,
    val title: String,
    val chapterId: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(link)
        parcel.writeString(title)
        parcel.writeInt(chapterId)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<NavigationItemDetail> {
        override fun createFromParcel(parcel: Parcel): NavigationItemDetail {
            return NavigationItemDetail(parcel)
        }

        override fun newArray(size: Int): Array<NavigationItemDetail?> {
            return arrayOfNulls(size)
        }
    }
}
