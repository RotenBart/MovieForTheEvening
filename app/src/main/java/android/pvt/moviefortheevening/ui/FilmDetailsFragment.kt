package android.pvt.moviefortheevening.ui

import android.os.Bundle
import android.pvt.moviefortheevening.IMG_URL
import android.pvt.moviefortheevening.R
import android.pvt.moviefortheevening.entity.Film
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import coil.api.load
import kotlinx.android.synthetic.main.fragment_details_film.view.*

class FilmDetailsFragment : Fragment() {

    companion object {

        private const val FILM = "FILM"

        fun newInstance(film: Film?): FilmDetailsFragment {
            val fragment = FilmDetailsFragment()
            val bundle = Bundle()
            bundle.putParcelable(FILM, film)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        inflater.inflate(
            R.layout.fragment_details_film, container, false
        )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getParcelable<Film>(FILM)?.run {
            view.filmImage.load(IMG_URL.plus(image))
            view.filmTitle.text = title
            view.filmDesc.text = desc
            view.filmYear.text = year
            view.filmRate.text = rate.toString()
        }
    }
}