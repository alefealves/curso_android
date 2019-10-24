package com.andersonk.androidcourse.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.andersonk.androidcourse.R
import com.andersonk.androidcourse.models.Planet
import com.andersonk.androidcourse.models.Results
import kotlinx.android.synthetic.main.planet_item.view.*

class PlanetAdapter : RecyclerView.Adapter<PlanetAdapter.PlanetHolder>(){

    val planets = mutableListOf<Planet>()

    fun setplanets(planets: MutableList<Planet>){
        this.planets.addAll(planets)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanetHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.planet_item, parent, false)
        return PlanetHolder(view)
    }

    override fun getItemCount(): Int {
        return planets.size
    }

    override fun onBindViewHolder(holder: PlanetHolder, position: Int) {
        val planets = planets[position]
        holder.setPlanet(planets)
    }

    class PlanetHolder(private val view : View) : RecyclerView.ViewHolder(view) {
        fun setPlanet(planet : Planet){
            view.name.text = planet.climate
        }
    }
}