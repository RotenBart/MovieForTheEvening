package android.pvt.moviefortheevening.entity

data class FilmParams (
    val genre: Genre = Genre(),
    var rate: String = "7",
    var startYear: String = "1999",
    var endYear: String = "2019"
)