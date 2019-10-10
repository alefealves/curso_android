package com.example.myapplication.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User (var userName : String?, var userPass : String?) : Parcelable