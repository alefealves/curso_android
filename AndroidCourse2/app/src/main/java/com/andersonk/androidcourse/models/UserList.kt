package com.andersonk.androidcourse.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class UserList(
    val users: MutableList<User> = mutableListOf()
)