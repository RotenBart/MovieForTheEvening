package android.pvt.moviefortheevening.repository

import android.pvt.moviefortheevening.entity.Films
import io.reactivex.Single

class FilmRepositoryRemote(private val api: Api) : FilmRepository {
    override fun getFilms(
        apiKey: String,
        language: String,
        page: String,
        idGenre: String,
        rate: Float,
        gteYear: String,
        lteYear: String
    ): Single<Films> {
        return api.getFilms(apiKey, language, page, idGenre, rate, gteYear, lteYear)
    }
}