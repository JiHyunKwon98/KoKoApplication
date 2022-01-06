package com.example.kokoapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.AppCompatTextView
import com.andrewjapar.rangedatepicker.CalendarPicker

import java.util.*

class CalendarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)

        val departure_date : TextView = findViewById(R.id.departure_date)
        val return_date : TextView = findViewById(R.id.return_date)
        val calendar_view : CalendarPicker = findViewById(R.id.calendarview)

        val startDate = Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault())
        val endDate = Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault())
        endDate.add(Calendar.MONTH, 6)

        calendar_view.apply {
            setMode(CalendarPicker.SelectionMode.RANGE) // You can set it via XML
            setRangeDate(startDate.time, endDate.time)
            setSelectionDate(startDate.time, endDate.time)
        }

        calendar_view.setOnRangeSelectedListener { startDate, endDate, startLabel, endLabel ->
            departure_date.text = startLabel
            return_date.text = endLabel
        }

        calendar_view.setOnStartSelectedListener { startDate, label ->
            departure_date.text = label
            return_date.text = "-"
        }


    /*
        추후 변경 예정 !
        val firstCalendarDate = Calendar.getInstance()
        firstCalendarDate.set(2022, 1, 1)

        val secondCalendarDate = Calendar.getInstance()
        secondCalendarDate.time = firstCalendarDate.time
        secondCalendarDate.add(Calendar.YEAR, 1)

        val thirdCalendarDate = Calendar.getInstance()
        thirdCalendarDate.time = firstCalendarDate.time
        thirdCalendarDate.add(Calendar.MONTH, 2)

        calendar_view.setOnRangeSelectedListener { startDate, endDate, startLabel, endLabel ->
            departure_date.text = startLabel
            return_date.text = endLabel
        }

        calendar_view.setOnStartSelectedListener { startDate, label ->
            departure_date.text = label
            return_date.text = "-"
        }
      calendar_view.apply {
            setRangeDate(firstCalendarDate.time, secondCalendarDate.time)
            setSelectionDate(firstCalendarDate.time, thirdCalendarDate.time)
        }*/

    }
}



