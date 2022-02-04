package com.example.kokoapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.EditText
import android.app.DatePickerDialog
import java.util.*
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat

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
            openTimePickerStart()
        }

        finish_time.setInputType(InputType.TYPE_NULL);
        finish_time.setOnClickListener{
            openTimePickerFinish()
        }
    }

    private fun openTimePickerStart() {

        val picker : MaterialTimePicker = MaterialTimePicker.Builder()
            .setTimeFormat(TimeFormat.CLOCK_12H)
            .setHour(12)
            .setMinute(0)
            .setTitleText("Set Alarm")
            .build()


        picker.show(supportFragmentManager, "InputGoalActivity")

        picker.addOnPositiveButtonClickListener{
            val pickedHour = picker.hour
            val pickedMinute = picker.minute
            val formattedTime: String = when {
                pickedHour > 12 -> {
                    if (pickedMinute < 10) {
                        "${picker.hour - 12}:0${picker.minute} pm"
                    } else {
                        "${picker.hour - 12}:${picker.minute} pm"
                    }
                }
                pickedHour == 12 -> {
                    if (pickedMinute < 10) {
                        "${picker.hour}:0${picker.minute} pm"
                    } else {
                        "${picker.hour}:${picker.minute} pm"
                    }
                }
                pickedHour == 0 -> {
                    if (pickedMinute < 10) {
                        "${picker.hour + 12}:0${picker.minute} am"
                    } else {
                        "${picker.hour + 12}:${picker.minute} am"
                    }
                }
                else -> {
                    if (pickedMinute < 10) {
                        "${picker.hour}:0${picker.minute} am"
                    } else {
                        "${picker.hour}:${picker.minute} am"
                    }
                }
            }
            val start_time : EditText = findViewById(R.id.start_time)
            start_time.setText(formattedTime)
        }

        picker.addOnNegativeButtonClickListener {

        }

        picker.addOnCancelListener{

        }

        picker.addOnDismissListener {

        }
    }

    private fun openTimePickerFinish() {

        val picker : MaterialTimePicker = MaterialTimePicker.Builder()
            .setTimeFormat(TimeFormat.CLOCK_12H)
            .setHour(12)
            .setMinute(0)
            .setTitleText("Set Alarm")
            .build()

        picker.show(supportFragmentManager, "InputGoalActivity")

        picker.addOnPositiveButtonClickListener{
            val pickedHour = picker.hour
            val pickedMinute = picker.minute
            val formattedTime: String = when {
                pickedHour > 12 -> {
                    if (pickedMinute < 10) {
                        "${picker.hour - 12}:0${picker.minute} pm"
                    } else {
                        "${picker.hour - 12}:${picker.minute} pm"
                    }
                }
                pickedHour == 12 -> {
                    if (pickedMinute < 10) {
                        "${picker.hour}:0${picker.minute} pm"
                    } else {
                        "${picker.hour}:${picker.minute} pm"
                    }
                }
                pickedHour == 0 -> {
                    if (pickedMinute < 10) {
                        "${picker.hour + 12}:0${picker.minute} am"
                    } else {
                        "${picker.hour + 12}:${picker.minute} am"
                    }
                }
                else -> {
                    if (pickedMinute < 10) {
                        "${picker.hour}:0${picker.minute} am"
                    } else {
                        "${picker.hour}:${picker.minute} am"
                    }
                }
            }
            val finish_time : EditText = findViewById(R.id.finish_time)
            finish_time.setText(formattedTime)
        }

        picker.addOnNegativeButtonClickListener {

        }

        picker.addOnCancelListener{

        }

        picker.addOnDismissListener {

        }
    }
}