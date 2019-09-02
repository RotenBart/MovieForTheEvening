package android.pvt.moviefortheevening.repository

import android.pvt.moviefortheevening.entity.Films
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("discover/movie")
    fun getFilms(
        @Query("api_key") apiKey:String,
        @Query("language") language:String,
        @Query("page") page:String,
        @Query("with_genres") idGenre:String,
        @Query("vote_average.gte") rate:Float,
        @Query("primary_release_date.gte") gteYear:String,
        @Query("primary_release_date.lte") lteYear:String
    ):Single<Films>
}