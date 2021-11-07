package com.example.cocinamos

//import androidx.viewpager2.widget.ViewPager2

import com.example.cocinamos.R
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayout.TabLayoutOnPageChangeListener


class AddRecipe : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_recipe)
        val toolbar: Toolbar = findViewById<View>(R.id.add_recipe_tool_bar) as Toolbar
        setSupportActionBar(toolbar)
        val tabLayout = findViewById<View>(R.id.add_recipe_tab_layout) as TabLayout
        tabLayout.addTab(tabLayout.newTab().setText(resources.getString(R.string.titleOverview)))
        tabLayout.addTab(tabLayout.newTab().setText(resources.getString(R.string.titleHowTo)))
        tabLayout.addTab(tabLayout.newTab().setText(resources.getString(R.string.titleComment)))
        tabLayout.tabGravity = TabLayout.GRAVITY_FILL
        val viewPager = findViewById<View>(R.id.view_pager) as ViewPager
        val tabsAdapter = TabsAdapter(supportFragmentManager, tabLayout.tabCount)
        viewPager.adapter = tabsAdapter
        viewPager.addOnPageChangeListener(TabLayoutOnPageChangeListener(tabLayout))
        tabLayout.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }
}