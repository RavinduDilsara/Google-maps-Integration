package com.project.googlemaps

import Place
import com.google.android.gms.maps.model.LatLng

// Represents the response from the JSON
data class PlaceResponse(
    val geometry: Geometry,
    val name: String,
    val vicinity: String,
    val rating: Float
) {
    fun toPlace(): Place {
        return Place(
            name = this.name,
            latLng = LatLng(this.geometry.location.lat, this.geometry.location.lng),
            address = this.vicinity,
            rating = this.rating
        )
    }
}
