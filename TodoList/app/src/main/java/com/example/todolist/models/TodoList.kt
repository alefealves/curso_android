package com.example.todolist.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TodoList (var id : Int?, var descricao : String?, var status : Boolean?) : Parcelable