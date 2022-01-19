package com.example.kokoapplication.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.kokoapplication.InputGoal
import com.example.kokoapplication.R
import com.example.kokoapplication.databinding.FragmentWeekdayDoBinding

class DoItFragment : Fragment(R.layout.fragment_weekday_do) {

    private var binding: FragmentWeekdayDoBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fragmentWeekdayDoBinding = FragmentWeekdayDoBinding.bind(view)
        binding = fragmentWeekdayDoBinding

        fragmentWeekdayDoBinding.changemonth.setOnClickListener{
            val transaction: FragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
            val homeFragment = HomeFragment()
            transaction.replace(R.id.fragmentContainer, homeFragment)
            transaction.commit()
        }

        fragmentWeekdayDoBinding.today.setOnClickListener{
            // Dialog만들기
            val mDialogView = LayoutInflater.from(context).inflate(R.layout.today_dialog, null)
            val mBuilder = AlertDialog.Builder( requireContext()).setView(mDialogView)
            val  mAlertDialog = mBuilder.show()
            val noButton = mDialogView.findViewById<Button>(R.id.closeButton)
            noButton.setOnClickListener {
                mAlertDialog.dismiss()
            }
            val exercise1 = mDialogView.findViewById<CheckBox>(R.id.exercise1)
            val finish = mDialogView.findViewById<TextView>(R.id.finish)

            exercise1.setOnCheckedChangeListener{compoundButton, b ->
                if(b)
                    finish.text = "완료!"
                else
                    finish.text = " "
            }
        }

        fragmentWeekdayDoBinding.input.setOnClickListener{
            val intent = Intent(requireContext(), InputGoal::class.java)
            startActivity(intent)
        }

    }
}