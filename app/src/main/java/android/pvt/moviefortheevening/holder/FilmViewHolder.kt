package android.pvt.moviefortheevening.holder

import android.pvt.moviefortheevening.IMG_URL
import android.pvt.moviefortheevening.R
import android.pvt.moviefortheevening.entity.Film
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.api.load

class FilmViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val filmImage: ImageView = itemView.findViewById(R.id.filmImage)
    private val filmTitle: TextView = itemView.findViewById(R.id.filmTitle)
    private val filmYear: TextView = itemView.findViewById(R.id.filmYear)
    private val filmRate: TextView = itemView.findViewById(R.id.filmRate)
    private val filmDesc: TextView = itemView.findViewById(R.id.filmDesc)
    fun bind(film: Film) {
        filmImage.load(IMG_URL.plus(film.image))
        filmTitle.text = film.title
        filmYear.text = film.year
        filmRate.text = film.rate.toString()
        filmDesc.text = film.desc
    }
}