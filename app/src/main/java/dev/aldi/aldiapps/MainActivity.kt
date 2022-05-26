package dev.aldi.aldiapps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    private lateinit var prefManager: PrefManager
    private lateinit var layouts: List<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        prefManager = PrefManager(this)
        if (prefManager.firstTime) {
            startWalkthrough()
        } else {
            startHomeActivity()
        }
    }
    
    private fun startWalkthrough () {
        setContentView(R.layout.walkthrough)
        layouts = listOf(R.layout.walkthrough1, R.layout.walkthrough2, R.layout.walkthrough3)

        val viewPager: ViewPager = findViewById(R.id.view_pager)
        val tabLayout: TabLayout = findViewById(R.id.tabDots)
        val myViewPagerAdapter = ViewPagerAdapterWalkthrough(this, layouts)
        viewPager.adapter = myViewPagerAdapter
        tabLayout.setupWithViewPager(viewPager)
    }

    fun startHomeActivity () {
        prefManager.firstTime = false
        startActivity(Intent(this, HomeActivity::class.java))
    }
}





