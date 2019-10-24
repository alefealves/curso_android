package com.andersonk.androidcourse.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class BadgeCounts(
    val bronze: Int? = null,
    val gold: Int? = null,
    val silver: Int? = null
)