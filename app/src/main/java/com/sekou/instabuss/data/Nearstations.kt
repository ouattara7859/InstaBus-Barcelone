import com.google.gson.annotations.SerializedName

data class Nearstations (

	@SerializedName("id") val id : Int,
	@SerializedName("street_name") val street_name : String,
	@SerializedName("city") val city : String,
	@SerializedName("utm_x") val utm_x : String,
	@SerializedName("utm_y") val utm_y : String,
	@SerializedName("lat") val lat : Double,
	@SerializedName("lon") val lon : Double,
	@SerializedName("furniture") val furniture : String,
	@SerializedName("buses") val buses : String,
	@SerializedName("distance") val distance : Float
)