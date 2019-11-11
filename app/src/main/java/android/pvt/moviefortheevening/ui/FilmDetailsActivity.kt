package android.pvt.moviefortheevening.ui

import android.content.Intent
import android.os.Bundle
import android.pvt.moviefortheevening.IMG_URL
import android.pvt.moviefortheevening.R
import android.pvt.moviefortheevening.entity.FilmParams
import android.pvt.moviefortheevening.entity.Films
import android.pvt.moviefortheevening.mvvm.MVVMState
import android.pvt.moviefortheevening.mvvm.ViewModelFilms
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import coil.api.load
import kotlinx.android.synthetic.main.activity_details_film.*

class FilmDetailsActivity : FragmentActivity() {

    private lateinit var viewModel: ViewModelFilms

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_film)

        val filmParams = intent.getSerializableExtra("PARAMS") as? FilmParams
        Log.e("PPP", filmParams?.genres.toString())
        viewModel = ViewModelProviders.of(this).get(ViewModelFilms::class.java)
        if (filmParams != null) {
            viewModel.load(filmParams)
        }

        viewModel.state.observe(this, Observer {
            when (it) {
                is MVVMState.Data -> {
                    addInform(it.films)
                    Log.e("PPP", it.films.results[0].title)
                }
            }
        })
        backButton.setOnClickListener {
            val intent = Intent(this, NetSearchActivity::class.java)
            startActivity(intent)
        }
        addToListButton.setOnClickListener {
            Toast.makeText(this, "Функционал локального списка в разработке", Toast.LENGTH_SHORT).show()
        }
    }

    fun addInform(films: Films) {
        val i = (0..films.results.size).random()
        filmTitle.text = films.results[i].title
        filmYear.text = films.results[i].year
        filmDesc.text = films.results[i].desc
        filmRate.text = films.results[i].rate.toString()

        val filmImage = filmImage
        filmImage.load(IMG_URL.plus(films.results[i].image))
    }
}