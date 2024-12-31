package com.project.googlemaps

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.MarkerOptions


class MainActivity : AppCompatActivity() {

    private val places: List<Place> by lazy {
        PlacesReader(this).read()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val mapFragment = supportFragmentManager.findFragmentById(
            R.id.map_fragment
        ) as? SupportMapFragment
        mapFragment?.getMapAsync { googleMap ->
            addMarkers(googleMap)
        }
    }

    private fun addMarkers(googleMap: GoogleMap) {
        places.forEach { place ->
            val marker = googleMap.addMarker(
                MarkerOptions()
                    .title(place.name)
                    .position(place.latLng)
            )
        }
    }
}
