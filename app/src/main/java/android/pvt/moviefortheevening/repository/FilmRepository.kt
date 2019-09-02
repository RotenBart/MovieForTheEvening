package android.pvt.moviefortheevening.repository

import android.pvt.moviefortheevening.entity.Films
import io.reactivex.Single

interface FilmRepository {
    fun getFilms(apiKey: String,language:String, page:String,
                 idGenre:String,rate:Float,gteYear:String, lteYear:String): Single<Films>
}
