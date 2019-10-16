package com.example.aulajson

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonPropertyOrder
import org.json.JSONObject

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder(alphabetic = true)
data class Person(var name: String?,var age: Int?, var gender: String?) {

    constructor(jsonObject: JSONObject) :
            this(
                jsonObject.getString("name"),
                jsonObject.getInt("age"),
                jsonObject.getString("gender")
            )
}