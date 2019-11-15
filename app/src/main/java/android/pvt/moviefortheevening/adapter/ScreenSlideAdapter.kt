package android.pvt.moviefortheevening.adapter

import android.pvt.moviefortheevening.entity.Films
import android.pvt.moviefortheevening.ui.FilmDetailsFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class ScreenSlideAdapter(fm: FragmentManager, private val films: Films) :
    FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getCount(): Int {
        return films.results.size
    }

    override fun getItem(position: Int): Fragment {
        val film = when {
            films.results.isNotEmpty() && position <= count - 1 -> films.results[position]
            else -> null
        }
        return film.run { FilmDetailsFragment.newInstance(this) }
    }
}