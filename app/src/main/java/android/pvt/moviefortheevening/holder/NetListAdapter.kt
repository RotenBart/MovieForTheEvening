package android.pvt.moviefortheevening.holder

import android.pvt.moviefortheevening.R
import android.pvt.moviefortheevening.entity.Film
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class NetListAdapter(private val listener: OnClickListener) :
    RecyclerView.Adapter<FilmViewHolder>() {
    private var filmList: MutableList<Film> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_film, parent, false)
        val holder = FilmViewHolder(view)
        holder.itemView.setOnClickListener {
            listener.onItemClick(filmList[holder.adapterPosition])
        }
        return holder
    }

    fun setFilmList(filmList: MutableList<Film>) {
        this.filmList = filmList
        notifyDataSetChanged()
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