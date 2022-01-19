package com.example.kokoapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.kokoapplication.graph.GraphFragment
import com.example.kokoapplication.home.HomeFragment
import com.example.kokoapplication.manage.ManageFragment
import com.example.kokoapplication.mypage.MyPageFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class KoKoMain: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kokomain)

        val homeFragment = HomeFragment()
        val graphFragment = GraphFragment()
        val manageFragment = ManageFragment()
        val mypageFragment = MyPageFragment()


        val menuTab = findViewById<BottomNavigationView>(R.id.menuTab)

        replaceFragment(graphFragment)

        menuTab.setOnItemSelectedListener {
            when(it.itemId){
                R.id.graph -> replaceFragment(graphFragment)
                R.id.manage -> replaceFragment(manageFragment)
                R.id.home -> replaceFragment(homeFragment)
                R.id.mypage -> replaceFragment(mypageFragment)
            }
            true
        }

    }

    private fun replaceFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .apply {
                replace(R.id.fragmentContainer, fragment)
                commit()
            }
    }
}