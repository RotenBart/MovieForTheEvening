package android.pvt.moviefortheevening.ui

import android.os.Bundle
import android.pvt.moviefortheevening.IMG_URL
import android.pvt.moviefortheevening.R
import android.pvt.moviefortheevening.entity.Film
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import coil.api.load
import kotlinx.android.synthetic.main.activity_details_film.*

class FilmDetailsActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_film)

        val film = intent.getParcelableExtra("FILM") as Film
        Log.e("PPP", film.title)
        addInform(film)

        backButton.setOnClickListener {
            onBackPressed()
        }
        addToListButton.setOnClickListener {
            Toast.makeText(this, "Функционал локального списка в разработке", Toast.LENGTH_SHORT).show()
        }
    }

    fun addInform(film: Film) {
        // val i = (0..films.results.size).random()
        filmTitle.text = film.title
        filmYear.text = film.year
        filmDesc.text = film.desc
        filmRate.text = film.rate.toString()

        val filmImage = filmImage
        filmImage.load(IMG_URL.plus(film.image))
    }
}