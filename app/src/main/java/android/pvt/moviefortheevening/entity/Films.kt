package android.pvt.moviefortheevening.entity

import com.google.gson.annotations.SerializedName

data class Films (
    @SerializedName ("results")
    var results: MutableList<Film> = mutableListOf()
)