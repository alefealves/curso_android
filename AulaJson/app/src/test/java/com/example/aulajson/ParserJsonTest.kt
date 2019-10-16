package com.example.aulajson

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.json.JSONArray
import org.json.JSONObject
import org.junit.Test

class ParserJsonTest {

    @Test
    fun test_jsonObject() {
        val jsonString = """
                         {
                            "name" : "Fulano",
                            "age" : 23,
                            "gender" : "Male",
                            "is_active" : false
                         }
                         """
        val jsonObject = JSONObject(jsonString)

        val person = Person(jsonObject)
        //print("Name is ${jsonObject.getString("name")}")
        print("Name is ${person.name}")

    }

    @Test
    fun test_arrayObject(){
        val jsonString = """
                         [
                             {
                                "name" : "Fulano",
                                "age" : 23,
                                "gender" : "Male",
                                "is_active" : false
                             },
                             {
                                "name" : "Beltrano",
                                "age" : 23,
                                "gender" : "Male",
                                "is_active" : false
                             },
                             {
                                "name" : "Ciclano",
                                "age" : 23,
                                "gender" : "Male",
                                "is_active" : false
                             },
                         ]
                         
                         """

        val jsonArray = JSONArray(jsonString)

        for (index in 0 until jsonArray.length()){
            println(jsonArray.getJSONObject(index))
        }

    }

    @Test
    fun whenSerializePerson_thenSucess(){
        val mapper = jacksonObjectMapper()

        val person = Person("Ciclano",23,"M")

        val valueAsString = mapper.writeValueAsString(person)

        print("Person is ${valueAsString}")
    }

    @Test
    fun whenDeserializePerson_thenSucess(){

        val mapper = jacksonObjectMapper()

        val jsonString = """
                         {
                            "name" : "Fulano",
                            "age" : 23,
                            "gender" : "Male",
                            "is_active" : false
                         }
                         """

        val readValue = mapper.readValue<Person>(jsonString)
        print(readValue.name)
    }
}