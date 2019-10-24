package com.andersonk.androidcourse.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class User(
    val accept_rate: Int? = null,
    val account_id: Int? = null,
    val badge_counts: BadgeCounts? = null,
    val creation_date: Int? = null,
    val display_name: String? = null,
    val is_employee: Boolean? = null,
    val last_access_date: Int? = null,
    val last_modified_date: Int? = null,
    val link: String? = null,
    val location: String? = null,
    val profile_image: String? = null,
    val reputation: Int? = null,
    val reputation_change_day: Int? = null,
    val reputation_change_month: Int? = null,
    val reputation_change_quarter: Int? = null,
    val reputation_change_week: Int? = null,
    val reputation_change_year: Int? = null,
    val user_id: Int? = null,
    val user_type: String? = null,
    val website_url: String? = null
)