package com.example.kokoapplication
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
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
        val adapter = HomePagerAdapter(LayoutInflater.from(this@HomeActivity))
        view_pager.adapter = adapter
        view_pager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab_layout))


        tab_layout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                view_pager.currentItem = tab!!.position
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }
            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })

    }
}

class HomePagerAdapter(
    val layoutInflater: LayoutInflater

): PagerAdapter(){

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        when(position){
            0->{
                val view = layoutInflater.inflate(R.layout.activity_graph, container, false)
                container.addView(view)
                return view
            }
            1->{
                val view = layoutInflater.inflate(R.layout.activity_manage, container, false)
                container.addView(view)
                return view
            }
            2->{
                val view = layoutInflater.inflate(R.layout.activity_calendar, container, false)
                container.addView(view)
                return view
            }
            3->{
                val view = layoutInflater.inflate(R.layout.activity_my, container, false)
                container.addView(view)
                return view
            }
            else->{
                val view = layoutInflater.inflate(R.layout.activity_calendar, container, false)
                container.addView(view)
                return view
            }
        }
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun getCount(): Int {
        return 4
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as View

    }

}

