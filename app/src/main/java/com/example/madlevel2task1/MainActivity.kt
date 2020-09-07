package com.example.madlevel2task1

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.madlevel2task1.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.item_place.view.*

class MainActivity : AppCompatActivity() {

    private val place = arrayListOf<Place>()
    private val placeAdapter = PlaceAdapter(place)
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews(){
        binding.rvPlaces.layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
        binding.rvPlaces.adapter = placeAdapter

        for (i in Place.PLACE_NAMES.indices) {
            place.add(Place(Place.PLACE_NAMES[i], Place.PLACE_RES_DRAWABLE_IDS[i]))
        }
        placeAdapter.notifyDataSetChanged()
    }

}