package com.andersonk.androidcourse.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.andersonk.androidcourse.R
import com.andersonk.androidcourse.adapters.PlanetAdapter
import com.andersonk.androidcourse.models.Results
import com.andersonk.androidcourse.services.Api
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.planet_fragment.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

class planetFragment : Fragment (){

    lateinit var planetAdapter: PlanetAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        var view = inflater.inflate(R.layout.planet_fragment,container,false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        planetAdapter = PlanetAdapter()

        val layoutManager = LinearLayoutManager(context)

        recycle_planets.layoutManager = layoutManager
        recycle_planets.adapter = planetAdapter

        getData()
    }

    private fun getData(){

        val retrofit = Retrofit.Builder()
            .baseUrl("https://swapi.co/api/")
            .addConverterFactory(JacksonConverterFactory.create())
            .build()

        val service = retrofit.create<Api>(Api::class.java)

        val call = service.getPlanets(

        )

        call.enqueue(object : Callback<Results> {
            override fun onFailure(call: Call<Results>, t: Throwable) {
                Log.d("NETWORK", t.toString())
            }

            override fun onResponse(call: Call<Results>, response: Response<Results>) {
                when(response.code()){
                    200 -> {
                        val body = response.body()
                        body?.let{
                            planetAdapter.setplanets(it.results)
                        }
                    }
                    204 -> Log.d("NETWORK","Not content")
                }
            }

        })
    }
}