package android.pvt.moviefortheevening.entity

import java.io.Serializable

class FilmParams: Serializable {
    var genres: ArrayList<String> = arrayListOf()
    var rate: String = "7"
    var startYear: String = "1999"
    var endYear: String = "2019"

    fun genresString(): String{
        var string =""
        for (i in 1..genres.size){
            string += if (i==genres.size){
                genres[i-1]
            } else genres[i-1]+','
        }
        return string
    }
}