package android.pvt.moviefortheevening.repository

fun provideFilmRepository(): FilmRepositoryRemote {
    return FilmRepositoryRemote(
        NetProvider.provideApi(
            NetProvider.provideRetrofit(
                "https://api.themoviedb.org/3/",
                NetProvider.provideOkHttp(),
                NetProvider.provideGson()
            )
        )
    )
}