package com.example.kokoapplication
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_activity)

        val tab_layout : TabLayout = findViewById(R.id.tab_layout)

        val grap: View = layoutInflater.inflate(R.layout.customtab, null)
        grap.findViewById<ImageView>(R.id.icon).setBackgroundResource(R.drawable.grap_tab)
        tab_layout.addTab(tab_layout.newTab().setCustomView(grap))

        val list: View = layoutInflater.inflate(R.layout.customtab, null)
        list.findViewById<ImageView>(R.id.icon).setBackgroundResource(R.drawable.list_tab)
        tab_layout.addTab(tab_layout.newTab().setCustomView(list))

        val home: View = layoutInflater.inflate(R.layout.customtab, null)
        home.findViewById<ImageView>(R.id.icon).setBackgroundResource(R.drawable.home_tab)
        tab_layout.addTab(tab_layout.newTab().setCustomView(home))

        val my: View = layoutInflater.inflate(R.layout.customtab, null)
        my.findViewById<ImageView>(R.id.icon).setBackgroundResource(R.drawable.my_tab)
        tab_layout.addTab(tab_layout.newTab().setCustomView(my))

        val view_pager : ViewPager = findViewById(R.id.view_pager)
        val pagerAdapter = HomePagerAdapter(supportFragmentManager, 4)
        view_pager.adapter = pagerAdapter

        tab_layout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                view_pager.currentItem = tab!!.position
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }
            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })
        view_pager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab_layout))
    }
}

class HomePagerAdapter(
    fragmentManager: FragmentManager,
    val tabCount: Int
): FragmentPagerAdapter(fragmentManager){
    override fun getCount(): Int {
        return tabCount
    }
    override fun getItem(position: Int): Fragment {
        when (position){
            0->{
                return GrapFragment()
            }
            1->{
                return ManageFragment()
            }
            2->{
                return HomeFragment()
            }
            3->{
                return MyFragment()
            }
            else->{
                return HomeFragment()
            }
        }
    }
}
