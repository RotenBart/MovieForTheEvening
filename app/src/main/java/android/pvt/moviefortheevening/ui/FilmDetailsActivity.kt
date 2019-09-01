package android.pvt.moviefortheevening.ui

import android.app.Activity
import android.os.Bundle
import android.pvt.moviefortheevening.R
import android.pvt.moviefortheevening.entity.Films
import android.pvt.moviefortheevening.mvvm.MVVMState
import android.pvt.moviefortheevening.mvvm.ViewModelFilms
import android.util.Log
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_details_film.*

class FilmDetailsActivity : FragmentActivity() {
    private val genreArray: ArrayList<String> = arrayListOf()
    private lateinit var viewModel: ViewModelFilms

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_film)

        viewModel = ViewModelProviders.of(this).get(ViewModelFilms::class.java)
        viewModel.load()

        viewModel.state.observe(this, Observer {
            when (it) {
                is MVVMState.Data -> {
                    addInform(it.films)

                }
            }
        })
    }

    fun addInform(films: Films){
        filmTitle.text = films.results[0].title
        filmYear.text = films.results[0].year
        filmDesc.text = films.results[0].desc
        filmIma
    }
    fun imageUrl(path: String) :String{
        return "https://image.tmdb.org/t/p/w342$path"
    }

}