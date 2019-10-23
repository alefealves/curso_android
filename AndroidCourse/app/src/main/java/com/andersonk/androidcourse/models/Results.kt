package com.andersonk.androidcourse.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Results(
    val results: MutableList<Planet> = mutableListOf()
)