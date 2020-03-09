import com.google.gson.annotations.SerializedName

data class Data (

	@SerializedName("nearstations") val nearstations : List<Nearstations>,
	@SerializedName("transport") val transport : String
)