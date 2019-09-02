package android.pvt.moviefortheevening.ui

import android.app.Activity
import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.pvt.moviefortheevening.R
import android.pvt.moviefortheevening.entity.FilmParams
import android.pvt.moviefortheevening.entity.Films
import android.pvt.moviefortheevening.mvvm.MVVMState
import android.pvt.moviefortheevening.mvvm.ViewModelFilms
import android.pvt.moviefortheevening.utils.loadImage
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
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
        val filmParams = intent.getSerializableExtra("PARAMS") as? FilmParams
        Log.e("PPP",filmParams?.genres.toString())
        viewModel = ViewModelProviders.of(this).get(ViewModelFilms::class.java)
        if (filmParams != null) {
            viewModel.load(filmParams)
        }

        viewModel.state.observe(this, Observer {
            when (it) {
                is MVVMState.Data -> {
                    addInform(it.films)
                    Log.e("PPP",it.films.results[0].title)
                }
            }
        })
        backButton.setOnClickListener {
            val intent = Intent (this, NetSearchActivity::class.java)
            startActivity(intent)
        }
        addToListButton.setOnClickListener{
            Toast.makeText(this, "Функционал локального списка в разработке", Toast.LENGTH_SHORT).show()
        }
    }

    fun addInform(films: Films){
        filmTitle.text = films.results[0].title
        filmYear.text = films.results[0].year
        filmDesc.text = films.results[0].desc
        filmRate.text = films.results[0].rate.toString()

        val filmImage = findViewById<ImageView>(R.id.filmImage)
        loadImage(this, imageUrl(films.results[0].image),filmImage)
    }
    fun imageUrl(path: String) :String{
        return "https://image.tmdb.org/t/p/w342$path"
    }

}