package android.pvt.moviefortheevening.holder

import android.pvt.moviefortheevening.R
import android.pvt.moviefortheevening.entity.Film
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class NetListAdapter(private var filmList: MutableList<Film>, private val listener: OnClickListener) :
    RecyclerView.Adapter<FilmViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_film, parent, false)
        val holder = FilmViewHolder(view)
        holder.itemView.setOnClickListener {
            listener.onItemClick(filmList[holder.adapterPosition])
        }
        return holder
    }

    override fun getItemCount(): Int {
        return filmList.size
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        holder.bind(filmList[position])
    }

    interface OnClickListener {
        fun onItemClick(item: Film)
    }
}