package android.pvt.moviefortheevening.ui

import android.content.Intent
import android.os.Bundle
import android.pvt.moviefortheevening.R
import android.pvt.moviefortheevening.entity.FilmParams
import android.pvt.moviefortheevening.entity.Genre
import android.util.Log
import android.widget.SeekBar
import androidx.fragment.app.FragmentActivity
import kotlinx.android.synthetic.main.activity_search_net.*

class NetSearchActivity : FragmentActivity(), SeekBar.OnSeekBarChangeListener {


    private val genreArray: ArrayList<String> = arrayListOf()
    val genres = Genre()
    var filmParams: FilmParams = FilmParams()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_net)
        randomButton.setOnClickListener {
            setCheckBox()
            setSeekBarData()
            Log.e("QQQ", filmParams.toString())
            Log.e("QQQ", genreArray.toString())
            val intent = Intent(this, FilmDetailsActivity::class.java)
            intent.putExtra("ID", genreArray)
            startActivity(intent)
        }
        rateSeekBar.setOnSeekBarChangeListener(this)
        startYearSeekBar.setOnSeekBarChangeListener(this)
        endYearSeekBar.setOnSeekBarChangeListener(this)
        textRateSeekBar.text = filmParams.rate
        textStartYearSeekBar.text = filmParams.startYear
        textEndYearSeekBar.text = filmParams.endYear
        Log.e("QQQ", filmParams.toString())

    }

    override fun onProgressChanged(seekbar: SeekBar?, p1: Int, p2: Boolean) {
        updateSeekBarText()
    }
    override fun onStartTrackingTouch(seekbar: SeekBar?) {

    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {

    }

    fun setCheckBox(){
        if (comedyCheckbox.isChecked) {
            genreArray.add(genres.genres["Comedy"].toString())
        }
        if (actionCheckbox.isChecked) {
            genreArray.add(genres.genres["Action"].toString())
        }
        if (dramaCheckbox.isChecked) {
            genreArray.add(genres.genres["Drama"].toString())
        }
        if (fantasyCheckbox.isChecked) {
            genreArray.add(genres.genres["Fantasy"].toString())
        }
        if (horrorCheckbox.isChecked) {
            genreArray.add(genres.genres["Horror"].toString())
        }
        if (animationCheckbox.isChecked) {
            genreArray.add(genres.genres["Animation"].toString())
        }
    }
    fun updateSeekBarText(){
        textRateSeekBar.text = rateSeekBar.progress.toString()
        textStartYearSeekBar.text = startYearSeekBar.progress.toString()
        textEndYearSeekBar.text = endYearSeekBar.progress.toString()
    }
    fun setSeekBarData(){
        filmParams.rate = rateSeekBar.progress.toString()
        filmParams.startYear = startYearSeekBar.progress.toString()
        filmParams.endYear = endYearSeekBar.progress.toString()
    }
}

