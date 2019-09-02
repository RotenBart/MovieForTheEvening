package android.pvt.moviefortheevening.ui

import android.content.Intent
import android.os.Bundle
import android.pvt.moviefortheevening.R
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonNet.setOnClickListener {
            val intent = Intent(this, NetSearchActivity::class.java)
            startActivity(intent)
        }
        buttonLocal.setOnClickListener {
            Toast.makeText(this, "Функционал локального списка в разработке", Toast.LENGTH_SHORT).show()
        }
    }
}