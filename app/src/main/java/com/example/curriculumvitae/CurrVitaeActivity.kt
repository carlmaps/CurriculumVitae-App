package com.example.curriculumvitae

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
//import android.widget.Toolbar
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout

class CurrVitaeActivity : AppCompatActivity() {
    lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager2
    lateinit var bar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_curr_vitae)

        val username = intent.getStringExtra("username")
        val bundle = Bundle()
        bundle.putString("username", username)

        tabLayout = findViewById(R.id.tabLayout)
        viewPager = findViewById(R.id.vwPager)
        bar = findViewById(R.id.toolbar)

        setSupportActionBar(bar)

        tabLayout.addTab(tabLayout.newTab().setText("Home"))
        tabLayout.addTab(tabLayout.newTab().setText("About"))
        tabLayout.addTab(tabLayout.newTab().setText("Work"))
        tabLayout.addTab(tabLayout.newTab().setText("Contacts"))

        val fragmentManager = supportFragmentManager
        val fragAdapter = FragmentAdapter(fragmentManager, lifecycle, bundle)


        viewPager.adapter = fragAdapter


        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                viewPager.currentItem = tab?.position!!
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }
            override fun onTabReselected(tab: TabLayout.Tab?) {}

        })
        viewPager.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                tabLayout.selectTab(tabLayout.getTabAt(position))
            }
        })

    }


}