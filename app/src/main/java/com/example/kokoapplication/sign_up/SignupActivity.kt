package com.example.kokoapplication.sign_up

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.EditText
import com.example.kokoapplication.R
import java.util.*

class SignupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val startdate : EditText = findViewById(R.id.birth)

        startdate.setInputType(InputType.TYPE_NULL);


        startdate.setOnClickListener{
            val cldr: Calendar = Calendar.getInstance()
            val day: Int = cldr.get(Calendar.DAY_OF_MONTH)
            val month: Int = cldr.get(Calendar.MONTH)
            val year: Int = cldr.get(Calendar.YEAR)
            // date picker dialog
            var picker: DatePickerDialog

            picker = DatePickerDialog(this@SignupActivity,
                { view, year, monthOfYear, dayOfMonth -> startdate.setText(dayOfMonth.toString() + "/" + (monthOfYear + 1) + "/" + year) },
                year,
                month,
                day
            )
            picker.show()
        }
    }
}