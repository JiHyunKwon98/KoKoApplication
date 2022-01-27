package com.example.kokoapplication.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.kokoapplication.R
import com.example.kokoapplication.databinding.FragmentHomeBinding
import java.util.*
import androidx.fragment.app.FragmentTransaction


class HomeFragment : Fragment(R.layout.fragment_home) {

    private var binding: FragmentHomeBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fragmentHomeBinding = FragmentHomeBinding.bind(view)
        binding = fragmentHomeBinding

        val minDate = Calendar.getInstance()
        val maxDate = Calendar.getInstance()
        minDate.set(2020, 1 - 1, 1);
        maxDate.set(2024, 1 - 1, 1);

        fragmentHomeBinding.datePicker1.setMinDate(minDate.getTime().getTime());
        fragmentHomeBinding.datePicker1.setMaxDate(maxDate.getTimeInMillis());

        fragmentHomeBinding.changeweek.setOnClickListener{
            val transaction: FragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
            val doItFragment = DoItFragment()
            transaction.replace(R.id.fragmentContainer, doItFragment)
            transaction.commit()
        }


        /*
        val tvw : TextView = findViewById(R.id.textView1)
        val btnGet : Button = findViewById(R.id.button1)

        btnGet.setOnClickListener {
        tvw.setText("Selected Date: "+ picker.getDayOfMonth()+"/"+ (picker.getMonth() + 1)+"/"+picker.getYear());
        }
        */


    }


}

