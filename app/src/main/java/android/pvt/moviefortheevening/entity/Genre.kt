package android.pvt.moviefortheevening.entity

data class Genre(
    val genres: HashMap<String, String> = hashMapOf(
        "Comedy" to "35",
        "Action" to "28",
        "Drama" to "18",
        "Fantasy" to "14",
        "Horror" to "27",
        "Animation" to "16"
    )
)