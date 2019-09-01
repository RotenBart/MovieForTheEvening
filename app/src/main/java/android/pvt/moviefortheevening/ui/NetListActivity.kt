package android.pvt.moviefortheevening.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.pvt.moviefortheevening.R
import android.pvt.moviefortheevening.entity.Film
import android.pvt.moviefortheevening.holder.NetListAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class NetListActivity : Activity(), NetListAdapter.OnClickListener {

    private lateinit var adapter: NetListAdapter
    private lateinit var filmList: MutableList<Film>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_net)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.isNestedScrollingEnabled = false
        adapter = NetListAdapter(filmList, this)
        recyclerView.adapter = adapter
    }

    override fun onItemClick(item: Film) {
        val intent = Intent(this, FilmDetailsActivity::class.java)
        intent.putExtra("title", item.title)
        startActivity(intent)
    }
}