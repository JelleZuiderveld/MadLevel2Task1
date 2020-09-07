package com.example.madlevel2task1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.example.madlevel2task1.databinding.ItemPlaceBinding

public class PlaceAdapter(private val places: List<Place>) : RecyclerView.Adapter<PlaceAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_place, parent, false)
        )
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val binding = ItemPlaceBinding.bind(itemView)

        fun databind(place: Place){
            binding.textPlace.text = place.name
            binding.imagePlace.setImageResource(place.imageResId)
        }

    }

    override fun getItemCount(): Int {
        return places.size
    }

    override fun onBindViewHolder(holder: PlaceAdapter.ViewHolder, position: Int) {
        holder.databind(places[position])
    }

}