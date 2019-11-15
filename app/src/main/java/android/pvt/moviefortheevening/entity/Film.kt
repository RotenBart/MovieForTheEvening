package android.pvt.moviefortheevening.entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
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
) : Parcelable