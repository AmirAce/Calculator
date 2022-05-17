package demoweek8.cis2818.demoweek8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cis2818.demoweek8.R

class MainActivity : AppCompatActivity(),BottomFragment.CalculatorListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun setDisplay() {
        var topFrag = supportFragmentManager.findFragmentById(R.id.fragmentTop) as TopFragment
        topFrag.changeDisplay()
    }


}