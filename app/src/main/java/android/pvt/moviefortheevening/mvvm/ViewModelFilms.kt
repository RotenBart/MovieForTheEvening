package android.pvt.moviefortheevening.mvvm

import android.pvt.moviefortheevening.API_KEY
import android.pvt.moviefortheevening.entity.FilmParams
import android.pvt.moviefortheevening.repository.provideFilmRepository
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class ViewModelFilms : ViewModel() {

    private var disposable: Disposable? = null
    private val repository = provideFilmRepository()

    val state: MutableLiveData<MVVMState> by lazy(LazyThreadSafetyMode.NONE) {
        MutableLiveData<MVVMState>()
    }

    fun load(filmParams: FilmParams) {
        val genres = filmParams.genresString()
        val rate = filmParams.rate.toFloat()
        val gteYear = filmParams.startYear + "-01-01"
        val lteYear = filmParams.endYear + "-01-01"
        disposable = repository.getFilms(API_KEY, "ru-RU", "1", genres, rate, gteYear, lteYear)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { data ->
                state.value = MVVMState.Data(data)
            }
    }
}