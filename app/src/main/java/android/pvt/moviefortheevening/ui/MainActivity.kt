package android.pvt.moviefortheevening.ui


import android.content.Intent
import android.os.Bundle
import android.pvt.moviefortheevening.R
import android.pvt.moviefortheevening.mvvm.ViewModelFilms
import androidx.fragment.app.FragmentActivity


import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : FragmentActivity(){
    private lateinit var viewModel:ViewModelFilms

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonNet.setOnClickListener {
            val intent = Intent(this, NetSearchActivity::class.java)
            startActivity(intent)
        }
    }

}