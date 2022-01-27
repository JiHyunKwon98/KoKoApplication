package com.example.kokoapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView

import java.util.*

class CalendarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)
        val picker : DatePicker = findViewById(R.id.datePicker1)
        val btnGet : Button = findViewById(R.id.button1)
        val tvw : TextView = findViewById(R.id.textView1)
        val minDate = Calendar.getInstance()
        val maxDate = Calendar.getInstance()
        minDate.set(2022,1-1,1);
        picker.setMinDate(minDate.getTime().getTime());
        maxDate.set(2023,1-1,1);
        picker.setMaxDate(maxDate.getTimeInMillis());
        btnGet.setOnClickListener {
            tvw.setText("Selected Date: "+ picker.getDayOfMonth()+"/"+ (picker.getMonth() + 1)+"/"+picker.getYear())
        }
        println("Selected Date: "+ picker.getDayOfMonth()+"/"+ (picker.getMonth() + 1)+"/"+picker.getYear())
    }
}



