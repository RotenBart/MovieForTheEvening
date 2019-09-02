package android.pvt.moviefortheevening

import android.pvt.moviefortheevening.repository.Api
import android.pvt.moviefortheevening.repository.FilmRepositoryRemote
import android.pvt.moviefortheevening.repository.NetProvider
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test

class Test {
    var server = MockWebServer()
    private lateinit var api: Api

    @Before
    fun before() {
        server.start()
        val httpUrl = server.url("/")
        val retrofit =
            NetProvider.provideRetrofit(httpUrl.toString(), NetProvider.provideOkHttp(), NetProvider.provideGson())
        api = NetProvider.provideApi(retrofit)
    }

    @After
    fun after() {
        server.shutdown()
    }

    @Test
    fun testSuccessResponseFilmRepositoryRemote() {
        val repository = FilmRepositoryRemote(api)
        val mockResponse = MockResponse()
        mockResponse.setResponseCode(200)
        mockResponse.setBody(SUCCESS_RESPONSE)
        server.enqueue(mockResponse)

        val filmTitle = "Бэтмен: Начало"
        val testObserver = repository.getFilms(API_KEY, "ru_RU", "1", "18", 7F, "1990-01-01", "2010-01-01").test()

        testObserver.assertValue {
            it.results[0].title.equals(filmTitle)
        }
    }

    @Test
    fun testFailResponseFilmRepositoryRemote() {
        val repository = FilmRepositoryRemote(api)
        val mockResponse = MockResponse()
        mockResponse.setResponseCode(403)
        mockResponse.setBody(FAIL_RESPONSE)
        server.enqueue(mockResponse)

        val testObserver = repository.getFilms(API_KEY, "ru_RU", "1", "18", 7F, "2010-01-01", "1990-01-01").test()

        testObserver.assertError {
            it is Exception
        }
    }
}