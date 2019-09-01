package android.pvt.moviefortheevening.entity

import com.google.gson.annotations.SerializedName

data class Film(
    @SerializedName("title")
    val title: String,
    @SerializedName("release_date")
    val year: String,
    @SerializedName("vote_average")
    val rate: Float,
    @SerializedName("overview")
    val desc: String,
    @SerializedName("poster_path")
    val image: String
)