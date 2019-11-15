package android.pvt.moviefortheevening.ui

import android.content.Intent
import android.os.Bundle
import android.pvt.moviefortheevening.R
import android.pvt.moviefortheevening.entity.Film
import android.pvt.moviefortheevening.entity.FilmParams
import android.pvt.moviefortheevening.holder.NetListAdapter
import android.pvt.moviefortheevening.mvvm.MVVMState
import android.pvt.moviefortheevening.mvvm.ViewModelFilms
import android.util.Log
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class NetListActivity : FragmentActivity(), NetListAdapter.OnClickListener {

    private lateinit var filmParams: FilmParams
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_net)

        val adapter = NetListAdapter(this)
        filmParams = intent.getSerializableExtra("PARAMS") as FilmParams
        Log.e("PPP", filmParams.genres.toString())
        val viewModel = ViewModelProviders.of(this).get(ViewModelFilms::class.java)
        viewModel.load(filmParams)
        viewModel.state.observe(this, Observer {
            when (it) {
                is MVVMState.Data -> {
                    adapter.setFilmList(it.films.results)
                    Log.e("PPP", it.films.results[0].title)
                }
            }
        })
        initRecycler(adapter)
    }

    override fun onItemClick(item: Film) {
        val intent = Intent(this, FilmDetailsActivity::class.java)
        intent.putExtra("FILM", item)
        startActivity(intent)
    }

    private fun initRecycler(adapter: NetListAdapter) {
        val decoration = DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL)
        decoration.setDrawable(ContextCompat.getDrawable(this, R.color.colorGreen)!!)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.adapter = adapter
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(decoration)
        recyclerView.isNestedScrollingEnabled = false
    }
}