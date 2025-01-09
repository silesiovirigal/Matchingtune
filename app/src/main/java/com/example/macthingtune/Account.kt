package com.example.macthingtune

import android.location.Location
import android.media.Image
import androidx.annotation.DrawableRes

data class Account(
    val id: Long,
    val id_Login: Int,
    val localizacao: Location,
    val age: Int,
    val id_follow: Int,
    val id_Follows: Int,
    val foto: Image,
    val firstName: String,
    val lastName: String,
    val email: String,
    @DrawableRes val avatar: Int
) {
    val fullName: String = "$firstName $lastName"
}