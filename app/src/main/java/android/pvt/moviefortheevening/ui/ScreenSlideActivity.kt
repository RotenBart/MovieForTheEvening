package android.pvt.moviefortheevening.ui

import android.os.Bundle
import android.os.PersistableBundle
import android.pvt.moviefortheevening.R
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_slide_screen.*

class ScreenSlideActivity : FragmentActivity() {

    private lateinit var pager: ViewPager
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_slide_screen)

        pager = viewPager
        val pagerAdapter = ScreenSlideAdapter(supportFragmentManager)
        pager.adapter = pagerAdapter
    }

    override fun onBackPressed() {
        if (pager.currentItem == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed()
        } else {
            // Otherwise, select the previous step.
            pager.currentItem = pager.currentItem - 1
        }
    }

    class ScreenSlideAdapter(fm: FragmentManager) :
        FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

        override fun getCount(): Int {
            return 5
        }

        override fun getItem(position: Int): Fragment {
            return FilmDetailsFragment()
        }
    }
}