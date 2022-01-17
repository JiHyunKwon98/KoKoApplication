package com.example.kokoapplication;

import android.content.Intent
import android.net.Uri
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar.*

class DatePickerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date_picker)

        val picker: DatePicker = findViewById(R.id.datePicker1)


        val minDate = getInstance()
        val maxDate = getInstance()

        minDate.set(2020, 1 - 1, 1);

        picker.setMinDate(minDate.getTime().getTime());

        maxDate.set(2024, 1 - 1, 1);
        picker.setMaxDate(maxDate.getTimeInMillis());

        /*
        val tvw : TextView = findViewById(R.id.textView1)
        val btnGet : Button = findViewById(R.id.button1)

        btnGet.setOnClickListener {
            tvw.setText("Selected Date: "+ picker.getDayOfMonth()+"/"+ (picker.getMonth() + 1)+"/"+picker.getYear());
        }*/

        val chagemode: ImageView = findViewById(R.id.chagemode)

        chagemode.setOnClickListener {
            val intent = Intent(this@DatePickerActivity, WeekActivity::class.java)
            startActivity(intent)
        }

        val gograp: ImageView = findViewById(R.id.gograp)

        val golist: ImageView = findViewById(R.id.golist)

        val gohome: ImageView = findViewById(R.id.gohome)

        val gomy: ImageView = findViewById(R.id.gomy)

        gograp.setOnClickListener {
            val intent = Intent(this@DatePickerActivity, GraphActivity::class.java)
            startActivity(intent)
        }

        golist.setOnClickListener {
            val intent = Intent(this@DatePickerActivity, ManageActivity::class.java)
            startActivity(intent)
        }

        gohome.setOnClickListener {
            val intent = Intent(this@DatePickerActivity, DatePickerActivity::class.java)
            startActivity(intent)
        }

        gomy.setOnClickListener {
            val intent = Intent(this@DatePickerActivity, MyActivity::class.java)
            startActivity(intent)
        }
    }
}
