package com.example.kokoapplication.home

import android.content.Intent
import android.os.Build

import android.os.Bundle
import android.text.format.DateFormat.is24HourFormat
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kokoapplication.InputGoal
import com.example.kokoapplication.R
import com.example.kokoapplication.databinding.FragmentWeekdayDoBinding
import org.threeten.bp.DayOfWeek
import org.threeten.bp.LocalDateTime
import org.threeten.bp.format.DateTimeFormatter
import org.threeten.bp.temporal.TemporalAdjusters
import java.text.SimpleDateFormat
import java.util.*

class DoItFragment : Fragment(R.layout.fragment_weekday_do) {

    private var binding: FragmentWeekdayDoBinding? = null

    lateinit var calendarAdapter: CalendarAdapter
    private var calendarList = ArrayList<CalendarVO>()

/*    private val sdf = SimpleDateFormat("MMMM yyyy", Locale.KOREA)
    private val cal = Calendar.getInstance(Locale.KOREA)
    private val currentDate = Calendar.getInstance(Locale.KOREA)
    private val dates = ArrayList<Date>()*/

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // View binding
        val fragmentWeekdayDoBinding = FragmentWeekdayDoBinding.bind(view)
        binding = fragmentWeekdayDoBinding

        // Fragment-> Fragment 화면 전환 function
        fragmentWeekdayDoBinding.changemonth.setOnClickListener {
            val transaction: FragmentTransaction =
                requireActivity().supportFragmentManager.beginTransaction()
            val homeFragment = HomeFragment()
            transaction.replace(R.id.fragmentContainer, homeFragment)
            transaction.commit()
        }

        fragmentWeekdayDoBinding.today.setOnClickListener {
            // Dialog만들기
            val mDialogView = LayoutInflater.from(context).inflate(R.layout.today_dialog, null)
            val mBuilder = AlertDialog.Builder(requireContext()).setView(mDialogView)
            val mAlertDialog = mBuilder.show()
            val noButton = mDialogView.findViewById<Button>(R.id.closeButton)
            noButton.setOnClickListener {
                mAlertDialog.dismiss()
            }
            val exercise1 = mDialogView.findViewById<CheckBox>(R.id.exercise1)
            val finish = mDialogView.findViewById<TextView>(R.id.finish)

            exercise1.setOnCheckedChangeListener { compoundButton, b ->
                if (b)
                    finish.text = "완료!"
                else
                    finish.text = " "
            }
        }

        fragmentWeekdayDoBinding.input.setOnClickListener {
            val intent = Intent(requireContext(), InputGoal::class.java)
            startActivity(intent)
        }

        var week_day: Array<String> = resources.getStringArray(R.array.calendar_day)
        calendarAdapter = CalendarAdapter(calendarList)
        calendarList.apply {
            val dateFormat =
                DateTimeFormatter.ofPattern("dd").withLocale(Locale.forLanguageTag("ko"))
            val monthFormat =
                DateTimeFormatter.ofPattern("yyyy년 MM월 dd일").withLocale(Locale.forLanguageTag("ko"))

            val localDate = LocalDateTime.now().format(monthFormat)
            fragmentWeekdayDoBinding.textYearMonth.text = localDate

            var preSunday: LocalDateTime = LocalDateTime.now().with(
                TemporalAdjusters.previous(
                    DayOfWeek.SUNDAY
                )
            )

            for (i in 0..6) {
                Log.d("날짜만", week_day[i])

                calendarList.apply {
                    add(CalendarVO(preSunday.plusDays(i.toLong()).format(dateFormat), week_day[i]))
                }

                Log.d("저번 주 일요일 기준으로 시작!", preSunday.plusDays(i.toLong()).format(dateFormat))
            }
        }
        fragmentWeekdayDoBinding.weekRecycler.adapter = calendarAdapter
        fragmentWeekdayDoBinding.weekRecycler.layoutManager = GridLayoutManager(context, 7)


        val startDate = Calendar.getInstance()
        startDate.add(Calendar.MONTH, -1)

        val endDate = Calendar.getInstance()
        endDate.add(Calendar.MONTH, 1)

/*        fragmentWeekdayDoBinding.timebutton.setOnClickListener{
            openTimePicker()
        }*/

/*
        var mCalendar = Calendar.getInstance()
        val hour: Int
        val min: Int
        if (Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            hour =  fragmentWeekdayDoBinding.timePicker.getHour()
            min =  fragmentWeekdayDoBinding.timePicker.getMinute()
        } else {
            hour =  fragmentWeekdayDoBinding.timePicker.hour
            min =  fragmentWeekdayDoBinding.timePicker.minute
        }

        val isSystem24Hour = is24HourFormat(requireContext())
        val clockFormat = if(isSystem24Hour) TimeFormat.CLOCK_24H else TimeFormat.CLOCK_12H


        hideTimeHeaderLayout(fragmentWeekdayDoBinding.timePicker)

    }*/

/*    private fun openTimePicker() {
        val isSystem24Hour = is24HourFormat(requireContext())
        val clockFormat = if(isSystem24Hour) TimeFormat.CLOCK_24H else TimeFormat.CLOCK_12H

        val picker = MaterialTimePicker.Builder()
            .setTimeFormat(clockFormat)
            .setHour(12)
            .setMinute(0)
            .setTitleText("Set Alarm")
            .build()

        picker.show(childFragmentManager, "TAG")

        picker.addOnPositiveButtonClickListener{
            val h = picker.hour
            val m = picker.minute
        }

        picker.addOnNegativeButtonClickListener {

        }

        picker.addOnCancelListener{

        }

        picker.addOnDismissListener {

        }
    }

    private fun hideTimeHeaderLayout(picker: TimePicker) {
        val id = Resources.getSystem().getIdentifier("time_header", "id", "android")
        val timeLayout = picker.findViewById<View>(id)
        if (timeLayout != null) {
            timeLayout.visibility = View.GONE
        }
    }*/
    }
}
