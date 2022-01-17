package com.example.kokoapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.EditText
import android.widget.ImageView
import android.widget.DatePicker

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener

import android.view.View
import java.util.*
import android.widget.TimePicker

import android.app.TimePickerDialog
import android.app.TimePickerDialog.OnTimeSetListener


class InputGoal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_goal)

        val startdate : EditText = findViewById(R.id.startdate)
        val finishdate : EditText = findViewById(R.id.finishdate)
        startdate.setInputType(InputType.TYPE_NULL);
        finishdate.setInputType(InputType.TYPE_NULL);

        startdate.setOnClickListener{
            val cldr: Calendar = Calendar.getInstance()
            val day: Int = cldr.get(Calendar.DAY_OF_MONTH)
            val month: Int = cldr.get(Calendar.MONTH)
            val year: Int = cldr.get(Calendar.YEAR)
            // date picker dialog
            var picker: DatePickerDialog

            picker = DatePickerDialog(this@InputGoal,
                { view, year, monthOfYear, dayOfMonth -> startdate.setText(dayOfMonth.toString() + "/" + (monthOfYear + 1) + "/" + year) },
                year,
                month,
                day
            )
            picker.show()
        }

        finishdate.setOnClickListener{
            val cldr: Calendar = Calendar.getInstance()
            val day: Int = cldr.get(Calendar.DAY_OF_MONTH)
            val month: Int = cldr.get(Calendar.MONTH)
            val year: Int = cldr.get(Calendar.YEAR)
            // date picker dialog
            var picker: DatePickerDialog

            picker = DatePickerDialog(this@InputGoal,
                { view, year, monthOfYear, dayOfMonth -> finishdate.setText(dayOfMonth.toString() + "/" + (monthOfYear + 1) + "/" + year) },
                year,
                month,
                day
            )
            picker.show()
        }

        //  spinner mode로 chage 필요
        val start_time : EditText = findViewById(R.id.start_time)
        val finish_time : EditText = findViewById(R.id.finish_time)

        start_time.setInputType(InputType.TYPE_NULL);
        start_time.setOnClickListener{
            val cldr = Calendar.getInstance()
            val hour = cldr[Calendar.HOUR_OF_DAY]
            val minutes = cldr[Calendar.MINUTE]
            // time picker dialog
            val picker: TimePickerDialog
            picker = TimePickerDialog(this@InputGoal,
                { tp, sHour, sMinute -> start_time.setText("$sHour:$sMinute") }, hour, minutes, true
            )
            picker.show()
        }

        finish_time.setInputType(InputType.TYPE_NULL);
        finish_time.setOnClickListener{
            val cldr = Calendar.getInstance()
            val hour = cldr[Calendar.HOUR_OF_DAY]
            val minutes = cldr[Calendar.MINUTE]
            // time picker dialog
            val picker: TimePickerDialog
            picker = TimePickerDialog(this@InputGoal,
                { tp, sHour, sMinute -> finish_time.setText("$sHour:$sMinute") }, hour, minutes, true
            )
            picker.show()
        }




    }
}