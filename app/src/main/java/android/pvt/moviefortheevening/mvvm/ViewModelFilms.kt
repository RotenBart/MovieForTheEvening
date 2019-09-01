package android.pvt.moviefortheevening.mvvm

import android.pvt.moviefortheevening.API_KEY
import android.pvt.moviefortheevening.entity.Films
import android.pvt.moviefortheevening.repository.provideFilmRepository
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class ViewModelFilms:ViewModel() {

    private var disposable: Disposable? = null
    private val repository = provideFilmRepository()

    val state : MutableLiveData<MVVMState> by lazy(LazyThreadSafetyMode.NONE){
        MutableLiveData<MVVMState>()
    }

    fun load() {
        disposable = repository.getFilms(API_KEY, "ru-RU", "1", "18,16", "7", "2015", "2010")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { data ->
                state.value = MVVMState.Data(data)
            }
    }
}