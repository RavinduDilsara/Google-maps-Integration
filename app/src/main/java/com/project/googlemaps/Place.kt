import com.google.android.gms.maps.model.LatLng


// Represents a Place object
data class Place(
    val name: String,
    val latLng: LatLng,
    val address: String,
    val rating: Float
)

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



// Represents the geometry object in the JSON
data class Geometry(
    val location: Location
)

// Represents the location object in the JSON
data class Location(
    val lat: Double,
    val lng: Double
)
